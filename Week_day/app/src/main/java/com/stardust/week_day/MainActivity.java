package com.stardust.week_day;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edWeekNumber;
    TextView tvDisplay;
    Button bCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edWeekNumber = findViewById(R.id.edWeekNumber);
        tvDisplay = findViewById(R.id.tvDisplay);
        bCalculate = findViewById(R.id.bCalculate);

        bCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((edWeekNumber.getText().toString().length()) > 0){
                    int number = Integer.parseInt(edWeekNumber.getText().toString());
                    if ((number != 0) && (number <= 7)){
                        String[] day = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
                        tvDisplay.setText("The day is "+day[number-1]);
                    }else {
                        Toast.makeText(MainActivity.this, "Please give a number getter than 0 and less than 7", Toast.LENGTH_LONG).show();
                    }
                }else {
                    edWeekNumber.setError("please enter a number");
                    Toast.makeText(MainActivity.this, "please enter a number", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}