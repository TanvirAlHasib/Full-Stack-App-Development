package com.stardust.picaso_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Web extends AppCompatActivity {

    public static String mainPageUrl;

    WebView mweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        mweb = findViewById(R.id.mweb);

        mweb.getSettings().setJavaScriptEnabled(true);
        mweb.loadUrl(mainPageUrl);
    }
}