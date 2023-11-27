package com.stardust.sharedprefarencehw;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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


        // shared preference field

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

                    if (edName.getText().toString().length() > 0)
                    {
                        editor.putString("Name",edName.getText().toString());
                        editor.apply();
                        edName.setText(sharedPreferences.getString("Name","null"));
                    }

                    if (edFName.getText().toString().length() > 0)
                    {
                        editor.putString("FName",edFName.getText().toString());
                        editor.apply();
                        edFName.setText(sharedPreferences.getString("FName","null"));
                    }

                    if (edMName.getText().toString().length() > 0)
                    {
                        editor.putString("MName",edMName.getText().toString());
                        editor.apply();
                        edMName.setText(sharedPreferences.getString("MName","null"));
                    }

                    if (edEmail.getText().toString().length() > 0)
                    {
                        editor.putString("Email",edName.getText().toString());
                        editor.apply();
                        edEmail.setText(sharedPreferences.getString("Email","null"));
                    }

                    if (edRegistration.getText().toString().length() > 0)
                    {
                        editor.putString("Registration",edName.getText().toString());
                        editor.apply();
                        edRegistration.setText(sharedPreferences.getString("Registration","null"));
                    }

                    if (edSSC.getText().toString().length() > 0)
                    {
                        editor.putString("SSC",edName.getText().toString());
                        editor.apply();
                        edSSC.setText(sharedPreferences.getString("SSC","null"));
                    }

                    if (edHSC.getText().toString().length() > 0)
                    {
                        editor.putString("HSC",edName.getText().toString());
                        editor.apply();
                        edHSC.setText(sharedPreferences.getString("HSC","null"));
                    }

                    if (edBirthDate.getText().toString().length() > 0)
                    {
                        editor.putString("Birth",edName.getText().toString());
                        editor.apply();
                        edBirthDate.setText(sharedPreferences.getString("Birth","null"));
                    }

                    if (edNid.getText().toString().length() > 0)
                    {
                        editor.putString("NID",edName.getText().toString());
                        editor.apply();
                        edNid.setText(sharedPreferences.getString("NID","null"));
                    }

                    if (edPassport.getText().toString().length() > 0)
                    {
                        editor.putString("Passport",edName.getText().toString());
                        editor.apply();
                        edPassport.setText(sharedPreferences.getString("Passport","null"));
                    }


                } else {

                    new AlertDialog.Builder(MainActivity.this)
                            .setIcon(R.drawable.app_icon)
                            .setTitle("Error!!")
                            .setMessage("Please enter minimum one input to save or update")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).show();

                }
            }
        });


    }
}