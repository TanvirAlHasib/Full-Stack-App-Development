package com.stardust.sharedprefarencehw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edName, edFName, edMName, edEmail, edRegistration, edSSC, edHSC, edBirthDate, edNid, edPassport;
    Button bSave, bCopyAll;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

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
        bSave = findViewById(R.id.bSave);
        bCopyAll = findViewById(R.id.bCopyAll);

        sharedPreferences = getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);
        editor = sharedPreferences.edit();

        // main functional work start

        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((edName.getText().toString().length()) > 0 ||
                        (edFName.getText().toString().length()) > 0 ||
                        (edMName.getText().toString().length()) > 0 ||
                        (edEmail.getText().toString().length()) > 0 ||
                        (edRegistration.getText().toString().length()) > 0 ||
                        (edSSC.getText().toString().length()) > 0 ||
                        (edHSC.getText().toString().length()) > 0 ||
                        (edBirthDate.getText().toString().length()) > 0 ||
                        (edNid.getText().toString().length()) > 0 ||
                        (edPassport.getText().toString().length()) > 0)
                {




                } else {



                }
            }
        });


    }
}