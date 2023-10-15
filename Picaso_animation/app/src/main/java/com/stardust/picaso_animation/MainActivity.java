package com.stardust.picaso_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

//    variable declaration

    Button button_for_anim, button_for_picasso,back,main_page;
    ImageView image_for_picasso, imageview;
    LinearLayout linearLayout;

//    for anim variable

    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        variable intoduce

        button_for_anim = findViewById(R.id.button_for_anim);
        button_for_picasso = findViewById(R.id.button_for_picasso);
        back = findViewById(R.id.back);
        main_page = findViewById(R.id.main_page);
        image_for_picasso = findViewById(R.id.image_for_picasso);
        imageview = findViewById(R.id.imageview);
        linearLayout = findViewById(R.id.linearlayout);

//        for anim variable

        animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animation);

//        listener for anim

        button_for_anim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageview.startAnimation(animation);
            }
        });

//        listener for picasso

        button_for_picasso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setVisibility(View.VISIBLE);
                 Picasso.get()
                        .load("https://square.github.io/picasso/static/sample.png")
                         .placeholder(R.drawable.place_holder)
                        .into(image_for_picasso);
            }
        });

//        listener for back button

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setVisibility(View.GONE);
            }
        });

        // for main page button

        main_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Web.mainPageUrl = "https://square.github.io/picasso/";
                Intent myIntent = new Intent(MainActivity.this, Web.class);
                startActivity(myIntent);
            }
        });

    }
}