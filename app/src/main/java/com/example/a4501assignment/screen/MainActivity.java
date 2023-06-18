package com.example.a4501assignment.screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.a4501assignment.R;
import com.example.a4501assignment.dataBaseControl.DBHelper;
import com.example.a4501assignment.soundControl.onPlayScreenMusic;

public class MainActivity extends AppCompatActivity {
    Button startButton, rankingButton, recordButton, quitButton, musicButton;
    public static int music = 1;
    com.example.a4501assignment.soundControl.onPlayScreenMusic onPlayScreenMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = findViewById(R.id.startButton);
        rankingButton = findViewById(R.id.rankingButton);
        recordButton = findViewById(R.id.recordButton);
        quitButton = findViewById(R.id.quitButton);
        musicButton = findViewById(R.id.button_music);
        onPlayScreenMusic = new onPlayScreenMusic(getApplicationContext());
        onPlayScreenMusic.playScreenMusic();
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
            @Override                                                                           //close the game
            public void onClick(View v) {
                DBHelper.database.close();
                finish();
            }
        });

        musicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.music == 0){                                                    //start background music
                    onPlayScreenMusic.playScreenMusic();
                    MainActivity.music = 1;
                }else {
                    onPlayScreenMusic.stopScreenMusic();                                        //stop background music
                    MainActivity.music = 0;
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
        super.onDestroy();
    }

    private void openDatabase(){
        DBHelper.openDataBase(getApplicationContext());
    }
}