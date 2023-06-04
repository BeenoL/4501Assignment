package com.example.a4501assignment.screen;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a4501assignment.R;
import java.util.ArrayList;

import com.example.a4501assignment.gameControl.cardControl.flipCard;
import com.example.a4501assignment.gameControl.checkFinish;
import com.example.a4501assignment.gameControl.initialization.setCardBackground;
import com.example.a4501assignment.gameControl.initialization.setTag;
import com.example.a4501assignment.gameControl.isMatch;

public class gameActivity extends AppCompatActivity {

    TextView tv_time, tv_step;
    ImageView button1, button2, button3, button4, button5, button6, button7, button8;
    ArrayList<ImageView> buttonList = new ArrayList<>();
    int step = 1;
    int matched = 0;
    ImageView cardA, cardB;
    Handler handler = new Handler();

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
        //for(int i = 0; i < buttonList.size(); i++){
        //    buttonList.get(i).setOnClickListener(new View.OnClickListener() {
        //        @Override
        //        public void onClick(View v) {
        //
        //        }
        //    });
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
    }

    public void setCard(ImageView card){
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
        step++;                                     //moved one step
        if(isMatch.isMatch(card1, card2)){
            matched++;
            Toast.makeText(getApplicationContext(), "Matched", Toast.LENGTH_SHORT).show();
            card1.setAlpha(0.5f);
            card2.setAlpha(0.5f);                   //show the card in transparent if matched
            if(checkFinish.checkFinish(matched)){   //if the game is finished
                                                    //show dialog
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

            //tv_step.setText((int)step);                  //update the step text
        }
        this.cardA = null;                      //clear the saved value
        this.cardB = null;
    }
}