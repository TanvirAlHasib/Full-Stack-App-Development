package com.stardust.everything;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

public class Emergency extends AppCompatActivity {

    ListView listView;
    HashMap<String, String> hashMap = new HashMap<>();
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    FloatingActionButton emergencyFloatingButton;
    RelativeLayout emergencyInputSection;
    RelativeLayout emergencyContactMotherLayout;
    ImageView contactImage;
    EditText contactName;
    EditText contactEmail;
    Button saveContact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        // variable intro
        listView = findViewById(R.id.listView);
        emergencyFloatingButton = findViewById(R.id.emergencyFloatingButton);
        emergencyInputSection = findViewById(R.id.emergencyInputSection);
        emergencyContactMotherLayout = findViewById(R.id.emergencyContactMotherLayout);
        //input section's item's intro
        contactImage = findViewById(R.id.contactImage);
        contactName = findViewById(R.id.contactName);
        contactEmail = findViewById(R.id.contactEmail);
        saveContact = findViewById(R.id.saveContact);



        //code for emergency floating action button
        emergencyContactMotherLayout.setVisibility(View.VISIBLE);
        emergencyInputSection.setVisibility(View.GONE);
        emergencyFloatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //design functioning here
                emergencyContactMotherLayout.setVisibility(View.GONE);
                emergencyContactMotherLayout.setTag("gone");
                emergencyInputSection.setVisibility(View.VISIBLE);
                emergencyFloatingButton.setVisibility(View.GONE);

                //code for making emergency contact input xml dynamic


            }
        });



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

    // on back press


    @Override
    public void onBackPressed() {

        if (emergencyContactMotherLayout.getTag().toString().contains("visible")) super.onBackPressed();

        emergencyContactMotherLayout.setVisibility(View.VISIBLE);
        emergencyInputSection.setVisibility(View.GONE);
        emergencyFloatingButton.setVisibility(View.VISIBLE);
        emergencyContactMotherLayout.setTag("visible");

    }
}