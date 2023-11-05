package com.stardust.offline_in_app_audio_player;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

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
        pause1 = findViewById(R.id.pause1);
        pause2 = findViewById(R.id.pause2);
        pause3 = findViewById(R.id.pause3);
        
        play_icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (play_icon1.getTag().toString().contains("Not_playing")){

                    play_icon1.setImageResource(R.drawable.stop);
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.moove_ka_busy_day_ahead);
                    mediaPlayer.start();
                    play_icon1.setTag("Stopped");

                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            play_icon1.setImageResource(R.drawable.play_icon);
                            play_icon1.setTag("Not_playing");
                        }
                    });

                } else if (play_icon1.getTag().toString().contains("Stopped")) {
                    play_icon1.setImageResource(R.drawable.play_icon);
                    mediaPlayer.release();
                    play_icon1.setTag("Not_playing");
                } else if (play_icon1.getTag().toString().contains("Resumed")) {
                    mediaPlayer.start();
                    play_icon1.setTag("Stopped");
                    play_icon1.setImageResource(R.drawable.stop);
                }else {
                    mediaPlayer.release();
                }
            }
        });

        pause1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (play_icon1.getTag().toString().contains("Stopped")){
                    mediaPlayer.pause();
                    play_icon1.setImageResource(R.drawable.play_icon);
                    Toast.makeText(MainActivity.this, "music has paused", Toast.LENGTH_SHORT).show();
                    play_icon1.setTag("Resumed");
                }else {

                    Toast.makeText(MainActivity.this, "music is not playing", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}