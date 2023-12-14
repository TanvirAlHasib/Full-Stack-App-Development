package com.stardust.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.HashMap;

public class Task_input extends AppCompatActivity {

    Button inputButton;
    EditText edTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_input);

        // variable intro
        inputButton = findViewById(R.id.inputButton);
        edTask = findViewById(R.id.edTask);
        // inputButton functional
        inputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // input check
                if (edTask.getText().toString().length() > 0){

                    MainActivity.hashMap = new HashMap<>();
                    MainActivity.hashMap.put("task",edTask.getText().toString());
                    MainActivity.arrayList.add(MainActivity.hashMap);
                    Toast.makeText(Task_input.this, "Task has added successfully", Toast.LENGTH_SHORT).show();
                    // clearing input field after input one task
                    edTask.setText("");

                } else {

                    new AlertDialog.Builder(Task_input.this)
                            .setIcon(R.drawable.app_icon)
                            .setTitle("Error!!")
                            .setMessage("Please enter your task")
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