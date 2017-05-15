package edu.lasalle.ppro2.socialmedia.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import edu.lasalle.ppro2.socialmedia.R;

public class AddUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_usuario);
        getSupportActionBar().hide();

    }
    public void back_toolBar(View view){
        onBackPressed();
    }
}
