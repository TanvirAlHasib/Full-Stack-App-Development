package com.stardust.offline_in_app_audio_player;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ImageView play_icon1, play_icon2, play_icon3, play_icon4, pause1, pause2, pause3, pause4;
    MediaPlayer mediaPlayer;

    String music = "music1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play_icon1 = findViewById(R.id.play_icon1);
        play_icon2 = findViewById(R.id.play_icon2);
        play_icon3 = findViewById(R.id.play_icon3);
        play_icon4 = findViewById(R.id.play_icon4);
        pause1 = findViewById(R.id.pause1);
        pause2 = findViewById(R.id.pause2);
        pause3 = findViewById(R.id.pause3);
        pause4 = findViewById(R.id.pause4);



        // first music section



        play_icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (music.contains("music1")){
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
                    }
                }else {
                    if (mediaPlayer != null){
                        mediaPlayer.release();

                        music = "music1";
                        play_icon1.setImageResource(R.drawable.stop);
                        play_icon2.setImageResource(R.drawable.play_icon);
                        play_icon3.setImageResource(R.drawable.play_icon);
                        play_icon4.setImageResource(R.drawable.play_icon);
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
                    }else {

                        music = "music1";
                        play_icon1.setImageResource(R.drawable.stop);
                        play_icon2.setImageResource(R.drawable.play_icon);
                        play_icon3.setImageResource(R.drawable.play_icon);
                        play_icon4.setImageResource(R.drawable.play_icon);
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
                    }
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
                    music = "music1";
                }else {

                    Toast.makeText(MainActivity.this, "music is not playing", Toast.LENGTH_SHORT).show();
                }
            }
        });



     // 2nd music section



        play_icon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (music.contains("music2")){

                    if (play_icon2.getTag().toString().contains("Not_playing2")){

                        play_icon2.setTag("Stopped2");
                        play_icon2.setImageResource(R.drawable.stop);
                        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.sunny_fruit_beat_blitz);
                        mediaPlayer.start();

                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                play_icon2.setTag("Not_playing2");
                                play_icon2.setImageResource(R.drawable.play_icon);
                            }
                        });
                    } else if (play_icon2.getTag().toString().contains("Stopped2")) {
                        mediaPlayer.release();
                        play_icon2.setTag("Not_playing2");
                        play_icon2.setImageResource(R.drawable.play_icon);
                    } else if (play_icon2.getTag().toString().contains("Resumed2")) {
                        mediaPlayer.start();
                        play_icon2.setTag("Stopped2");
                        play_icon2.setImageResource(R.drawable.stop);
                    }
                }else {
                    if (mediaPlayer != null){
                        mediaPlayer.release();
                        music = "music2";
                        play_icon2.setTag("Stopped2");
                        play_icon2.setImageResource(R.drawable.stop);
                        play_icon1.setImageResource(R.drawable.play_icon);
                        play_icon3.setImageResource(R.drawable.play_icon);
                        play_icon4.setImageResource(R.drawable.play_icon);
                        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.sunny_fruit_beat_blitz);
                        mediaPlayer.start();

                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                play_icon2.setTag("Not_playing2");
                                play_icon2.setImageResource(R.drawable.play_icon);
                            }
                        });
                    }else {
                        music = "music2";
                        play_icon2.setTag("Stopped2");
                        play_icon2.setImageResource(R.drawable.stop);
                        play_icon1.setImageResource(R.drawable.play_icon);
                        play_icon3.setImageResource(R.drawable.play_icon);
                        play_icon4.setImageResource(R.drawable.play_icon);
                        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.sunny_fruit_beat_blitz);
                        mediaPlayer.start();

                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                play_icon2.setTag("Not_playing2");
                                play_icon2.setImageResource(R.drawable.play_icon);
                            }
                        });
                    }
                }
            }
        });

        pause2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (play_icon2.getTag().toString().contains("Stopped2")){
                    mediaPlayer.pause();
                    play_icon2.setTag("Resumed2");
                    play_icon2.setImageResource(R.drawable.play_icon);
                    music = "music2";
                    Toast.makeText(MainActivity.this, "music has paused", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "music is not playing", Toast.LENGTH_SHORT).show();
                }
            }
        });



        // 3rd music



        play_icon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (music.contains("music3")){

                    if (play_icon3.getTag().toString().contains("Not_playing3")){

                        play_icon3.setTag("Stopped3");
                        play_icon3.setImageResource(R.drawable.stop);
                        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.canon_lay_up);
                        mediaPlayer.start();

                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                play_icon3.setTag("Not_playing3");
                                play_icon3.setImageResource(R.drawable.play_icon);
                            }
                        });
                    } else if (play_icon3.getTag().toString().contains("Stopped3")) {
                        mediaPlayer.release();
                        play_icon3.setTag("Not_playing3");
                        play_icon3.setImageResource(R.drawable.play_icon);
                    } else if (play_icon3.getTag().toString().contains("Resumed3")) {
                        mediaPlayer.start();
                        play_icon3.setTag("Stopped3");
                        play_icon3.setImageResource(R.drawable.stop);
                    }
                }else {
                    if (mediaPlayer != null){
                        mediaPlayer.release();
                        music = "music3";
                        play_icon3.setTag("Stopped3");
                        play_icon3.setImageResource(R.drawable.stop);
                        play_icon1.setImageResource(R.drawable.play_icon);
                        play_icon2.setImageResource(R.drawable.play_icon);
                        play_icon4.setImageResource(R.drawable.play_icon);
                        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.canon_lay_up);
                        mediaPlayer.start();

                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                play_icon3.setTag("Not_playing3");
                                play_icon3.setImageResource(R.drawable.play_icon);
                            }
                        });
                    }else {
                        music = "music3";
                        play_icon3.setTag("Stopped3");
                        play_icon3.setImageResource(R.drawable.stop);
                        play_icon1.setImageResource(R.drawable.play_icon);
                        play_icon2.setImageResource(R.drawable.play_icon);
                        play_icon4.setImageResource(R.drawable.play_icon);
                        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.canon_lay_up);
                        mediaPlayer.start();

                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                play_icon3.setTag("Not_playing3");
                                play_icon3.setImageResource(R.drawable.play_icon);
                            }
                        });
                    }
                }
            }
        });


        pause3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (play_icon3.getTag().toString().contains("Stopped3")){
                    mediaPlayer.pause();
                    play_icon3.setTag("Resumed3");
                    play_icon3.setImageResource(R.drawable.play_icon);
                    music = "music3";
                    Toast.makeText(MainActivity.this, "music has paused", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "music is not playing", Toast.LENGTH_SHORT).show();
                }
            }
        });


        // 4th online song section


        music = "music4";
        play_icon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                if ((networkInfo != null) && (networkInfo.isAvailable())){

                    if (music.contains("music4")){

                        if (play_icon4.getTag().toString().contains("Not_playing4")){

                            mediaPlayer = new MediaPlayer();
                            try {
                                mediaPlayer.setDataSource(MainActivity.this, Uri.parse("https://www.ee.columbia.edu/~dpwe/sounds/music/dont_speak-no_doubt.wav"));
                                mediaPlayer.prepare();
                                mediaPlayer.start();
                                play_icon4.setTag("Stopped4");
                                play_icon4.setImageResource(R.drawable.stop);
                                Toast.makeText(MainActivity.this, "please wait, music is loading", Toast.LENGTH_LONG).show();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    play_icon4.setTag("Not_playing4");
                                    play_icon4.setImageResource(R.drawable.play_icon);
                                }
                            });

                        } else if (play_icon4.getTag().toString().contains("Stopped4")) {
                            mediaPlayer.release();
                            play_icon4.setImageResource(R.drawable.play_icon);
                            play_icon4.setTag("Not_playing4");
                        } else if (play_icon4.getTag().toString().contains("Resumed4")) {
                            mediaPlayer.start();
                            play_icon4.setTag("Stopped4");
                            play_icon4.setImageResource(R.drawable.stop);
                        }

                    }else {

                        if (mediaPlayer == null){

                            music = "music4";
                            play_icon4.setImageResource(R.drawable.stop);
                            play_icon3.setImageResource(R.drawable.play_icon);
                            play_icon2.setImageResource(R.drawable.play_icon);
                            play_icon1.setImageResource(R.drawable.play_icon);
                            mediaPlayer = new MediaPlayer();
                            try {
                                mediaPlayer.setDataSource(MainActivity.this, Uri.parse("https://www.ee.columbia.edu/~dpwe/sounds/music/dont_speak-no_doubt.wav"));
                                mediaPlayer.prepare();
                                mediaPlayer.start();
                                play_icon4.setTag("Stopped4");
                                Toast.makeText(MainActivity.this, "please wait, music is loading", Toast.LENGTH_LONG).show();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    play_icon4.setTag("Not_playing4");
                                    play_icon4.setImageResource(R.drawable.play_icon);
                                }
                            });

                        }else {

                            mediaPlayer.release();
                            music = "music4";
                            play_icon4.setImageResource(R.drawable.stop);
                            play_icon3.setImageResource(R.drawable.play_icon);
                            play_icon2.setImageResource(R.drawable.play_icon);
                            play_icon1.setImageResource(R.drawable.play_icon);

                            mediaPlayer = new MediaPlayer();
                            try {
                                mediaPlayer.setDataSource(MainActivity.this, Uri.parse("https://www.ee.columbia.edu/~dpwe/sounds/music/dont_speak-no_doubt.wav"));
                                Toast.makeText(MainActivity.this, "please wait, music is loading", Toast.LENGTH_LONG).show();
                                mediaPlayer.prepare();
                                mediaPlayer.start();
                                play_icon4.setTag("Stopped4");

                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    play_icon4.setTag("Not_playing4");
                                    play_icon4.setImageResource(R.drawable.play_icon);
                                }
                            });
                        }
                    }
                }else {
                    new AlertDialog.Builder(MainActivity.this)
                            .setIcon(R.drawable.exit_alert)
                            .setTitle("Network error!!")
                            .setMessage("You are offline. Please connect your device to internet.\nTo listen this music.")
                            .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).show();
                }
            }
        });


        pause4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (play_icon4.getTag().toString().contains("Stopped4")){
                    mediaPlayer.pause();
                    play_icon4.setTag("Resumed4");
                    play_icon4.setImageResource(R.drawable.play_icon);
                    music = "music4";
                    Toast.makeText(MainActivity.this, "music has paused", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "music is not playing", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();

        new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.drawable.music_icon)
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
                }).show();

    }
}