package com.example.a4501assignment.screen;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a4501assignment.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
    int moves = 1;
    int matched = 0;
    long time;
    ImageView cardA, cardB;
    Handler handler = new Handler();
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
        if(MainActivity.music == 1){
            playBackgroundSound.playBackgroundMusic();
        }
        //for(int i = 0; i < buttonList.size(); i++){         Not work :(
        //    buttonList.get(i).setOnClickListener(new View.OnClickListener() {
        //        @Override
        //        public void onClick(View v) {
        //            setCard((ImageView) buttonList.get(j));
        //            buttonList.get(j).setEnabled(false);
        //        }
        //    });
        //    j++;
        //}
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
                    playBackgroundSound.playBackgroundMusic();
                    Log.d("music", MainActivity.music+"");
                    MainActivity.music = 1;
                }else {
                    playBackgroundSound.stopBackgroundMusic();
                    Log.d("music", MainActivity.music+"");
                    MainActivity.music = 0;
                }
            }
        });
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
            Toast.makeText(getApplicationContext(), "Matched", Toast.LENGTH_SHORT).show();
            card1.setAlpha(0.5f);
            card2.setAlpha(0.5f);                   //show the card in transparent if matched
            if(MainActivity.music == 1){
                playOnMatchSound.playOnMatchSound();
            }
            if(checkFinish.checkFinish(matched)){   //if the game is finished
                time = (System.currentTimeMillis() - time)/1000;     //count the time needed to finish the game
                Toast.makeText(this, String.valueOf(time) + "s", Toast.LENGTH_SHORT).show();
                //show dialog
                if(true){                           //If user save the record
                    DBHelper.writeRecord(getApplicationContext(), moves, String.valueOf(time), dateTimeConvert());  //insert into database
                }else{
                   // finish();                       //dont save and close the game
                }
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
        tv_step.setText(String.valueOf(moves));                  //update the step text
        this.cardA = null;                      //clear the saved value
        this.cardB = null;
    }

    public String dateTimeConvert(){
        SimpleDateFormat simpleDate =  new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return simpleDate.format(new Date());
    }

    public void onStop() {
        super.onStop();
        playBackgroundSound.releaseBackgroundMusic();
        playOnMatchSound.releaseMatchSound();
    }
}