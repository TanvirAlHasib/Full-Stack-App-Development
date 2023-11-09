package com.stardust.pdfreader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;

public class PdfLoader extends AppCompatActivity {

    PDFView pdfView;
    LottieAnimationView no_internetAnimation, pdf_loading;

    public static String pdf_url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_loader);

        // variable intro

        pdfView = findViewById(R.id.pdfView);
        no_internetAnimation = findViewById(R.id.no_internetAnimation);
        pdf_loading = findViewById(R.id.pdf_loading);

        // internet connection checking

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if ((networkInfo != null) && (networkInfo.isAvailable())){

            pdf_loading.setVisibility(View.VISIBLE);
            pdfView.setVisibility(View.INVISIBLE);
            pdfView.fromUri(Uri.parse(pdf_url))
                    .onLoad(new OnLoadCompleteListener() {
                        @Override
                        public void loadComplete(int nbPages) {
                            pdf_loading.setVisibility(View.GONE);
                            pdfView.setVisibility(View.VISIBLE);
                            Toast.makeText(PdfLoader.this, "pdf loaded successfully", Toast.LENGTH_SHORT).show();
                        }
                    }).load();

        }else {
            no_internetAnimation.setVisibility(View.VISIBLE);
            Toast.makeText(PdfLoader.this, "please connect your internet and reload the page", Toast.LENGTH_LONG).show();
        }

    }
}