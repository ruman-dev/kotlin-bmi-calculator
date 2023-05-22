package com.example.nasheedapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView play1, play2, play3, play4, play5, play6, play7;
    MediaPlayer mplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play1 = findViewById(R.id.play1);
        play2 = findViewById(R.id.play2);
      /*  play3 = findViewById(R.id.play3);
        play4 = findViewById(R.id.play4);
        play5 = findViewById(R.id.play5);
        play6 = findViewById(R.id.play6);
        play7 = findViewById(R.id.play7);

        */
        play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(play1.getTag() != null && play1.getTag().toString().contains("NOT_PLAYING")){
                    if(mplay!=null) mplay.release();
                    mplay = MediaPlayer.create(MainActivity.this,R.raw.assubhu_bada);
                    mplay.start();
                    play1.setImageResource(R.drawable.stop_icon_red);
                    play1.setTag("PLAYING");

                    mplay.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            play1.setImageResource(R.drawable.play_icon);
                            play1.setTag("NOT_PLAYING");
                        }
                    });
                }
                else{
                    if(mplay != null) mplay.release();
                    play1.setImageResource(R.drawable.play_icon);
                    play1.setTag("NOT_PLAYING");
                }
            }
        });
        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(play2.getTag() != null && play2.getTag().toString().contains("NOT_PLAYING")){
                    if(mplay!=null) mplay.release();
                    mplay = MediaPlayer.create(MainActivity.this,R.raw.nabir_ruper_alo);
                    mplay.start();
                    play2.setImageResource(R.drawable.stop_icon_red);
                    play2.setTag("PLAYING");

                    mplay.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            play2.setImageResource(R.drawable.play_icon);
                            play2.setTag("NOT_PLAYING");
                        }
                    });



                }
                else{
                    if(mplay != null) mplay.release();
                    play2.setImageResource(R.drawable.play_icon);
                    play2.setTag("NOT_PLAYING");
                }
            }
        });
















        /* play3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(play3.getTag() != null && play3.getTag().toString().contains("NOT_PLAYING")){
                    if(mplay!=null) mplay.release();
                    mplay = MediaPlayer.create(MainActivity.this,R.raw.shopno_amar);
                    mplay.start();
                    play3.setImageResource(R.drawable.stop_icon_red);
                    play3.setTag("PLAYING");

                    mplay.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            play3.setImageResource(R.drawable.play_icon);
                            play3.setTag("NOT_PLAYING");
                        }
                    });



                }
                else{
                    if(mplay != null) mplay.release();
                    play3.setImageResource(R.drawable.play_icon);
                    play3.setTag("NOT_PLAYING");
                }
            }
        });
        play4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(play4.getTag() != null && play4.getTag().toString().contains("NOT_PLAYING")){
                    if(mplay!=null) mplay.release();
                    mplay = MediaPlayer.create(MainActivity.this,R.raw.assubhu_bada);
                    mplay.start();
                    play4.setImageResource(R.drawable.stop_icon_red);
                    play4.setTag("PLAYING");

                    mplay.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            play4.setImageResource(R.drawable.play_icon);
                            play4.setTag("NOT_PLAYING");
                        }
                    });



                }
                else{
                    if(mplay != null) mplay.release();
                    play4.setImageResource(R.drawable.play_icon);
                    play4.setTag("NOT_PLAYING");
                }
            }
        });
        play5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(play5.getTag() != null && play5.getTag().toString().contains("NOT_PLAYING")){
                    if(mplay!=null) mplay.release();
                    mplay = MediaPlayer.create(MainActivity.this,R.raw.moira_gele_fira_asena);
                    mplay.start();
                    play5.setImageResource(R.drawable.stop_icon_red);
                    play5.setTag("PLAYING");

                    mplay.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            play5.setImageResource(R.drawable.play_icon);
                            play5.setTag("NOT_PLAYING");
                        }
                    });

                }
                else{
                    if(mplay != null) mplay.release();
                    play5.setImageResource(R.drawable.play_icon);
                    play5.setTag("NOT_PLAYING");
                }
            }
        });
        play6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(play6.getTag() != null && play6.getTag().toString().contains("NOT_PLAYING")){
                    if(mplay!=null) mplay.release();
                    mplay = MediaPlayer.create(MainActivity.this,R.raw.assubhu_bada);
                    mplay.start();
                    play6.setImageResource(R.drawable.stop_icon_red);
                    play6.setTag("PLAYING");

                    mplay.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            play6.setImageResource(R.drawable.play_icon);
                            play6.setTag("NOT_PLAYING");
                        }
                    });
                }
                else{
                    if(mplay != null) mplay.release();
                    play6.setImageResource(R.drawable.play_icon);
                    play6.setTag("NOT_PLAYING");
                }
            }
        });
        play7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(play7.getTag() != null && play7.getTag().toString().contains("NOT_PLAYING")){
                    if(mplay!=null) mplay.release();
                    mplay = MediaPlayer.create(MainActivity.this,R.raw.assubhu_bada);
                    mplay.start();
                    play7.setImageResource(R.drawable.stop_icon_red);
                    play7.setTag("PLAYING");

                    mplay.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            play7.setImageResource(R.drawable.play_icon);
                            play7.setTag("NOT_PLAYING");
                        }
                    });
                }
                else{
                    if(mplay != null) mplay.release();
                    play7.setImageResource(R.drawable.play_icon);
                    play7.setTag("NOT_PLAYING");
                }
            }
        });
        */

    }
}