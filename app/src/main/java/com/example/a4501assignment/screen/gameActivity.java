package com.example.a4501assignment.screen;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a4501assignment.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.example.a4501assignment.dataBaseControl.DBHelper;
import com.example.a4501assignment.gameControl.cardControl.flipCard;
import com.example.a4501assignment.gameControl.checkFinish;
import com.example.a4501assignment.gameControl.initialization.setCardBackground;
import com.example.a4501assignment.gameControl.initialization.setTag;
import com.example.a4501assignment.gameControl.isMatch;
import com.example.a4501assignment.soundControl.onPlayBackgroundSound;
import com.example.a4501assignment.soundControl.playOnMatchSound;

public class gameActivity extends AppCompatActivity {

    TextView tv_time, tv_step;
    ImageView button1, button2, button3, button4, button5, button6, button7, button8;
    ImageView mute;
    ArrayList<ImageView> buttonList = new ArrayList<>();
    Dialog dialog;
    int moves = 0;
    int matched = 0;
    long time;
    ImageView cardA, cardB;
    Handler handler = new Handler();
    Timer timer;
    TimerTask task;
    com.example.a4501assignment.soundControl.onPlayBackgroundSound playBackgroundSound;
    com.example.a4501assignment.soundControl.playOnMatchSound playOnMatchSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        tv_time = findViewById(R.id.tv_time);
        tv_step = findViewById(R.id.tv_step);
        mute = findViewById(R.id.button_music);
        buttonList.add(button1);
        buttonList.add(button2);
        buttonList.add(button3);
        buttonList.add(button4);
        buttonList.add(button5);
        buttonList.add(button6);
        buttonList.add(button7);
        buttonList.add(button8);
        setCardBackground.setCardBackground(buttonList);
        setTag.setTag(buttonList);
        playBackgroundSound = new onPlayBackgroundSound(getApplicationContext());
        playOnMatchSound = new playOnMatchSound(getApplicationContext());
        if (MainActivity.music == 1){
            mute.setBackgroundResource(R.drawable.music);
            playBackgroundSound.playBackgroundMusic();
        }else{
            mute.setBackgroundResource(R.drawable.mute);
        }
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCard(button1);                   //set the card to compare value
                button1.setEnabled(false);          //user cannot click the same button again
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCard(button2);                   //set the card to compare value
                button2.setEnabled(false);          //user cannot click the same button again
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCard(button3);                   //set the card to compare value
                button3.setEnabled(false);          //user cannot click the same button again
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCard(button4);                   //set the card to compare value
                button4.setEnabled(false);          //user cannot click the same button again
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCard(button5);                   //set the card to compare value
                button5.setEnabled(false);          //user cannot click the same button again
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCard(button6);                   //set the card to compare value
                button6.setEnabled(false);          //user cannot click the same button again
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCard(button7);                   //set the card to compare value
                button7.setEnabled(false);          //user cannot click the same button again
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCard(button8);                   //set the card to compare value
                button8.setEnabled(false);          //user cannot click the same button again
            }
        });
        mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.music == 0){
                    playBackgroundSound.playBackgroundMusic();      //play the music and set the icon
                    mute.setBackgroundResource(R.drawable.music);
                    MainActivity.music = 1;
                }else {
                    playBackgroundSound.stopBackgroundMusic();      //stop the music and set the icon
                    mute.setBackgroundResource(R.drawable.mute);
                    MainActivity.music = 0;
                }
            }
        });
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        time++;                                 //timer for user to see
                        tv_time.setText(getTimerText() + "s");  //update the timer
                    }
                });
            }
        };
        timer.scheduleAtFixedRate(task, 0 ,1000);   //count every second
    }

    public void setCard(ImageView card){
        if (moves == 1) {
            time = System.currentTimeMillis();
        }
        if(this.cardA == null){                     //if no card is selected
            flipCard.flipToTop(card);               //flip card
            this.cardA = card;
        }else if(cardB == null){                    //if one card is selected
            flipCard.flipToTop(card);               //flip card
            this.cardB = card;
            isMatchOrNot(cardA, cardB);             //check two cards is match or not
        }
    }

    public void isMatchOrNot(ImageView card1, ImageView card2){
        moves++;                                     //moved one step
        if(isMatch.isMatch(card1, card2)){
            matched++;
            card1.setAlpha(0.5f);
            card2.setAlpha(0.5f);                   //show the card in transparent if matched
            if(MainActivity.music == 1){
                playOnMatchSound.playOnMatchSound();
            }
            if(checkFinish.checkFinish(matched)){   //if the game is finished
                time = (System.currentTimeMillis() - time)/1000;     //count the time needed to finish the game
                timer.cancel();
                dialog = new Dialog(this);
                dialog.setContentView(R.layout.dialoglayout);                                   //initialize dialog box
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(false);
                dialog.show();
                dialog.getWindow().getAttributes().windowAnimations = R.style.animation;        //show dialog
                ImageView reset = dialog.findViewById(R.id.reset);                              //set the button function
                ImageView save = dialog.findViewById(R.id.save);
                reset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();                       //don't save and restart the game
                        startActivity(getIntent());
                    }
                });
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DBHelper.writeRecord(getApplicationContext(), moves, String.valueOf(time), dateTimeConvert());  //save record into database
                        finish();                                               //exit the game
                    }
                });
            }
        }else{
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    flipCard.flipToBottom(card1, card2);    //flip back the cards
                    card1.setEnabled(true);                 //user can click the image again
                    card2.setEnabled(true);
                }
            }, 500);
        }
        tv_step.setText(String.valueOf(moves));             //update the step text
        this.cardA = null;                                  //clear the saved value
        this.cardB = null;
    }

    public String dateTimeConvert(){
        SimpleDateFormat simpleDate =  new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return simpleDate.format(new Date());               //convert time to date and time for saving into database
    }

    public void onStop() {
        super.onStop();
        playBackgroundSound.releaseBackgroundMusic();       //release the music player
        playOnMatchSound.releaseMatchSound();
    }

    private String getTimerText()                           //convert time to second
    {
        int rounded = (int) Math.round(time);
        int seconds = ((rounded % 86400) % 3600) % 60;
        return String.valueOf(seconds);
    }
}