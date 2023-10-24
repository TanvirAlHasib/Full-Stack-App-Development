package com.stardust.grade_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText physics, chemistry, math, biology, computer;
    TextView tvDisplay;
    Button bCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        physics = findViewById(R.id.physics);
        chemistry = findViewById(R.id.chemistry);
        math = findViewById(R.id.math);
        biology = findViewById(R.id.biology);
        computer = findViewById(R.id.computer);
        tvDisplay = findViewById(R.id.tvDisplay);
        bCalculate = findViewById(R.id.bCalculate);

    }
}