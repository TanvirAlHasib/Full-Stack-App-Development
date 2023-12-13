package com.stardust.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class Task_input extends AppCompatActivity {

    Button inputButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_input);

        // variable intro
        inputButton = findViewById(R.id.inputButton);

    }
}