package gameControl;

import cardControl.card;

public class isMatch {

    private card card1, card2;



    public static boolean isMatch(card card1, card card2){
        if(card1 == card2){
            return true;
        }else{
            return false;
        }
    }

}
