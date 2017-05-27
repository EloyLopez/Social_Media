package edu.lasalle.ppro2.socialmedia.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.lasalle.ppro2.socialmedia.R;
import edu.lasalle.ppro2.socialmedia.Repositories.UsersDBRepo;
import edu.lasalle.ppro2.socialmedia.activities.ListActivity;
import edu.lasalle.ppro2.socialmedia.activities.UsuarioActivity;
import edu.lasalle.ppro2.socialmedia.model.User;

import static edu.lasalle.ppro2.socialmedia.R.id.parent;

/**
 * Created by eloy on 24-05-2017.
 */

public class UserListViewAdapter extends BaseAdapter {
    private List<User> list;
    private Context context;
    private UsersDBRepo usersDBRepo;


    public UserListViewAdapter(List<User> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(R.layout.add_items_list,viewGroup,false);
        final User user=list.get(i);
        TextView name=(TextView) view.findViewById(R.id.text_name);
        name.setText(user.getName());
        TextView surname=(TextView) view.findViewById(R.id.text_surname);
        surname.setText(user.getSurname());
       TextView age=(TextView) view.findViewById(R.id.text_age);
        age.setText(user.getBirthdate());
        ImageView friend=(ImageView) view.findViewById(R.id.image_friend);
        int friend_val=user.getFriend();
        if(friend_val==0)
        {
            friend.setVisibility(View.INVISIBLE);
        }
        else
            friend.setVisibility(View.VISIBLE);
        Button button=(Button) view.findViewById(R.id.button_ver);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(user.getName(),user.getSurname(),user.getBirthdate(),user.getStudies(),String.valueOf(user.getFriend()));

            }
        });
        return view;
    }
    public void changeActivity( String name,String surname,String birthdate,String studies,String friend){
        Intent intent=new Intent(context,UsuarioActivity.class);
        intent.putExtra("name",name);
        intent.putExtra("surname",surname);
        intent.putExtra("birthdate",birthdate);
        intent.putExtra("studies",studies);
       intent.putExtra("friend",friend);

        context.startActivity(intent);
    }
    public void refresh(List<User> items)
    {
        this.list = items;
        notifyDataSetChanged();
    }
}
