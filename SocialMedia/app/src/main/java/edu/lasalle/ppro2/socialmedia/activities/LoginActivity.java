package edu.lasalle.ppro2.socialmedia.activities;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.lasalle.ppro2.socialmedia.R;

public class LoginActivity extends AppCompatActivity {
    EditText mail;
    EditText password;
    Button enter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        mail=(EditText) findViewById(R.id.LoginMail);
        password=(EditText) findViewById(R.id.LoginPassword);
        enter=(Button) findViewById(R.id.button);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isValidEmail(mail.getText().toString())!=false){
                    if(password.getText().toString().length()>=6) {
                        Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                        startActivity(intent);
                    }
                }



            }
        });

    }
    public final static boolean isValidEmail(String target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }



}
