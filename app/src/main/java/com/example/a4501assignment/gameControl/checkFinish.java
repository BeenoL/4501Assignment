package com.example.a4501assignment.gameControl;

public class checkFinish {

    public static boolean checkFinish(int matchedPair){     //check there are 4 matched pairs or not
        if(matchedPair == 4){           //if there are 4 matched pairs
            return true;                //return ture
        }else{
            return false;               // if not, return false
        }
    }
}
