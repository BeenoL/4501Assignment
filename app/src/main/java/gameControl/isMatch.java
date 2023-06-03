package gameControl;

import android.widget.ImageView;

import gameControl.cardControl.card;

public class isMatch {

    private card card1, card2;
    public static boolean isMatch(ImageView card1, ImageView card2){
        if(card1.getTag() == card2.getTag()){
            return true;
        }else{
            return false;
        }
    }

}
