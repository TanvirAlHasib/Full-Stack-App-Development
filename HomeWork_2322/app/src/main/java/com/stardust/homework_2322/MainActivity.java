package com.stardust.homework_2322;

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

        //variable intro section

        edNumber = findViewById(R.id.edNumber);
        tvDisplay = findViewById(R.id.tvDisplay);
        bCalculate = findViewById(R.id.bCalculate);

        //functional section

        bCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edNumber.getText().toString().length() > 0){

                    tvDisplay.setText("0");
                    int number = Integer.parseInt(edNumber.getText().toString());
                    int count = 0;
                    long sum = 0;

                    for (int i = 1; true; i++) {

                        if ( i%2 == 0 ){
                            count++;
                            if (count < number){
                                sum = sum + i;
                                tvDisplay.append(" "+i);
                            }else {
                                tvDisplay.append("\nAnd sum is: "+sum);
                                break;
                            }
                        }

                    }

                }
            }
        });



    }
}