package com.stardust.grade_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        bCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((physics.getText().toString().length()) > 0 && (chemistry.getText().toString().length()) > 0 && (math.getText().toString().length()) > 0 && (biology.getText().toString().length()) > 0 && (computer.getText().toString().length()) > 0){
                    float phy = Float.parseFloat(physics.getText().toString());
                    float chem = Float.parseFloat(chemistry.getText().toString());
                    float maath = Float.parseFloat(math.getText().toString());
                    float bio = Float.parseFloat(biology.getText().toString());
                    float comp = Float.parseFloat(computer.getText().toString());

                    if ((phy >= 0 && phy <= 100) && (chem >= 0 && (chem <= 100)) && (maath >= 0 && maath <= 100) && (bio >= 0 && bio <= 100) && (comp >= 0 && comp <= 100)){
                        float percentage = (phy + chem + maath + bio + comp) / 5;
                        if (percentage >= 90){
                            tvDisplay.setText("Grade A & percentage is "+percentage+"%");
                        } else if (percentage >= 80) {
                            tvDisplay.setText("Grade B & percentage is "+percentage+"%");
                        } else if (percentage >= 70) {
                            tvDisplay.setText("Grade C & percentage is "+percentage+"%");
                        } else if (percentage >= 60) {
                            tvDisplay.setText("Grade D & percentage is "+percentage+"%");
                        } else if (percentage >= 40) {
                            tvDisplay.setText("Grade E & percentage is "+percentage+"%");
                        } else {
                            tvDisplay.setText("Grade F & percentage is "+percentage+"%");
                        }
                    }else {
                        tvDisplay.setText("Please enter decent number");
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Please enter number in every form", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}