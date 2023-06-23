package com.example.a4501assignment.gameControl.cardControl;

import android.widget.ImageView;

import com.example.a4501assignment.R;

public class flipToBottom {

    public static void flipToBottom(ImageView card1, ImageView card2){      //set the cards back to the back after checking two cards and they are not the same card
        card1.setBackgroundResource(R.drawable.back);
        card2.setBackgroundResource(R.drawable.back);
    }
}
