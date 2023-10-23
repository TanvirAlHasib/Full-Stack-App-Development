package com.stardust.max_number;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edNumber_1,edNumber_2,edNumber_3;
    Button bCalculate;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNumber_1 = findViewById(R.id.edNumber_1);
        edNumber_2 = findViewById(R.id.edNumber_2);
        edNumber_3 = findViewById(R.id.edNumber_3);
        bCalculate = findViewById(R.id.bCalculate);
        tvDisplay = findViewById(R.id.tvDisplay);
        
        bCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((edNumber_1.getText().toString().length()) > 0) && ((edNumber_2.getText().toString().length()) > 0 )&& ((edNumber_3.getText().toString().length()) > 0)){
                    int number_1 = Integer.parseInt(edNumber_1.getText().toString());
                    int number_2 = Integer.parseInt(edNumber_2.getText().toString());
                    int number_3 = Integer.parseInt(edNumber_3.getText().toString());
                    if ((number_1 > number_2) && (number_1 > number_3)){
                        if (number_2 >= number_3){
                            tvDisplay.setText("number sequence is "+number_1+">"+number_2+">"+number_3);
                        }else {
                            tvDisplay.setText("number sequence is "+number_1+">"+number_3+">"+number_2);
                        }
                    } else if ((number_2 > number_1) && (number_2 > number_3)) {
                        if (number_1 >= number_3){
                            tvDisplay.setText("number sequence is "+number_2+">"+number_1+">"+number_3);
                        }
                        else {
                            tvDisplay.setText("number sequence is "+number_2+">"+number_3+">"+number_1);
                        }
                    } else if ((number_3 > number_2) && (number_3 > number_1)) {
                        if (number_1 >= number_2){
                            tvDisplay.setText("number sequence is "+number_3+">"+number_1+">"+number_2);
                        }
                        else {
                            tvDisplay.setText("number sequence is "+number_3+">"+number_2+">"+number_1);
                        }
                    }else {
                        tvDisplay.setText("number sequence is "+number_2+"="+number_1+"="+number_3);
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Please fillup every input box", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}