package com.example.a4501assignment.gameControl;

import android.widget.ImageView;

public class isMatch {

    public static boolean isMatch(ImageView card1, ImageView card2){
        if((int)card1.getTag() == (int)card2.getTag()){
            return true;
        }else{
            return false;
        }
    }

}
