package com.stardust.interestcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Webview extends AppCompatActivity {

    WebView privacyWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        privacyWebview = findViewById(R.id.privacyWebview);

        privacyWebview.getSettings().setJavaScriptEnabled(true);
        privacyWebview.loadUrl("https://sites.google.com/view/meme-share-privacy-policy/home");

    }
}