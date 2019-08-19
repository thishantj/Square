package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class userProfile extends AppCompatActivity {

    private EditText name, address, tel, username, password;
    String nme, addr, telephne, usrname, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        name = findViewById(R.id.txtName2);
        address = findViewById(R.id.txtAddress2);
        tel = findViewById(R.id.txtTel2);
        username = findViewById(R.id.txtUsername2);
        password = findViewById(R.id.txtPassword2);

        Intent intent = getIntent();

        nme = intent.getStringExtra(Signup.Name);
        addr = intent.getStringExtra(Signup.Address);
        telephne = intent.getStringExtra(Signup.Tel);
        usrname = intent.getStringExtra(Signup.Username);
        pass = intent.getStringExtra(Signup.Password);

        name.setText(nme);
        address.setText(addr);
        tel.setText(telephne);
        username.setText(usrname);
        password.setText(pass);
    }

    public void main(View view)
    {
        Intent intent = new Intent(this, home_page.class);
        startActivity(intent);
    }
}
