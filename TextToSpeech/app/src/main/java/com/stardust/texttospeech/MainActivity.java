package com.stardust.texttospeech;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    // for saving text to speech in audio start

    // private static final int REQUEST_PERMISSION_WRITE_EXTERNAL_STORAGE = 123;
    private String mAudioFileName = "";
    private final String UtteranceID = "TextToSpeechAudio";
    Button bSave;

    // for saving text to speech in audio end

    EditText edText;
    Button bTap, bReset;

    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edText = findViewById(R.id.edText);
        bTap = findViewById(R.id.bTap);
        bReset = findViewById(R.id.bReset);

        // for saving speech to audio button

        bSave = findViewById(R.id.bSave);

        // text to speech initialize section

        textToSpeech = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

            }
        });
        bTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.speak(edText.getText().toString(),textToSpeech.QUEUE_FLUSH,null, null);
            }
        });

        bReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edText.setText("");
            }
        });

        // function for saving speech in audio at phone storage

        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToAudioFile(edText.getText().toString().trim());
                CreateFile();
            }
        });

    }

    // some finctions for saving speech in audio file in phone storage

    private void CreateFile() {

        File sddir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC), "Text To Speech Audio");

        if (sddir.exists()){
//            boolean isDirectoryCreated = sddir.mkdirs();
//            if (!isDirectoryCreated)
//                Toast.makeText(MainActivity.this, "Cann't create directory to save the audio", Toast.LENGTH_SHORT).show();

            sddir.mkdirs();
            mAudioFileName = sddir.getAbsolutePath() + "/" + UtteranceID + System.currentTimeMillis() + ".wav";
        }else {

            Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }

    }


    private void saveToAudioFile(String text){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

            textToSpeech.synthesizeToFile(text,null, new File(mAudioFileName),UtteranceID);
            Toast.makeText(MainActivity.this, "saved to "+ mAudioFileName, Toast.LENGTH_SHORT).show();
        }else {

            HashMap<String, String> hm = new HashMap<>();
            hm.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, UtteranceID);
            textToSpeech.synthesizeToFile(text, hm, mAudioFileName);
            Toast.makeText(MainActivity.this, "saved to "+ mAudioFileName, Toast.LENGTH_SHORT).show();
        }

    }


    // onBackPress method


    @Override
    public void onBackPressed() {
//        super.onBackPressed();

        new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.drawable.exit_alert)
                .setTitle("Exit!!")
                .setMessage("Do you really want to exit ?")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                }).setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Thank you for your feedback", Toast.LENGTH_SHORT).show();
                    }
                }).show();

    }


}