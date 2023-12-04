package com.stardust.layoutinfalterhw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView bivagList, aboutSekhHasina;
    ImageView homeButton;
    LinearLayout inflaterLayout;
    LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bivagList = findViewById(R.id.bivagList);
        aboutSekhHasina = findViewById(R.id.aboutSekhHasina);
        homeButton = findViewById(R.id.homeButton);
        inflaterLayout = findViewById(R.id.inflaterLayout);

        // LayoutInflater intro

        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }
}