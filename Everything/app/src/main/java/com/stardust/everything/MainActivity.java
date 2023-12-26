package com.stardust.everything;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
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

            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = layoutInflater.inflate(R.layout.grid_view, parent, false);

            return myView;
        }
    }

    //initialize end here

    // arrayList and hashmap load function start here


    public void arrayLoad(){

        hashMap = new HashMap<>();
        hashMap.put("0", "Emergency");
        hashMap.put("1", "Entertainment");
        hashMap.put("2", "Task");
        hashMap.put("3", "Quotes");
        hashMap.put("4", "News");
        hashMap.put("5", "Memes");
        arrayList.add(hashMap);

    }


    // arrayList and hashmap load function end here


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