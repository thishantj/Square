package com.example.signup;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAppointment extends AppCompatActivity {

    DBHelperAPP db;

    public static final String ApptId = "apptid";
    public static final String ApptDetails = "apptdetails";
    public static final String Date = "date";
    public static final String Time = "time";

    private EditText apptid,apptdetails,date,time;
    private Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        db = new DBHelperAPP(this);

        apptid = findViewById(R.id.txtName3);
        apptdetails = findViewById(R.id.txtAddress3);
        date = findViewById(R.id.txtTel3);
        time = findViewById(R.id.txtNIC);
        create = findViewById(R.id.btnSubmit);
    }

    public void Submit(View view) {
        String nme = apptid.getText().toString();
        String addr = apptdetails.getText().toString();
        String telephne = date.getText().toString();
        String nic = time.getText().toString();


        if (nic.equals("") || nme.equals("") || addr.equals("") || telephne.equals("") ) {
            Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
        } else {
            Boolean insert = db.insertData(nme, addr, Integer.parseInt(telephne), nic );
            if (insert == true) {
                Toast.makeText(getApplicationContext(), "Created successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Appointment ID already exists", Toast.LENGTH_SHORT).show();
            }
        }


        Intent intent = new Intent(this, ViewAppointment.class);

        intent.putExtra(ApptId, nme);
        intent.putExtra(ApptDetails, addr);
        intent.putExtra(Date, telephne);
        intent.putExtra(Time, nic);
        startActivity(intent);
    }
}



