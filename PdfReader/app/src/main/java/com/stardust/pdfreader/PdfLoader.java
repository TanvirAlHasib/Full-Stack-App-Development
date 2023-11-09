package com.stardust.pdfreader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.github.barteksc.pdfviewer.PDFView;

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


    }
}