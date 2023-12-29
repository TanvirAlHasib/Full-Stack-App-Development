package com.stardust.everything;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.TextView;

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
    EditText contactDescription;
    EditText contactNumber;
    Button saveContact;
    TextView forNullContacts;
    TextView allContactsHeading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        // variable intro
        listView = findViewById(R.id.listView);
        emergencyFloatingButton = findViewById(R.id.emergencyFloatingButton);
        emergencyInputSection = findViewById(R.id.emergencyInputSection);
        emergencyContactMotherLayout = findViewById(R.id.emergencyContactMotherLayout);
        allContactsHeading = findViewById(R.id.allContactsHeading);
        //input section's item's intro
        contactImage = findViewById(R.id.contactImage);
        contactName = findViewById(R.id.contactName);
        contactDescription = findViewById(R.id.contactDescription);
        contactNumber = findViewById(R.id.contactNumber);
        saveContact = findViewById(R.id.saveContact);
        forNullContacts = findViewById(R.id.forNullContacts);



        //code for emergency floating action button
        emergencyContactMotherLayout.setVisibility(View.VISIBLE);
        emergencyInputSection.setVisibility(View.GONE);
        allContactsHeading.setTag("visible");
        emergencyFloatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //design functioning here
                emergencyContactMotherLayout.setVisibility(View.GONE);
                emergencyContactMotherLayout.setTag("gone");
                emergencyInputSection.setVisibility(View.VISIBLE);
                emergencyFloatingButton.setVisibility(View.GONE);
                allContactsHeading.setTag("gone");

                //code for making emergency contact input xml dynamic
                saveContact.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (contactName.getText().toString().length() > 0 && contactNumber.getText().toString().length() > 0){

                            hashMap = new HashMap<>();
                            hashMap.put("name", contactName.getText().toString());
                            hashMap.put("des", contactDescription.getText().toString());
                            hashMap.put("number", contactNumber.getText().toString());
                            arrayList.add(hashMap);
                            contactNumber.setText("");
                            contactName.setText("");
                            contactDescription.setText("");
                            contactImage.setImageResource(R.drawable.capture);
                            forNullContacts.setVisibility(View.GONE);


                        } else {

                            new AlertDialog.Builder(Emergency.this)
                                    .setIcon(R.drawable.alert)
                                    .setTitle("Error !!")
                                    .setMessage("Please enter number and name of contact ☎")
                                    .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    }).create().show();

                        }

                    }
                });

            }
        });



        //listView initialize
        ListLocalAdapter listLocalAdapter = new ListLocalAdapter();
        listView.setAdapter(listLocalAdapter);

        if (arrayList.size() == 0){

            forNullContacts.setVisibility(View.VISIBLE);

        }


    }

    // local adapter for listView
    public class ListLocalAdapter extends BaseAdapter{


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

            //layout inflate
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View emergencyView = layoutInflater.inflate(R.layout.list_view, parent, false);

            //list view variables intro and declaretion
            TextView eName = emergencyView.findViewById(R.id.eName);
            TextView eDescription = emergencyView.findViewById(R.id.eDescription);
            TextView eNumber = emergencyView.findViewById(R.id.eNumber);
            ImageView eProfile = emergencyView.findViewById(R.id.eProfile);

            //getting value from array list and insert in contact informations
            hashMap = new HashMap<>();
            hashMap = arrayList.get(position);
            eName.setText(""+hashMap.get("name"));
            if (hashMap.containsKey("des")){

                eDescription.setText(""+hashMap.get("des"));

            } else {

                eDescription.setText("null");

            }

            eNumber.setText(""+hashMap.get("number"));


            return emergencyView;
        }
    }

    // on back press


    @Override
    public void onBackPressed() {

        if (allContactsHeading.getTag().toString().contains("visible")) super.onBackPressed();

        emergencyContactMotherLayout.setVisibility(View.VISIBLE);
        emergencyInputSection.setVisibility(View.GONE);
        emergencyFloatingButton.setVisibility(View.VISIBLE);
        emergencyContactMotherLayout.setTag("visible");
        allContactsHeading.setTag("visible");

    }
}