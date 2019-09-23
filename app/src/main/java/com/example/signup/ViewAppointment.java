package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ViewAppointment extends AppCompatActivity {

  //  private EditText name, address, tel, nic;

    private EditText apptid,apptdetails,date,time;
    String nme, addr, telephne, nic;
    Button updatenew, deletenew;
    DBHelperAPP db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        db = new DBHelperAPP(this);

        apptid = findViewById(R.id.txtName);
        apptdetails = findViewById(R.id.txtAddress);
        date = findViewById(R.id.txtTel);
        time = findViewById(R.id.txtNIC2);
        updatenew = findViewById(R.id.btnUpdate);
        deletenew = findViewById(R.id.btnDelete);

        Intent intent = getIntent();

        nme = intent.getStringExtra(CreateAppointment.ApptId);
        addr = intent.getStringExtra(CreateAppointment.ApptDetails);
        telephne = intent.getStringExtra(CreateAppointment.Date);
        nic = intent.getStringExtra(CreateAppointment.Time);


        apptid.setText(nme);
        apptdetails.setText(addr);
        date.setText(telephne);
        time.setText(nic);

    }

    public void main(View view){
        Intent intent = new Intent(this, home_page.class);
        startActivity(intent);
    }

    public void update(View view){
        Boolean isUpdated = db.updateData(apptid.getText().toString(), apptdetails.getText().toString(), Integer.parseInt(date.getText().toString()), time.getText().toString());

        if (isUpdated == true){
            Toast.makeText(getApplicationContext(),"Updated successfully",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),"Error in updating",Toast.LENGTH_SHORT).show();
        }
    }

    public void delete(View view){
        Integer deletedRows = db.deleteData(time.getText().toString());

        if (deletedRows != 0){
            Toast.makeText(getApplicationContext(),"Deleted successfully",Toast.LENGTH_SHORT).show();

            apptid.setText("");
            apptdetails.setText("");
            date.setText("");
            time.setText("");

            Intent intent = new Intent(this, CreateAppointment.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(),"Error in deleting",Toast.LENGTH_SHORT).show();
        }
    }
}

