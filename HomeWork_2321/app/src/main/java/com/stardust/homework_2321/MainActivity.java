package com.stardust.homework_2321;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edNumber;
    Button button;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //variable intro

        edNumber = findViewById(R.id.edNumber);
        button = findViewById(R.id.button);
        tvDisplay = findViewById(R.id.tvDisplay);

        //functional section

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((edNumber.getText().toString().length()) > 0){

                }else {
                    new AlertDialog.Builder(MainActivity.this)
                            .setIcon(R.drawable.alert_icon)
                            .setTitle("Error!!")
                            .setMessage("Please enter a number first")
                            .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            }).show();
                }
            }
        });


    }
}