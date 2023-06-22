package com.example.a4501assignment.screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.a4501assignment.R;
import com.example.a4501assignment.dataBaseControl.DBHelper;
import com.example.a4501assignment.soundControl.onPlayScreenMusic;

public class MainActivity extends AppCompatActivity {
    ImageView startButton, rankingButton, recordButton, quitButton, musicButton;
    public static int music = 1;
    com.example.a4501assignment.soundControl.onPlayScreenMusic onPlayScreenMusic;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = findViewById(R.id.startButton);
        rankingButton = findViewById(R.id.rankingButton);
        recordButton = findViewById(R.id.recordButton);
        quitButton = findViewById(R.id.quitButton);
        musicButton = findViewById(R.id.button_music);
        preferences = this.getSharedPreferences("music", MODE_PRIVATE);  //get user music preferences
        music = preferences.getInt("music", 1);
        onPlayScreenMusic = new onPlayScreenMusic(getApplicationContext());
        if (music == 1){
            musicButton.setBackgroundResource(R.drawable.music);        //if user set to play the sound
            onPlayScreenMusic.playScreenMusic();                        //set the music icon and play the music
        }else{
            musicButton.setBackgroundResource(R.drawable.mute);         //else set the mute icon
        }
        openDatabase();
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayScreenMusic.stopScreenMusic();
                Intent intent = new Intent(MainActivity.this, gameActivity.class);  //start new game
                startActivity(intent);
            }
        });

        rankingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, rankingActivity.class);  //see online ranking
                startActivity(intent);
            }
        });

        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, recordActivity.class);  //show play record
                startActivity(intent);
            }
        });

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override                                                                           //close game
            public void onClick(View v) {
                DBHelper.database.close();                                                      //close database
                onPlayScreenMusic.releaseBackgroundMusic();                                     //close music
                finish();
            }
        });

        musicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.music == 0){                                                    //start background music
                    onPlayScreenMusic.playScreenMusic();                                        // set  the music icon to music icon
                    musicButton.setBackgroundResource(R.drawable.music);
                    MainActivity.music = 1;
                }else {
                    onPlayScreenMusic.stopScreenMusic();                                        //stop background music
                    MainActivity.music = 0;
                    musicButton.setBackgroundResource(R.drawable.mute);                         //set the music icon to mute icon
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
        if(MainActivity.music == 1){                                                    //start background music
            onPlayScreenMusic.playScreenMusic();
        }
    }

    @Override
    protected void onDestroy() {
        editor = preferences.edit();                                                    //save user preferences
        editor.putInt("music", music);
        editor.commit();
        super.onDestroy();

    }

    private void openDatabase(){
        DBHelper.openDataBase(getApplicationContext());                                 //method for open database
    }
}