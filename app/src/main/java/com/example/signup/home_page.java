package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class home_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    public void order(View view)
    {
        Intent intent = new Intent(this, userProfile.class);
        startActivity(intent);
    }

    public void quotation(View view)
    {
        Intent intent = new Intent(this, userProfile.class);
        startActivity(intent);
    }

    public void reservation(View view)
    {
        Intent intent = new Intent(this, userProfile.class);
        startActivity(intent);
    }

    public void userProfile(View view)
    {
        Intent intent = new Intent(this, userProfile.class);
        startActivity(intent);
    }
}
