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
import android.widget.ImageView;
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

        //arrayList load function call here
        arrayLoad();

        //variable intro
        gridView = findViewById(R.id.gridView);


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

            // variable intro and declaretion
            TextView menuTitle = myView.findViewById(R.id.menuTitle);
            ImageView menuIcon = myView.findViewById(R.id.menuIcon);

            // menu name change
            hashMap = new HashMap<>();
            hashMap = arrayList.get(position);
            String menu = hashMap.get(""+position);
            menuTitle.setText(menu);

            //menu icon change
            if (hashMap.containsKey("icon")) menuIcon.setImageBitmap(convertStringToBitamp(hashMap.get("icon")));


            return myView;
        }
    }

    //initialize end here

    // arrayList and hashmap load function start here


    public void arrayLoad(){

        hashMap = new HashMap<>();
        hashMap.put("0", "Emergency");
        String emergencyIconText = convertBitmapToString(BitmapFactory.decodeResource(getResources(), R.drawable.emergency_icon));
        hashMap.put("icon", emergencyIconText);
        arrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("1", "Entertain");
        String entertainIconText = convertBitmapToString(BitmapFactory.decodeResource(getResources(),R.drawable.entertain));
        hashMap.put("icon", entertainIconText);
        arrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("2", "Task");
        String taskIconText = convertBitmapToString(BitmapFactory.decodeResource(getResources(), R.drawable.task));
        hashMap.put("icon", taskIconText);
        arrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("3", "Quotes");
        String quoteIconText = convertBitmapToString(BitmapFactory.decodeResource(getResources(), R.drawable.quote));
        hashMap.put("icon", quoteIconText);
        arrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("4", "News");
        String newsIconText = convertBitmapToString(BitmapFactory.decodeResource(getResources(), R.drawable.news));
        hashMap.put("icon", newsIconText);
        arrayList.add(hashMap);
        hashMap = new HashMap<>();
        String memeIconText = convertBitmapToString(BitmapFactory.decodeResource(getResources(),R.drawable.meme));
        hashMap.put("icon", memeIconText);
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