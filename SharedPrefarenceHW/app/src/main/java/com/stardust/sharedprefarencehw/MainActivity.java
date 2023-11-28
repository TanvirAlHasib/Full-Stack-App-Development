package com.stardust.sharedprefarencehw;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edName, edFName, edMName, edEmail, edRegistration, edSSC, edHSC, edBirthDate, edNid, edPassport;
    Button bSave, bCopyAll;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String clipBoard = "";

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

        // for copy

        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

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
                    }

                    if (edFName.getText().toString().length() > 0)
                    {
                        editor.putString("FName",edFName.getText().toString());
                        editor.apply();
                    }

                    if (edMName.getText().toString().length() > 0)
                    {
                        editor.putString("MName",edMName.getText().toString());
                        editor.apply();
                    }

                    if (edEmail.getText().toString().length() > 0)
                    {
                        editor.putString("Email",edEmail.getText().toString());
                        editor.apply();
                    }

                    if (edRegistration.getText().toString().length() > 0)
                    {
                        editor.putString("Registration",edRegistration.getText().toString());
                        editor.apply();
                    }

                    if (edSSC.getText().toString().length() > 0)
                    {
                        editor.putString("SSC",edSSC.getText().toString());
                        editor.apply();
                    }

                    if (edHSC.getText().toString().length() > 0)
                    {
                        editor.putString("HSC",edHSC.getText().toString());
                        editor.apply();
                    }

                    if (edBirthDate.getText().toString().length() > 0)
                    {
                        editor.putString("Birth",edBirthDate.getText().toString());
                        editor.apply();
                    }

                    if (edNid.getText().toString().length() > 0)
                    {
                        editor.putString("NID",edNid.getText().toString());
                        editor.apply();
                    }

                    if (edPassport.getText().toString().length() > 0)
                    {
                        editor.putString("Passport",edPassport.getText().toString());
                        editor.apply();
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



        // for display of save data here out of the onClick listener

        edName.setText(sharedPreferences.getString("Name","null"));
        edFName.setText(sharedPreferences.getString("FName","null"));
        edMName.setText(sharedPreferences.getString("MName","null"));
        edEmail.setText(sharedPreferences.getString("Email","null"));
        edRegistration.setText(sharedPreferences.getString("Registration","null"));
        edSSC.setText(sharedPreferences.getString("SSC","null"));
        edHSC.setText(sharedPreferences.getString("HSC","null"));
        edBirthDate.setText(sharedPreferences.getString("Birth","null"));
        edNid.setText(sharedPreferences.getString("NID","null"));
        edPassport.setText(sharedPreferences.getString("Passport","null"));





        // for copy all button


        bCopyAll.setOnClickListener(new View.OnClickListener() {
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
                        clipBoard = clipBoard + "Name: " + edName.getText().toString() + "\n";
                    }

                    if (edFName.getText().toString().length() > 0)
                    {
                        clipBoard = clipBoard + "FatherName: " + edFName.getText().toString() + "\n";
                    }

                    if (edMName.getText().toString().length() > 0)
                    {
                        clipBoard = clipBoard + "MotherName: " + edMName.getText().toString() + "\n";
                    }

                    if (edEmail.getText().toString().length() > 0)
                    {
                        clipBoard = clipBoard + "Email: " + edEmail.getText().toString() + "\n";
                    }

                    if (edRegistration.getText().toString().length() > 0)
                    {
                        clipBoard = clipBoard + "RegistrationNumber: " + edRegistration.getText().toString() + "\n";
                    }

                    if (edSSC.getText().toString().length() > 0)
                    {
                        clipBoard = clipBoard + "SSCRoll: " + edSSC.getText().toString() + "\n";
                    }

                    if (edHSC.getText().toString().length() > 0)
                    {
                        clipBoard = clipBoard + "HSCRoll: " + edHSC.getText().toString() + "\n";
                    }

                    if (edBirthDate.getText().toString().length() > 0)
                    {
                        clipBoard = clipBoard + "BirthDate: " + edBirthDate.getText().toString() + "\n";
                    }

                    if (edNid.getText().toString().length() > 0)
                    {
                        clipBoard = clipBoard + "NID: " + edNid.getText().toString() + "\n";
                    }

                    if (edPassport.getText().toString().length() > 0)
                    {
                        clipBoard = clipBoard + "Passport: " + edPassport.getText().toString();
                    }

                    ClipData clipData = ClipData.newPlainText("Informations", clipBoard);
                    clipboardManager.setPrimaryClip(clipData);

                    Toast.makeText(MainActivity.this, "Copy done", Toast.LENGTH_SHORT).show();


                } else
                {

                    Toast.makeText(MainActivity.this, "Here is nothing to copy", Toast.LENGTH_LONG).show();

                }

            }
        });


    }


    @Override
    public void onBackPressed() {
//        super.onBackPressed();

        new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.drawable.app_icon)
                .setTitle("Exit!!")
                .setMessage("Do you really want to exit ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();

    }
}