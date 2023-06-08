package com.example.a4501assignment.screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a4501assignment.R;
import com.example.a4501assignment.dataBaseControl.DBHelper;

public class MainActivity extends AppCompatActivity {
    Button startButton, rankingButton, recordButton, quitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = findViewById(R.id.startButton);
        rankingButton = findViewById(R.id.rankingButton);
        recordButton = findViewById(R.id.recordButton);
        quitButton = findViewById(R.id.quitButton);
        openDatabase();
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
    }

    private void openDatabase(){
        DBHelper.openDataBase(getApplicationContext());
    }
}