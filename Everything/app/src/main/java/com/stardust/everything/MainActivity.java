package com.stardust.everything;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap<String, String> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //variable intro
        gridView = findViewById(R.id.gridView);

        //arrayList load function call here
        arrayLoad();

        //gridView making functional
        LocalAdaptar localAdaptar = new LocalAdaptar();
        gridView.setAdapter(localAdaptar);


    }

    //adapter initialize start here

    public class LocalAdaptar extends BaseAdapter {


        @Override
        public int getCount() {
            return 6;
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

            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = layoutInflater.inflate(R.layout.grid_view, parent, false);

            return myView;
        }
    }

    //initialize end here

    // arrayList and hashmap load function start here


    public void arrayLoad(){



    }


    // arrayList and hashmap load function end here

}