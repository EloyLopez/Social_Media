package edu.lasalle.ppro2.socialmedia.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import edu.lasalle.ppro2.socialmedia.R;
import edu.lasalle.ppro2.socialmedia.Repositories.UsersDBRepo;
import edu.lasalle.ppro2.socialmedia.Repositories.impl.UsersDB;
import edu.lasalle.ppro2.socialmedia.model.User;

public class AddUsuarioActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_add_usuario);
        getSupportActionBar().hide();
        usersDBRepo = new UsersDB(this);
        name=(EditText) findViewById(R.id.edit_name);
        surname=(EditText) findViewById(R.id.edit_surname);
        gender=(Spinner) findViewById(R.id.spinner);
        studies=(EditText) findViewById(R.id.edit_studies);
        date=(EditText) findViewById(R.id.edit_date);
        button=(Button) findViewById(R.id.button2);

        getSupportActionBar().hide();


    }

    public void AddUser(View view)
    {
        User user=new User(name.getText().toString(),surname.getText().toString(),gender.getSelectedItem().toString(),
                date.getText().toString(), studies.getText().toString(),0);
        usersDBRepo.addUser(user);
        reset();
        Toast.makeText(this,getResources().getString(R.string.user_add),Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(AddUsuarioActivity.this,ListActivity.class);
        startActivity(intent);
    }
    public void back_toolBar(View view){
        onBackPressed();
    }
    private void reset() {
        name.setText("");
        surname.setText("");
        studies.setText("");
        date.setText("");
        gender.setSelection(0);

    }
}
