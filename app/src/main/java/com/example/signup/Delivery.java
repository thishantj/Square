package com.example.signup;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delivery extends AppCompatActivity {

    DBHelper db;

    public static final String Name = "name";
    public static final String Address = "address";
    public static final String Tel = "tel";
    public static final String NIC = "nic";

    private EditText name, address, tel, Nic;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        db = new DBHelper(this);

        name = findViewById(R.id.txtName3);
        address = findViewById(R.id.txtAddress3);
        tel = findViewById(R.id.txtTel3);
        Nic = findViewById(R.id.txtNIC);


        submit = findViewById(R.id.btnSubmit);

    }


    public void Submit(View view) {
        String nme = name.getText().toString();
        String addr = address.getText().toString();
        String telephne = tel.getText().toString();
        String nic = Nic.getText().toString();


        if (nic.equals("") || nme.equals("") || addr.equals("") || telephne.equals("") ) {
            Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
        } else {
            Boolean insert = db.insertData(nme, addr, Integer.parseInt(telephne), nic );
            if (insert == true) {
                Toast.makeText(getApplicationContext(), "Inserted successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Not inserted", Toast.LENGTH_SHORT).show();
            }
        }


        Intent intent = new Intent(this, order_s.class);

        intent.putExtra(Name, nme);
        intent.putExtra(Address, addr);
        intent.putExtra(Tel, telephne);
        intent.putExtra(NIC, nic);
        startActivity(intent);
    }
}



