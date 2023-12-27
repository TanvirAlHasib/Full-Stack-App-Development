package com.stardust.everything;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class Emergency extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        // variable intro
        listView = findViewById(R.id.listView);

        //listView initialize
        ListLocalAdapter listLocalAdapter = new ListLocalAdapter();
        listView.setAdapter(listLocalAdapter);


    }

    // local adapter for listView
    public class ListLocalAdapter extends BaseAdapter{


        @Override
        public int getCount() {
            return 10;
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

            //layout inflate
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View emergencyView = layoutInflater.inflate(R.layout.list_view, parent, false);

            return emergencyView;
        }
    }


}