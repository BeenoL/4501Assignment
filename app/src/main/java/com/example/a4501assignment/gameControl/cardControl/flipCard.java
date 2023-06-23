package com.example.a4501assignment.gameControl.cardControl;

import android.widget.ImageView;

public class flipCard {

    public static void flipToTop(ImageView card){
        flipToTop.flipToTop(card);                              //show the image behind when clicked
    }

    public static void flipToBottom(ImageView card1, ImageView card2){
        flipToBottom.flipToBottom(card1, card2);                //flip back when they are not match
    }
}
