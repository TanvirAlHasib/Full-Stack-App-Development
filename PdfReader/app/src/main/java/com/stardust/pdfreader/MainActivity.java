package com.stardust.pdfreader;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout fHadith, sHadith, tHadith, fourthHadith, fifthHadith, sixthHadith, seventhHadith, eightthHadith, ninethHadith, tenthHadith;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fHadith = findViewById(R.id.fHadith);
        sHadith = findViewById(R.id.sHadith);
        tHadith = findViewById(R.id.tHadith);
        fourthHadith = findViewById(R.id.fourthHadith);
        fifthHadith = findViewById(R.id.fifthHadith);
        sixthHadith = findViewById(R.id.sixthHadith);
        seventhHadith = findViewById(R.id.seventhHadith);
        eightthHadith = findViewById(R.id.eightthHadith);
        ninethHadith = findViewById(R.id.ninethHadith);
        tenthHadith = findViewById(R.id.tenthHadith);

        //internet check

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if ((networkInfo == null) || (networkInfo.isFailover())){

            new AlertDialog.Builder(MainActivity.this)
                    .setIcon(R.drawable.book_icon)
                    .setTitle("নেটওয়ার্ক ত্রুটি !!")
                    .setMessage("আপনার ইন্টারনেট সংযোগ করুন.\nবুখারী শরীফ লোড করার জন্য এই অ্যাপটির ইন্টারনেট সংযোগ প্রয়োজন")
                    .setNegativeButton("ধন্যবাদ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).show();

        }



        //fhadith section

        fHadith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PdfLoader.pdf_url = "https://drive.google.com/file/d/1zZ5sW3v9KeIX9dk7kAM_AbjVtxA3pHlP/view?usp=drive_link";
                Intent intent = new Intent(MainActivity.this, PdfLoader.class);
                startActivity(intent);
            }
        });

        //sHadith section

        sHadith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PdfLoader.pdf_url = "https://drive.google.com/file/d/1Ce4pN6oYu6TqZbBFY6l-ZuhlE_N4q3R8/view?usp=drive_link";
                Intent intent = new Intent(MainActivity.this, PdfLoader.class);
                startActivity(intent);
            }
        });

        //tHadith section

        tHadith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PdfLoader.pdf_url = "https://drive.google.com/file/d/1lyjM7MPt1BeNk9O4VaPVPcyKcDwlJ9nP/view?usp=drive_link";
                Intent intent = new Intent(MainActivity.this, PdfLoader.class);
                startActivity(intent);
            }
        });

//        fourthHadith section

        fourthHadith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PdfLoader.pdf_url = "https://drive.google.com/file/d/1xHmWcgcVkx4Phn80gGZF90Q9K2f7s9wP/view?usp=drive_link";
                Intent intent = new Intent(MainActivity.this, PdfLoader.class);
                startActivity(intent);
            }
        });

//        fifthHadith section

        fifthHadith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PdfLoader.pdf_url = "https://drive.google.com/file/d/1o2zZY2g3ljmhicj-H7PW7ZZVqNn7aQAx/view?usp=drive_link";
                Intent intent = new Intent(MainActivity.this, PdfLoader.class);
                startActivity(intent);
            }
        });

//        sixthHadith section

        sixthHadith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PdfLoader.pdf_url = "https://drive.google.com/file/d/1anxNLobCW5mu7-2JfAsf50jkg3EDGBaE/view?usp=drive_link";
                Intent intent = new Intent(MainActivity.this, PdfLoader.class);
                startActivity(intent);
            }
        });

//        seventhHadith section

        seventhHadith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PdfLoader.pdf_url = "https://drive.google.com/file/d/1gdr9x-N090UgcF3wsRf0BVlTTR2rstoJ/view?usp=drive_link";
                Intent intent = new Intent(MainActivity.this, PdfLoader.class);
                startActivity(intent);
            }
        });

//        eightthHadith section

        eightthHadith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PdfLoader.pdf_url = "https://drive.google.com/file/d/1zHUFTOby8fbeY8kjyVd4DTDM1G8IFWRr/view?usp=drive_link";
                Intent intent = new Intent(MainActivity.this, PdfLoader.class);
                startActivity(intent);
            }
        });

//        ninethHadith section

        ninethHadith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PdfLoader.pdf_url = "https://drive.google.com/file/d/1Uk6VnnZ5pyU57rrE3hWxXdgSPmiCfl2L/view?usp=drive_link";
                Intent intent = new Intent(MainActivity.this, PdfLoader.class);
                startActivity(intent);
            }
        });

//        tenthHadith section

        tenthHadith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PdfLoader.pdf_url = "https://drive.google.com/file/d/1lA7LOp0yAgdvZrvdBqzTaBCNzAgOWNQ1/view?usp=drive_link";
                Intent intent = new Intent(MainActivity.this, PdfLoader.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();

        new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.drawable.exit_alert)
                .setTitle("প্রস্থান !!")
                .setMessage("আপনি কি সত্যিই প্রস্থান করতে চান?")
                .setNegativeButton("হ্যাঁ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                }).setPositiveButton("না", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();

    }
}