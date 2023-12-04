package com.stardust.layoutinfalterhw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView bivagList, aboutSekhHasina;
    ImageView homeButton;
    LinearLayout inflaterLayout, motherLayout;
    LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bivagList = findViewById(R.id.bivagList);
        aboutSekhHasina = findViewById(R.id.aboutSekhHasina);
        homeButton = findViewById(R.id.homeButton);
        inflaterLayout = findViewById(R.id.inflaterLayout);
        motherLayout = findViewById(R.id.motherLayout);

        // LayoutInflater intro

        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // main functional work

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (motherLayout.getTag().toString().contains("sekh") || motherLayout.getTag().toString().contains("bivag")){
                    layoutInflater.inflate(R.layout.activity_main, motherLayout);
                    motherLayout.setTag("mainActivity");
                }
            }
        });

        bivagList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (motherLayout.getTag().toString().contains("mainActivity") || motherLayout.getTag().toString().contains("sekh")){
                    layoutInflater.inflate(R.layout.bivag_name, inflaterLayout);
                    motherLayout.setTag("bivag");
                }
            }
        });

        aboutSekhHasina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (motherLayout.getTag().toString().contains("mainActivity") || motherLayout.getTag().toString().contains("bivag")){
                    layoutInflater.inflate(R.layout.sekh_hasina, inflaterLayout);
                    motherLayout.setTag("sekh");
                }
            }
        });


    }
}