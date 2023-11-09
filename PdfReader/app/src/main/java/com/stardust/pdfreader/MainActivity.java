package com.stardust.pdfreader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    }
}