package com.stardust.homework_2322;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edNumber;
    TextView tvDisplay;
    Button bCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //variable intro section

        edNumber = findViewById(R.id.edNumber);
        tvDisplay = findViewById(R.id.tvDisplay);
        bCalculate = findViewById(R.id.bCalculate);



    }
}