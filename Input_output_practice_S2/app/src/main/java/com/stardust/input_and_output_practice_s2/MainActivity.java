package com.stardust.input_and_output_practice_s2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView UserNameQuestion, NameDisplay;
    EditText edName;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserNameQuestion = findViewById(R.id.UserNameQuestion);
        NameDisplay = findViewById(R.id.NameDisplay);
        edName = findViewById(R.id.edName);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NameDisplay.setText("Assalamualaykum, "+edName.getText().toString()+"\nHave a nice day, Sir.");
            }
        });

    }
}