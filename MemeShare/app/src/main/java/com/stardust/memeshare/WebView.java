package com.stardust.memeshare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebViewClient;

public class WebView extends AppCompatActivity {

    public static String url = "";

    android.webkit.WebView privacy_web_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        privacy_web_view = findViewById(R.id.privacy_web_view);

        privacy_web_view.getSettings().setJavaScriptEnabled(true);
        privacy_web_view.loadUrl(url);
        privacy_web_view.setWebViewClient(new WebViewClient());
    }
}