package com.stardust.offline_in_app_audio_player;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView play_icon1, play_icon2, play_icon3,pause1, pause2, pause3;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play_icon1 = findViewById(R.id.play_icon1);
        play_icon2 = findViewById(R.id.play_icon2);
        play_icon3 = findViewById(R.id.play_icon3);

    }
}