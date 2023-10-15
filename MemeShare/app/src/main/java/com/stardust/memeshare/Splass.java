package com.stardust.memeshare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splass extends AppCompatActivity {

    int DELAY_TIME = 3000;

    Animation toptomiddle, bottomtomiddle;
    ImageView trollface;
    TextView textmeme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splass);

        toptomiddle = AnimationUtils.loadAnimation(Splass.this,R.anim.top_to_middle);
        bottomtomiddle = AnimationUtils.loadAnimation(Splass.this,R.anim.bottom_to_middle);

        trollface = findViewById(R.id.trollface);
        textmeme = findViewById(R.id.textmeme);

        trollface.startAnimation(toptomiddle);
        textmeme.startAnimation(bottomtomiddle);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent myintent = new Intent(Splass.this, MainActivity.class);
                startActivity(myintent);
                finish();
            }
        },DELAY_TIME);

    }
}