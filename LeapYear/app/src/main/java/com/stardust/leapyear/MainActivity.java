package com.stardust.leapyear;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edYaer;
    TextView tvDisplay;
    Button bCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edYaer = findViewById(R.id.edYaer);
        tvDisplay = findViewById(R.id.tvDisplay);
        bCalculate = findViewById(R.id.bCalculate);

        bCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((edYaer.getText().toString().length()) > 0){
                    double year = Double.parseDouble(edYaer.getText().toString());
                    if (year == 0){
                       tvDisplay.setText("0 is exceptional");
                    } else if (((year%4 == 0) && (year%100 != 0)) || (year % 400 == 0)){
                        tvDisplay.setText(year+" is leap year");
                    }else {
                        tvDisplay.setText(year+" is not leap year");
                    }
                }else {
                    edYaer.setError("please enter a year");
                    Toast.makeText(MainActivity.this, "Please enter a year", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}