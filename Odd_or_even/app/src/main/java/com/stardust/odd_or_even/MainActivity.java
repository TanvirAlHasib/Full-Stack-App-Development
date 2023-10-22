package com.stardust.odd_or_even;

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
            public void onClick(View v) {
                int length = edNumber.getText().toString().length();
                if (length > 0){
                    int number = Integer.parseInt(edNumber.getText().toString());
                    if (number == 0){
                        Toast.makeText(MainActivity.this,"It is mathematical error",Toast.LENGTH_SHORT).show();
                        tvDisplay.setText("It is mathematical error");
                    }
                    else if (number%2==0){
                        Toast.makeText(MainActivity.this,"It is Even",Toast.LENGTH_SHORT).show();
                        tvDisplay.setText("It is Even");
                    }
                    else {
                        Toast.makeText(MainActivity.this,"It is Odd",Toast.LENGTH_SHORT).show();
                        tvDisplay.setText("It is Odd");
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Please enter a number first", Toast.LENGTH_SHORT).show();
                    edNumber.setError("please enter a number first");
                }
            }
        });

    }
}