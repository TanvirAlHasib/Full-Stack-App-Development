package com.stardust.sharedprefarencehw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edName, edFName, edMName, edEmail, edRegistration, edSSC, edHSC, edBirthDate, edNid, edPassport;
    Button bSave, bCopyAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName = findViewById(R.id.edName);
        edFName = findViewById(R.id.edFName);
        edMName = findViewById(R.id.edMName);
        edEmail = findViewById(R.id.edEmail);
        edRegistration = findViewById(R.id.edRegistration);
        edSSC = findViewById(R.id.edSSC);
        edHSC = findViewById(R.id.edHSC);
        edBirthDate = findViewById(R.id.edBirthDate);
        edNid = findViewById(R.id.edNid);
        edPassport = findViewById(R.id.edPassport);


    }
}