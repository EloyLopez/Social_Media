package edu.lasalle.ppro2.socialmedia.activities;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Objects;

import edu.lasalle.ppro2.socialmedia.R;
import edu.lasalle.ppro2.socialmedia.Repositories.UsersDBRepo;
import edu.lasalle.ppro2.socialmedia.Repositories.impl.UsersDB;


public class UsuarioActivity extends AppCompatActivity {
    TextView name;
    TextView surname;
    TextView date;
    TextView studies;
    TextView friends;
    Button amigo;
    UsersDBRepo usersDBRepo;
    String friend_tmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        getSupportActionBar().hide();
        String name_tmp=getIntent().getStringExtra("name");
        String surname_tmp= getIntent().getStringExtra("surname");
        String date_tmp=getIntent().getStringExtra("birthdate");
        String studies_tmp= getIntent().getStringExtra("studies");
        friend_tmp=getIntent().getStringExtra("friend");
        usersDBRepo=new UsersDB(this);

        name=(TextView) findViewById(R.id.text_name);
        name.setText(name_tmp);
        surname=(TextView) findViewById(R.id.text_surname);
        surname.setText(surname_tmp);
        date=(TextView) findViewById(R.id.text_date);
        date.setText(date_tmp);
        studies=(TextView)findViewById(R.id.text_studies);
        studies.setText(studies_tmp);
        friends=(TextView)findViewById(R.id.text_friend);
        amigo=(Button) findViewById(R.id.button_friend);
        if (Objects.equals(friend_tmp, "0"))
        {
            friends.setText("Is not my friend");
        }
        else if (Objects.equals(friend_tmp, "1"))
        {
            friends.setText("Is my friend");
        }



        amigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Objects.equals(friend_tmp, "0"))
                {
                    usersDBRepo.update(name.getText().toString(),surname.getText().toString(),1);
                    friends.setText("Is my friend");
                    friend_tmp="1";

                }
                else
                {
                    usersDBRepo.update(name.getText().toString(),surname.getText().toString(),0);
                    friends.setText("Is not my friend");
                    friend_tmp="0";
                }


            }
        });
    }


    public void back_toolBar(View view){
        onBackPressed();
    }
}
