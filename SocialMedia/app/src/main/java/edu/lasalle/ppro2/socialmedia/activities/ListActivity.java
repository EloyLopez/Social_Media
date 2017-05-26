package edu.lasalle.ppro2.socialmedia.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.lasalle.ppro2.socialmedia.R;
import edu.lasalle.ppro2.socialmedia.Repositories.UsersDBRepo;
import edu.lasalle.ppro2.socialmedia.Repositories.impl.UsersDB;
import edu.lasalle.ppro2.socialmedia.adapters.UserListViewAdapter;
import edu.lasalle.ppro2.socialmedia.model.User;

public class ListActivity extends AppCompatActivity {


    UserListViewAdapter adapter;
    UsersDBRepo usersDBRepo;
    ListView listView;
    List<User> user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        user=new ArrayList<>();
        usersDBRepo=new UsersDB(this);
        user.addAll(usersDBRepo.getAllusers());
        adapter=new UserListViewAdapter(user,this);
         listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        getSupportActionBar().hide();


    }

    @Override
    public void onResume(){
        super.onResume();
       user.clear();
        user=usersDBRepo.getAllusers();
        adapter.refresh(user);
    }
}
