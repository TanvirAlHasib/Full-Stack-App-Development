package com.stardust.memeshare;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.service.chooser.ChooserTarget;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    ImageView memeview;
    Button next, share;
    String current_url = "";
    ProgressBar progressBar;
    TextView uppertext;

    Animation anim_for_button, anim_for_share_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memeview = findViewById(R.id.memeview);
        next = findViewById(R.id.next);
        share = findViewById(R.id.share);
        progressBar = findViewById(R.id.progressbar);
        uppertext = findViewById(R.id.uppertext);

        // for privacy policy

        uppertext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebView.url = "https://sites.google.com/view/meme-share-privacy-policy/home";
                Intent intent = new Intent(MainActivity.this,WebView.class);
                startActivity(intent);
            }
        });

        // for button anim

        anim_for_button = AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim_for_button);
        anim_for_share_button = AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim_for_share_button);

        // progress bar setting

        progressBar.setVisibility(View.VISIBLE);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        String url = "https://meme-api.com/gimme";

        // Request a string response from the provided URL.
        JsonObjectRequest Jsonobjectrequest = new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                             current_url = response.getString("url");
                            Glide.with(MainActivity.this).load(current_url).into(memeview);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"Something went wrong",Toast.LENGTH_LONG).show();
            }
        });

        // Add the request to the RequestQueue.
        queue.add(Jsonobjectrequest);

        // next button work

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // anim for button

                next.startAnimation(anim_for_button);

                // progress bar setting

                progressBar.setVisibility(View.VISIBLE);

                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url = "https://meme-api.com/gimme";

                // Request a string response from the provided URL.
                JsonObjectRequest Jsonobjectrequest = new JsonObjectRequest(Request.Method.GET, url,null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    current_url = response.getString("url");
                                    Glide.with(MainActivity.this).load(current_url).into(memeview);
                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,"Something went wrong",Toast.LENGTH_LONG).show();
                    }
                });

                // Add the request to the RequestQueue.
                queue.add(Jsonobjectrequest);
            }
        });

        // work of share button

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                share.startAnimation(anim_for_share_button);
                Intent myintent = new Intent(Intent.ACTION_SEND);
                myintent.setType("text/plain");
                myintent.putExtra(Intent.EXTRA_TEXT,"Hey checkout this awesome meme: "+ current_url);
                Intent chooser = new Intent(Intent.createChooser(myintent,"Share this meme using..."));
                startActivity(chooser);
            }
        });

    }

    // warning dialog box setting

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Do you want to exit ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
