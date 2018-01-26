package com.example.lenovo.workshop;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Intent i = getIntent();
        String username = i.getStringExtra("username");
        Bundle bundle = new Bundle();
        bundle.putString("username",username);
        FragmentManager fm;
        FragmentTransaction fragmentTransaction;
        fm = getSupportFragmentManager();
        AvailableWorkshop availableWorkshop= new AvailableWorkshop();
        availableWorkshop.setArguments(bundle);
        fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.flayout,availableWorkshop);
    }
}
