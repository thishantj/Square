package com.example.rest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;



public class MainActivity extends AppCompatActivity {
    dbhelper Mydb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mydb = new dbhelper(this);

        Button button = (Button) findViewById(R.id.buttonOk);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity2();
            }
        });


    }
        public void activity2() {
            Intent intent = new Intent(this, activity2.class);
            startActivity(intent);
        }

}
