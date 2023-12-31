package com.stardust.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    FloatingActionButton addNewTask;
    public static ArrayList< HashMap< String, String > > arrayList = new ArrayList<>();
    public static HashMap< String, String > hashMap = new HashMap<>();
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;

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

            if (localHashMap.containsKey("color")) taskDisplay.setTextColor(Color.parseColor("#46000000"));
            if (localHashMap.containsKey("button")) complete.setText("COMPLETED");


            // listview default content change


            taskDisplay.setText(task);


            // making delete, complete button functional

            complete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (complete.getText().toString().length() < 9){

                        taskDisplay.setTextColor(Color.parseColor("#46000000"));
                        taskDisplay.setText((taskDisplay.getText().toString()) + " (Done 📝)");
                        complete.setText("COMPLETED");
                        Toast.makeText(MainActivity.this, "Yahoo, one task done 🏆", Toast.LENGTH_SHORT).show();

                        // sharedPreferences, gson, hashMap and arraylist section
                        hashMap = new HashMap<>();
                        hashMap.put("task", taskDisplay.getText().toString());
                        hashMap.put("color", "#46000000");
                        hashMap.put("button", "COMPLETED");

                        // using set method to replace data in particular index
                        arrayList.set(position, hashMap);

                        // sharedPreferences section
                        sharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);
                        editor = sharedPreferences.edit();

                        // Gson section
                        Gson gson = new Gson();
                        String json = gson.toJson(arrayList);

                        // sharedPreferences data entry
                        editor.putString("arrayList", json);
                        editor.apply();

                    } else{

                        Toast.makeText(MainActivity.this, "You have already completed this task ✔", Toast.LENGTH_SHORT).show();

                    }
                }
            });

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    arrayList.remove(position);
                    // notifying list view that data has changed otherwise app will crash
                    LocalAdapter.this.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "One task deleted successfully ✌", Toast.LENGTH_SHORT).show();
                    // sharedPreferences after delete data entry
                    sharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);
                    editor = sharedPreferences.edit();

                    // Gson section
                    Gson gson = new Gson();
                    String json = gson.toJson(arrayList);

                    // sharedPreferences data entry
                    editor.putString("arrayList", json);
                    editor.apply();
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

    // on start method

    @Override
    protected void onStart() {
        super.onStart();

        // sharedPreferences data retrive section
        sharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);
        boolean firstRun = sharedPreferences.getBoolean("firstRun", true);

        if (firstRun) return;


        Gson gson = new Gson();
        String json = "";
        json = sharedPreferences.getString("arrayList", "");

        // type section
        Type type = new TypeToken<ArrayList<HashMap<String, String>>>() {
        }.getType();

        arrayList = gson.fromJson(json, (java.lang.reflect.Type) type);

    }


    // onBackpressed method


    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.drawable.exit_alert)
                .setTitle("Exit!!")
                .setMessage("Do you really want to exit ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();

        sharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putBoolean("firstRun", false);
        editor.apply();

    }

    // on destroy method

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // sharedPreferences section
        sharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);
        editor = sharedPreferences.edit();

        // Gson section
        Gson gson = new Gson();
        String json = gson.toJson(arrayList);

        // sharedPreferences data entry
        editor.putString("arrayList", json);
        editor.apply();

        sharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putBoolean("firstRun", false);
        editor.apply();


    }


}