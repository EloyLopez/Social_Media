package edu.lasalle.ppro2.socialmedia.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.lasalle.ppro2.socialmedia.R;
import edu.lasalle.ppro2.socialmedia.Repositories.UsersDBRepo;
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
        User user=list.get(i);
        TextView name=(TextView) view.findViewById(R.id.text_name);
        name.setText(user.getName());
        return view;
    }
}
