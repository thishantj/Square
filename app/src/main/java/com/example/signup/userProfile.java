package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class userProfile extends AppCompatActivity {

    private EditText name, address, tel, username, password;
    String nme, addr, telephne, usrname, pass;
    Button update, delete;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        db = new DatabaseHelper(this);

        name = findViewById(R.id.txtName2);
        address = findViewById(R.id.txtAddress2);
        tel = findViewById(R.id.txtTel2);
        username = findViewById(R.id.txtUsername2);
        password = findViewById(R.id.txtPassword2);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);

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

    public void update(View view){
        Boolean isUpdated = db.update(name.getText().toString(), address.getText().toString(), tel.getText().toString(), username.getText().toString(), password.getText().toString());

        if (isUpdated == true){
            Toast.makeText(getApplicationContext(),"Updated successfully",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),"Error in updating",Toast.LENGTH_SHORT).show();
        }
    }

    public void delete(View view){
        Integer deletedRows = db.delete(username.getText().toString());

        if (deletedRows != 0){
            Toast.makeText(getApplicationContext(),"Deleted successfully",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(),"Error in deleting",Toast.LENGTH_SHORT).show();
        }
    }
}
