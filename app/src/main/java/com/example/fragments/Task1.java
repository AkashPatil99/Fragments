package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Task1 extends AppCompatActivity {

    final FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);

        final Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);
        if (fragment == null) {
            final FragmentFactory fragmentFactory = fragmentManager.getFragmentFactory();
            final String Fragment1Name = Fragment1.class.getName();
            final Fragment Fragment1 = fragmentFactory.instantiate(getClassLoader(), Fragment1Name);

            final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragmentContainer, Fragment1);
            fragmentTransaction.commit();
        }

        setUpTimeButton();
        setUpDateButton();
        setUpBatteryButton();
    }


    private void setUpBatteryButton() {

        Button battery = findViewById(R.id.battery);
        battery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
                Intent batteryStatus = registerReceiver(null, ifilter);
                int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                final Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);

                if (!(fragment instanceof BatteryFragment)) {
                    final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    final BatteryFragment batteryFragment = BatteryFragment.newInstance("Battery Level:"+level);
                    fragmentTransaction.replace(R.id.fragmentContainer, batteryFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });
    }

    private void setUpDateButton() {
        Button date = findViewById(R.id.date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                final Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);

                if (!(fragment instanceof DateFragment)) {
                    final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    final DateFragment dateFragment = DateFragment.newInstance(currentDate);
                    fragmentTransaction.replace(R.id.fragmentContainer, dateFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }

            }
        });
    }

    private void setUpTimeButton() {
        Button time = findViewById(R.id.time);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
                final Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);

                if (!(fragment instanceof TimeFragment)) {
                    final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    final TimeFragment timeFragment = TimeFragment.newInstance(currentTime);
                    fragmentTransaction.replace(R.id.fragmentContainer, timeFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }

}