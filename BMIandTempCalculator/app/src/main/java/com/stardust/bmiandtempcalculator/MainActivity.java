package com.stardust.bmiandtempcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView privacy,tvBMI,tvFah,tvKel;
    EditText edWeight,edHeightFt,edHeightInch,edCelsius,edFahrenheit;
    Button BMI_calculate,fahCalculate,kelvinCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}