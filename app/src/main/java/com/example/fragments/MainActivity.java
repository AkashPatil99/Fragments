package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.task1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent task1Intent = new Intent(MainActivity.this,Task1.class);
                startActivity(task1Intent);
            }
        });

        findViewById(R.id.task2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent task2Intent = new Intent(MainActivity.this,task2.class);
                startActivity(task2Intent);
            }
        });
    }
}