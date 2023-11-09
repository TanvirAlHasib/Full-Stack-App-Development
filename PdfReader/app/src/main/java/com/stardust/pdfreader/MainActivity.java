package com.stardust.pdfreader;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

            }
        });

    }
}