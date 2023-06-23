package com.example.a4501assignment.gameControl;

import android.widget.ImageView;

public class isMatch {

    public static boolean isMatch(ImageView card1, ImageView card2){        //check two cards is same or not
        if((int)card1.getTag() == (int)card2.getTag()){                     //if the tag behind the cards is the same
            return true;                                                    //the cards are the same and return true
        }else{
            return false;                                                   //if not, return false
        }
    }

}
