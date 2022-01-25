package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class task2 extends AppCompatActivity {

    final FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);

        final Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer2);
        if (fragment == null) {
            final FragmentFactory fragmentFactory = fragmentManager.getFragmentFactory();
            final String Fragment2Name = Fragment2.class.getName();
            final Fragment fragment2 = fragmentFactory.instantiate(getClassLoader(), Fragment2Name);

            final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragmentContainer2, fragment2);
            fragmentTransaction.commit();
        }

        setUpFragment1Button();
        setUpFragment2Button();
    }

    private void setUpFragment2Button() {
        Button fragment2 = findViewById(R.id.secondFragment);
        fragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer2);

                if (!(fragment instanceof SecondFragment)) {
                    final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    final SecondFragment secondFragment = new SecondFragment();
                    fragmentTransaction.replace(R.id.fragmentContainer2, secondFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });

    }

    private void setUpFragment1Button() {
        Button fragment1 = findViewById(R.id.firstFragment);
        fragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer2);

                if (!(fragment instanceof FirstFragment)) {
                    final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    final FirstFragment firstFragment = new FirstFragment();
                    fragmentTransaction.replace(R.id.fragmentContainer2, firstFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });

    }
}