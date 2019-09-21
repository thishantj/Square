package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText password, username;
    Button login, register;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHelper(this);

        username = findViewById(R.id.txtUsername);
        password = findViewById(R.id.txtPassword);

        login = findViewById(R.id.btnLogin);
        register = findViewById(R.id.btnRegister);
    }

    public void register(View view)
    {
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }

    public void login(View view)
    {
        String usrname = username.getText().toString();
        String pass = password.getText().toString();

        Boolean chkUsernamePassword = db.usernamePassword(usrname, pass);

        if (chkUsernamePassword == true){
            Intent intent = new Intent(this, home_page.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"Username or password is incorrect",Toast.LENGTH_SHORT).show();
        }


    }
}
