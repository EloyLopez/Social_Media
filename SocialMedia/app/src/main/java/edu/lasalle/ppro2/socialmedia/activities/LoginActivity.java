package edu.lasalle.ppro2.socialmedia.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

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
                Intent intent=new Intent(LoginActivity.this,MenuActivity.class);
               startActivity(intent);

            }
        });


    }


}
