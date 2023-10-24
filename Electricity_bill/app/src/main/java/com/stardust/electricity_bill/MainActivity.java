package com.stardust.electricity_bill;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edUnits;
    TextView tvDisplay;
    Button bCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edUnits = findViewById(R.id.edUnits);
        tvDisplay = findViewById(R.id.tvDisplay);
        bCalculate = findViewById(R.id.bCalculate);

    }
}