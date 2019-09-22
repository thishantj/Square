package com.example.rest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


    public class order_summary extends Delivery {

        private EditText name, address, tel, nic;
        String nme, addr, telephne, ni;
        Button update, delete;
        DatabaseHelper db;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_order_summ);

            db = new DatabaseHelper(this);

            name = findViewById(R.id.txtName);
            address = findViewById(R.id.txtAddress);
            tel = findViewById(R.id.txtTel);
            nic = findViewById(R.id.txtNIC2);

            update = findViewById(R.id.btnUpdate);
            delete = findViewById(R.id.btnDelete);

            Intent intent = getIntent();

            nme = intent.getStringExtra(Delivery.Name);
            addr = intent.getStringExtra(Delivery.Address);
            telephne = intent.getStringExtra(Delivery.Tel);
            ni = intent.getStringExtra(Delivery.NIC);


            name.setText(nme);
            address.setText(addr);
            tel.setText(telephne);
            nic.setText(ni);

        }

        public void main(View view){
            Intent intent = new Intent(this, Delivery.class);
            startActivity(intent);
        }

        public void update(View view){
            Boolean isUpdated = db.updateData(name.getText().toString(), address.getText().toString(), Integer.parseInt(tel.getText().toString()), nic.getText().toString());

            if (isUpdated == true){
                Toast.makeText(getApplicationContext(),"Updated successfully",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(),"Error in updating",Toast.LENGTH_SHORT).show();
            }
        }

        public void delete(View view){
            Integer deletedRows = db.deleteData(nic.getText().toString());

            if (deletedRows != 0){
                Toast.makeText(getApplicationContext(),"Deleted successfully",Toast.LENGTH_SHORT).show();

                name.setText("");
                address.setText("");
                tel.setText("");
                nic.setText("");

                Intent intent = new Intent(this, Delivery.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(),"Error in deleting",Toast.LENGTH_SHORT).show();
            }
        }
    }

