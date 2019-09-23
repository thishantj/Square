package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    DatabaseHelper db;

    public static final String Name = "name";
    public static final String Address = "address";
    public static final String Tel = "tel";
    public static final String Username = "username";
    public static final String Password = "password";

    private EditText name, address, tel, username, password, confirmPass;
    private Button register, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        db = new DatabaseHelper(this);

        name = findViewById(R.id.txtName);
        address = findViewById(R.id.txtAddress);
        tel = findViewById(R.id.txtTel);
        username = findViewById(R.id.txtUsername);
        password = findViewById(R.id.txtPassword);
        confirmPass = findViewById(R.id.txtConfirmpassword);

        register = findViewById(R.id.btnRegister);
        login = findViewById(R.id.btnLogin);
    }

    public void register(View view) {
        String nme = name.getText().toString();
        String addr = address.getText().toString();
        String telephne = tel.getText().toString();
        String usrname = username.getText().toString();
        String pass = password.getText().toString();
        String cpass = confirmPass.getText().toString();

        if (usrname.equals("") || nme.equals("") || addr.equals("") || telephne.equals("") || pass.equals("")) {
            Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
        } else {
            if (pass.equals(cpass)) {
                Boolean chkUsername = db.chkUsername(usrname);
                if (chkUsername == true) {

                        Boolean insert = db.insertData(nme, addr, Integer.parseInt(telephne), usrname, pass);
                        if (insert == true) {
                            Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Username already exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else {
                Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
            }


                Intent intent = new Intent(this, userProfile.class);

                intent.putExtra(Name, nme);
                intent.putExtra(Address, addr);
                intent.putExtra(Tel, telephne);
                intent.putExtra(Username, usrname);
                intent.putExtra(Password, pass);

                startActivity(intent);
            }
        }


    public void login(View view)
    {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}

