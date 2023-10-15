package com.stardust.interestcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edPercentage,edBuy,edSell,edMainPrice;
    Button bCalculate1, bCalculate2;
    TextView tvSellPrice,tvProfit,privacy;

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
        privacy = findViewById(R.id.privacy);


        // for privacy webview

        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Webview.class);
                startActivity(intent);
            }
        });

        // how much profit user want section

        bCalculate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float main_price = Float.parseFloat(edMainPrice.getText().toString());
                float desire_percentage = Float.parseFloat(edPercentage.getText().toString());
                float sell_price = ((desire_percentage*main_price)/100)+main_price;
                tvSellPrice.setText("You have to sell "+sell_price+" or above this price.");
            }
        });

        // profit or loss section

        bCalculate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float buy = Float.parseFloat(edBuy.getText().toString());
                float sell = Float.parseFloat((edSell.getText().toString()));
                float profit = sell - buy;
                if (profit>0){
                    float percentage = (profit/buy)*100;
                    tvProfit.setText("You have profited "+profit+" taka"+" and in percentage "+percentage);
                }
                if (profit<0){
                    float percentage = (profit/buy)*100;
                    profit = profit*-1;
                    tvProfit.setText("You have lossed "+profit+" taka"+" and in percentage "+percentage+"%");
                }
                if (profit == 0){
                    tvProfit.setText("You have not profited or lossed, in value 0 taka and in percentage 0%");
                }
            }
        });

    }
}