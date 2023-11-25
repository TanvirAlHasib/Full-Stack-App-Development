package com.stardust.homework_2324;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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


        edNumber = findViewById(R.id.edNumber);
        tvDisplay = findViewById(R.id.tvDisplay);
        bCalculate = findViewById(R.id.bCalculate);

        // functional work start

        bCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edNumber.getText().toString().length() > 0){

                    double number = Integer.parseInt(edNumber.getText().toString());
                    tvDisplay.setVisibility(View.VISIBLE);
                    tvDisplay.setText("The square natural upto"+number +"terms are :\n");
                    double sum = 0;

                    for (int i = 1; i <= number; i++) {

                       tvDisplay.append((i*i)+" ");
                       sum = sum + (i*i);

                    }

                    tvDisplay.append("\nThe Sum of Square Natural Number upto "+number+
                            "terms: "+sum);

                } else {



                }
            }
        });


    }
}