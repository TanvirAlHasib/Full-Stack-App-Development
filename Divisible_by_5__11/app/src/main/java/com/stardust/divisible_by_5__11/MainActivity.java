package com.stardust.divisible_by_5__11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        bCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((edNumber.getText().toString().length()) > 0){
                    double number = Double.parseDouble(edNumber.getText().toString());
                    if(number == 0){
                        tvDisplay.setText("0 is not acceptable");
                    } else if ((number%5==0) && (number%11==0)){
                        tvDisplay.setText(number+" is divisible by 11 and 5");
                    } else if (number%5 == 0) {
                        tvDisplay.setText(number+" is only divisible by 5");
                    } else if (number%11 == 0) {
                        tvDisplay.setText(number+" is only divisible by 11");
                    } else if ((number%5 != 0) && (number%11 != 0)){
                        tvDisplay.setText(number+" is not divisible by 11 and 5");
                    }
                } else {
                    edNumber.setError("Please enter number");
                    Toast.makeText(MainActivity.this, "Please enter number", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}