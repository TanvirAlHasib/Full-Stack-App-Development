package com.stardust.everything;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.telephony.SmsManager;
import android.util.Base64;
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
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

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
    private static final int REQUEST_CALL_PERMISSION = 2;
    private static final int REQUEST_SMS_PERMISSION = 3;
    private static final int REQUEST_LOCATION_PERMISSION = 4;
    FusedLocationProviderClient fusedLocationProviderClient;
    String contact_Number;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;



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

        //shared preferences
        if (arrayList.size() != 0){

            sharedPreferences = getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);

            //Gson section string to arrayList



        }


        //emergency floating button on click listener
        emergencyFloatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //design functioning here
                emergencyContactMotherLayout.setVisibility(View.GONE);
                emergencyContactMotherLayout.setTag("gone");
                emergencyInputSection.setVisibility(View.VISIBLE);
                emergencyFloatingButton.setVisibility(View.GONE);
                allContactsHeading.setTag("gone");

                // for picking image from external storage or gallery
                contactImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //implicit intent
                        Intent contact_image = new Intent(Intent.ACTION_PICK);
                        contact_image.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(contact_image,1);

                    }
                });

                //code for making emergency contact input xml dynamic
                saveContact.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (contactName.getText().toString().length() > 0 && contactNumber.getText().toString().length() > 0){

                            Toast.makeText(Emergency.this, "please wait 😊", Toast.LENGTH_SHORT).show();

                            hashMap = new HashMap<>();
                            hashMap.put("name", contactName.getText().toString());

                            //taking image from contactImage and storing in hashmap
                            BitmapDrawable drawable = (BitmapDrawable) contactImage.getDrawable();
                            Bitmap bitmap = drawable.getBitmap();
                            hashMap.put("image",convertBitmapToString(bitmap));


                            if (contactDescription.getText().toString().length() > 0){

                                hashMap.put("des", contactDescription.getText().toString());

                            } else {

                                hashMap.put("des", "No descriptions are available ☹");
                            }

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
            Button delete = emergencyView.findViewById(R.id.delete);
            Button call = emergencyView.findViewById(R.id.call);
            Button message = emergencyView.findViewById(R.id.message);

            //getting value from array list and insert in contact informations
            hashMap = new HashMap<>();
            hashMap = arrayList.get(position);
            eName.setText(""+hashMap.get("name"));

            eDescription.setText(""+hashMap.get("des"));

            eNumber.setText(""+hashMap.get("number"));

            contact_Number = hashMap.get("number");

            eProfile.setImageBitmap(convertStringToBitamp(hashMap.get("image")));

            Toast.makeText(Emergency.this, "done 🏁", Toast.LENGTH_SHORT).show();

            //for deleting contact
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    arrayList.remove(position);
                    // for notifying that data has changed otherwise it app will crush
                    ListLocalAdapter.this.notifyDataSetChanged();

                }
            });


            //for call the contact
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //checking the permission, if i have the permission to call or not
                    if (ActivityCompat.checkSelfPermission(Emergency.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // Permission not granted, request it.
                        ActivityCompat.requestPermissions(Emergency.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PERMISSION);
                    } else {
                        // Permission already granted, proceed with the call.
                        makeCall();
                    }

                }
            });


            // for message the contact
            message.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //checking if i have the permission for location or not
                    if (ContextCompat.checkSelfPermission(Emergency.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(Emergency.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);

                    } else {

                        // Permission already granted, proceed with sending the message.
                        getLocationAndSendMessage();
                    }


                }
            });



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

    // for result of implicit intent
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //checking if result ok or not
        if (resultCode == RESULT_OK){

            //checking if we got the same code or not, that is 1, we have given in implicit intent
            if (requestCode == 1){

                contactImage.setImageURI(data.getData());

            } else {

                Toast.makeText(this, "something went wrong", Toast.LENGTH_SHORT).show();
            }

        } else {

            Toast.makeText(this, "Image is not available", Toast.LENGTH_SHORT).show();

        }

    }


    // for making call
    private void makeCall() {
        // Your code to make the call goes here.
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + contact_Number));
        startActivity(callIntent);
        Toast.makeText(this, "calling to "+contact_Number, Toast.LENGTH_SHORT).show();
    }


    // for making message
    private void sendMessage(String m) {
        // Your code to send the message goes here.
        String phoneNumber = contact_Number; // contact number from list view.
        String message = "Hello, this is an emergency message. I am in trouble, please help me. My location is,\n"+m;

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber, null, message, null, null);

        Toast.makeText(this, "Message sent to " + contact_Number, Toast.LENGTH_SHORT).show();
    }


    private void getLocationAndSendMessage() {
        // Check if the location permission is granted
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            // Check if location services are enabled
            LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                // Location services are not enabled
                Toast.makeText(this, "Please enable GPS for accurate location", Toast.LENGTH_SHORT).show();
                return;
            }

            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
            fusedLocationProviderClient.getLastLocation()
                    .addOnSuccessListener(new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            Geocoder geocoder = new Geocoder(Emergency.this, Locale.getDefault());
                            try {
                                List<Address> addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);

                                if (addresses != null) {
                                    // Format the location information
                                    String locationMessage = "Latitude: " + addresses.get(0).getLatitude() + "\nLongitude: " + addresses.get(0).getLongitude()
                                            + "\nCity: " +addresses.get(0).getAddressLine(0) + "\nCountry: " + addresses.get(0).getCountryName()
                                            + "\nCountry code: " + addresses.get(0).getCountryCode() + "\nPost code: " + addresses.get(0).getPostalCode()
                                            + "\nAdmin area: " + addresses.get(0).getAdminArea();

                                    // Check and request SMS permission
                                    if (ContextCompat.checkSelfPermission(Emergency.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                                        ActivityCompat.requestPermissions(Emergency.this, new String[]{Manifest.permission.SEND_SMS}, REQUEST_SMS_PERMISSION);
                                    } else {
                                        // SMS permission already granted, proceed with sending the message.
                                        sendMessage(locationMessage);
                                    }
                                } else {
                                    // No last known location available yet. Display a message to the user or retry.
                                    Toast.makeText(Emergency.this, "Location information not available yet. Please try again.", Toast.LENGTH_SHORT).show();
                                }

                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });

        } else {
            // Handle the case where location permission is not granted.
            Toast.makeText(this, "Location permission not granted", Toast.LENGTH_SHORT).show();
        }
    }




    //Handle Permission Result for both call and message
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CALL_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, proceed with the call.
                makeCall();
            } else {
                // Permission denied, show a message or handle accordingly.
                Toast.makeText(this, "Call permission denied", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == REQUEST_SMS_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, proceed with sending the message.
                Toast.makeText(this, "sms permission granted", Toast.LENGTH_SHORT).show();
            } else {
                // Permission denied, show a message or handle accordingly.
                Toast.makeText(this, "SMS permission denied", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == REQUEST_LOCATION_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Location permission granted, proceed with getting the location.
                getLocationAndSendMessage();
            } else {
                // Location permission denied, show a message or handle accordingly.
                Toast.makeText(this, "Location permission denied", Toast.LENGTH_SHORT).show();
            }
        }

    }



    // convert bitmap to base64 text start here


    public String convertBitmapToString(Bitmap bmp) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream); //compress to which format you want.
        byte[] byte_arr = stream.toByteArray();
        String imageStr = Base64.encodeToString(byte_arr, 1);
        return imageStr;
    }


    // convert bitmap to base64 text end here


    // decode base64 to image end


    public Bitmap convertStringToBitamp(String imageStr){

        byte[] imageAsBytes = Base64.decode(imageStr.getBytes(), Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length);
        return bitmap;

    }


    // decode base64 to image end

}