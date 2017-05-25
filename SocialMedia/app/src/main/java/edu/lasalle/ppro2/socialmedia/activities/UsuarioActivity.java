package edu.lasalle.ppro2.socialmedia.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

import edu.lasalle.ppro2.socialmedia.R;
import edu.lasalle.ppro2.socialmedia.Repositories.UsersDBRepo;
import edu.lasalle.ppro2.socialmedia.Repositories.impl.UsersDB;
import edu.lasalle.ppro2.socialmedia.model.User;

public class UsuarioActivity extends AppCompatActivity {
    EditText name;
    EditText surname;
    Spinner gender;
    EditText date;
    EditText studies;
    UsersDBRepo usersDBRepo;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        getSupportActionBar().hide();


    }
    public void back_toolBar(View view){
        onBackPressed();
    }
}
