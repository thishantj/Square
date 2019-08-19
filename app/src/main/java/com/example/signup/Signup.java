package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Signup extends AppCompatActivity {

    public static final String Name = "name";
    public static final String Address = "address";
    public static final String Tel = "tel";
    public static final String Username = "username";
    public static final String Password = "password";

    private EditText name, address, tel, username, password, confirmPass;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = findViewById(R.id.txtName);
        address = findViewById(R.id.txtAddress);
        tel = findViewById(R.id.txtTel);
        username = findViewById(R.id.txtUsername);
        password = findViewById(R.id.txtPassword);
        confirmPass = findViewById(R.id.txtConfirmpassword);

        register = findViewById(R.id.btnRegister);
    }

    public void register(View view)
    {
        String nme = name.getText().toString();
        String addr = address.getText().toString();
        String telephne = tel.getText().toString();
        String usrname = username.getText().toString();
        String pass = password.getText().toString();

        Intent intent = new Intent(this, userProfile.class);

        intent.putExtra(Name, nme);
        intent.putExtra(Address, addr);
        intent.putExtra(Tel, telephne);
        intent.putExtra(Username, usrname);
        intent.putExtra(Password, pass);

        startActivity(intent);
    }

    public void login(View view)
    {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
