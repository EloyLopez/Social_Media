package edu.lasalle.ppro2.socialmedia.activities;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import edu.lasalle.ppro2.socialmedia.R;

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_menu);

    }
    public void list_click(View view)
    {
        Intent intent=new Intent(MenuActivity.this,ListActivity.class);
        startActivity(intent);
    }
    public void add_click(View view)
    {
        Intent intent=new Intent(MenuActivity.this,AddUsuarioActivity.class);
        startActivity(intent);
    }
    public void exit_click(View view){
        finish();
    }

}
