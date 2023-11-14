package com.stardust.homework_2321;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edNumber;
    Button button;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //variable intro

        edNumber = findViewById(R.id.edNumber);
        button = findViewById(R.id.button);
        tvDisplay = findViewById(R.id.tvDisplay);


    }
}