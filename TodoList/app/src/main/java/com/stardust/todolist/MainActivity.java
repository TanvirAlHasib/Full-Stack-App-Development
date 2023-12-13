package com.stardust.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    FloatingActionButton addNewTask;
    public static ArrayList< HashMap< String, String > > arrayList = new ArrayList<>();
    public static HashMap< String, String > hashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // variable intro

        listView = findViewById(R.id.listView);
        addNewTask = findViewById(R.id.addNewTask);


        // task input activity load

        addNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Task_input.class));
            }
        });

        // custom adapter intro to listview

        LocalAdapter localAdapter = new LocalAdapter();
        listView.setAdapter(localAdapter);


    }

    // creating customize adapter as LocalAdapter

    public class LocalAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            // listview inflate

            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = layoutInflater.inflate(R.layout.task_list, parent, false);

            // variable declaretion and intro

            TextView taskDisplay = myView.findViewById(R.id.taskDisplay);
            Button delete = myView.findViewById(R.id.delete);
            Button complete = myView.findViewById(R.id.complete);

            // hash map decrypt


            HashMap< String, String > localHashMap = new HashMap<>();

            localHashMap = arrayList.get(position);

            String task = localHashMap.get("task");


            // listview default content change


            taskDisplay.setText(task);


            // making delete, complete button functional

            complete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    taskDisplay.setTextColor(Color.parseColor("#46000000"));
                    complete.setText("COMPLETED");
                    Toast.makeText(MainActivity.this, "Yahoo, one task done 🏆", Toast.LENGTH_SHORT).show();
                }
            });



            return myView;
        }
    }


    // refresh main activity when press back button from another activity

    @Override
    public void onRestart()
    {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }


}