package com.stardust.electricity_bill;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edUnits;
    TextView tvDisplay;
    Button bCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edUnits = findViewById(R.id.edUnits);
        tvDisplay = findViewById(R.id.tvDisplay);
        bCalculate = findViewById(R.id.bCalculate);

        bCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((edUnits.getText().toString().length()) > 0){
                    double units = Float.parseFloat(edUnits.getText().toString());
                    if (units == 0){
                        tvDisplay.setText("Total bill in BDT 0");
                    } else if ((units < 250.0) && (units >= 150.0)){
                        double bill_1 = 50.0*0.5;
                        double unit_1 = (units-50.0)/100.0;
                        double fraction = unit_1 - 1.0;
                        double bill_fraction = (fraction*100.0)*1.20;
                        double bill_2 = 100.0*0.75;
                        double bill_sum = bill_1 + bill_fraction + bill_2;
                        double totall_bill = (bill_sum*0.2) + bill_sum;
                        tvDisplay.setText("Total bill in BDT "+totall_bill);
                    } else if (units < 150.0 && units > 50) {
                        double totall_bill = (50*0.5) + ((units - 50.0)*0.75);
                        totall_bill = (totall_bill*0.2) + totall_bill;
                        tvDisplay.setText("Total bill in BDT "+totall_bill);
                    } else if (units <= 50) {
                        double totall_bill = units*0.5;
                        totall_bill = totall_bill + (totall_bill*0.2);
                        tvDisplay.setText("Total bill in BDT "+totall_bill);
                    } else {
                        double totall_bill = units*1.50;
                        totall_bill = (totall_bill*0.2)+totall_bill;
                        tvDisplay.setText("Total bill in BDT "+totall_bill);
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Please input a number", Toast.LENGTH_SHORT).show();
                    edUnits.setError("please input a number");
                }
            }
        });

    }
}