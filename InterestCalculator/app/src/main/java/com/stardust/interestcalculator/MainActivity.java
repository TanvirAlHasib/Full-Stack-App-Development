package com.stardust.interestcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edPercentage,edBuy,edSell;
    Button bCalculate1, bCalculate2;
    TextView tvSellPrice,tvProfit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edPercentage = findViewById(R.id.edPercentage);
        edBuy = findViewById(R.id.edBuy);
        edSell = findViewById(R.id.edSell);
        bCalculate1 = findViewById(R.id.bCalculate1);
        bCalculate2 = findViewById(R.id.bCalculate2);
        tvSellPrice = findViewById(R.id.tvSellPrice);
        tvProfit = findViewById(R.id.tvProfit);
    }
}