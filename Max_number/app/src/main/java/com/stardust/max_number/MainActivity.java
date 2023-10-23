package com.stardust.max_number;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edNumber_1,edNumber_2,edNumber_3;
    Button bCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNumber_1 = findViewById(R.id.edNumber_1);
        edNumber_2 = findViewById(R.id.edNumber_2);
        edNumber_3 = findViewById(R.id.edNumber_3);

    }
}