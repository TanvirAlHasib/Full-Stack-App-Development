package com.stardust.bmiandtempcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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

        privacy = findViewById(R.id.privacy);
        tvBMI = findViewById(R.id.tvBMI);
        tvFah = findViewById(R.id.tvFah);
        tvKel =findViewById(R.id.tvKel);
        edWeight = findViewById(R.id.edWeight);
        edHeightFt = findViewById(R.id.edHeightFt);
        edHeightInch = findViewById(R.id.edHeightInch);
        edCelsius = findViewById(R.id.edCelsius);
        edFahrenheit = findViewById(R.id.edFahrenheit);
        BMI_calculate = findViewById(R.id.BMI_calculate);
        fahCalculate = findViewById(R.id.fahCalculate);
        kelvinCalculate = findViewById(R.id.kelvinCalculate);

        // for bmi calculation

        BMI_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float weight = Float.parseFloat(edWeight.getText().toString());
                float heightft = Float.parseFloat(edHeightFt.getText().toString());
                float heightinch = Float.parseFloat(edHeightInch.getText().toString());

                // height in meter convertion

                double heightmeter = (0.3048*heightft) + (0.0254*heightinch);

                // BMI

                double BMI = (weight/(heightmeter*heightmeter));

                // comdition

                if ( BMI <= 18.5){

                    tvBMI.setText("Your BMI is "+BMI+"\nYou are Underweight, you should eat properly");
                }

                if ((BMI > 18.5) && (BMI <= 24.9) ){

                    tvBMI.setText("Your BMI is "+BMI+"\nYou have Normal weight, you should eat as you eat everyday");
                }

                if ((BMI >= 25) && (BMI<=29.9)){

                    tvBMI.setText("Your BMI is "+BMI+"\nYou are Overweight, you should eat less and exercise");
                }

                if (BMI >= 30){

                    tvBMI.setText("Your BMI is "+BMI+"\nYou are Overweight, you should eat less and exercise more");
                }
            }
        });

    }
}