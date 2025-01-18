package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView R1btn2, R1btn1, R2btn1, R3btn3, R1btn3, R3btn1,R4btn1,R3btn2,R4btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Views
        R1btn2 = findViewById(R.id.R1btn2);
        R1btn1 = findViewById(R.id.R1btn1);
        R2btn1 = findViewById(R.id.R2btn1);
        R3btn3 = findViewById(R.id.R3btn3);
        R1btn3 = findViewById(R.id.R1btn3);
        R3btn1 = findViewById(R.id.R3btn1);
        R4btn1=findViewById(R.id.R4btn1);
        R3btn2=findViewById(R.id.R3btn2);
        R4btn2=findViewById(R.id.R4btn2);


        R1btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AgeActivity.class);
                startActivity(intent);
            }
        });

        R1btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BmiActivity.class);
                startActivity(intent);
            }
        });

        R2btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LengthActivity.class);
                startActivity(intent);
            }
        });

        R3btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, numberConversion.class);
                startActivity(intent);
            }
        });

        R1btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TemperatureActivity.class);
                startActivity(intent);
            }
        });

        R3btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AreaActivity.class);
                startActivity(intent);
            }
        });
        R4btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SpeedActivity.class);
                startActivity(intent);
            }
        });
        R3btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TimeActivity.class);
                startActivity(intent);
            }
        });
        R4btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DiscountActivity.class);
                startActivity(intent);
            }
        });

    }
}
