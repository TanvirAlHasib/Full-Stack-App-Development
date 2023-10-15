package com.stardust.functioning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button tapme, More, back;
    LinearLayout primary, secondry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tapme = findViewById(R.id.tapme);
        More = findViewById(R.id.More);
        back = findViewById(R.id.back);
        primary = findViewById(R.id.primary);
        secondry = findViewById(R.id.secondry);

        tapme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"You are going to know me",Toast.LENGTH_SHORT).show();
                primary.setVisibility(View.GONE);
                secondry.setVisibility(View.VISIBLE);
            }
        });

        More.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(myintent);
                Toast.makeText(MainActivity.this,"wait a second",Toast.LENGTH_SHORT).show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary.setVisibility(View.VISIBLE);
                secondry.setVisibility(View.GONE);
            }
        });

    }
}