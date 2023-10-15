package com.stardust.interestcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edPercentage,edBuy,edSell,edMainPrice;
    Button bCalculate1, bCalculate2;
    TextView tvSellPrice,tvProfit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // varibale intro

        edPercentage = findViewById(R.id.edPercentage);
        edBuy = findViewById(R.id.edBuy);
        edSell = findViewById(R.id.edSell);
        edMainPrice = findViewById(R.id.edMainPrice);
        bCalculate1 = findViewById(R.id.bCalculate1);
        bCalculate2 = findViewById(R.id.bCalculate2);
        tvSellPrice = findViewById(R.id.tvSellPrice);
        tvProfit = findViewById(R.id.tvProfit);

        // how much profit user want

        bCalculate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float main_price = Float.parseFloat(edMainPrice.getText().toString());
                float desire_percentage = Float.parseFloat(edPercentage.getText().toString());
                float sell_price = ((desire_percentage*main_price)/100)+main_price;
                tvSellPrice.setText("You have to sell "+sell_price+" or above this price.");
            }
        });

    }
}