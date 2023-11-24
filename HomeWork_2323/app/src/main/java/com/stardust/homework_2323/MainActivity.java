package com.stardust.homework_2323;

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
    TextView tvDisplay;
    Button bCalculate,bReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNumber = findViewById(R.id.edNumber);
        tvDisplay = findViewById(R.id.tvDisplay);
        bCalculate = findViewById(R.id.bCalculate);
        bReset = findViewById(R.id.bReset);


        // functional section start


        bCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int is_zero = Integer.parseInt(edNumber.getText().toString());
                if ((edNumber.getText().toString().length() > 0) && (is_zero != 0)){

                   int number = Integer.parseInt(edNumber.getText().toString());
                   double t = 9;
                   tvDisplay.setText("9");
                   double sum = 0;
                    for (int i = 1; i <= number; i++) {

                        if (i == 1){
                            continue;
                        }

                        t = (t*10) + 9;
                        tvDisplay.append(" "+t);
                        sum += t;

                    }
                    tvDisplay.append("\nn_th terms summation is: "+ (sum +9 ));

                } else {

                    new AlertDialog.Builder(MainActivity.this)
                            .setIcon(R.drawable.app_icon)
                            .setTitle("Input Error!!")
                            .setMessage("Please enter a number to calculate.")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            }).show();

                    edNumber.setError("Please enter number here");

                }
            }
        });


        // reset button work here

        bReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDisplay.setText("");
                edNumber.setText("");
            }
        });



    }


    @Override
    public void onBackPressed() {

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