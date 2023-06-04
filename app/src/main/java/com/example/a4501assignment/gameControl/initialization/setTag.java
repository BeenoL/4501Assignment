package com.example.a4501assignment.gameControl.initialization;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class setTag {



    public static void setTag(ArrayList<ImageView> buttonList){
        ArrayList<Integer> buttonTag = new ArrayList<>();
        Random random = new Random();
        for(int i  = 0; i < 4; i++){
            for(int j = 0; j < 2; j++){
                buttonTag.add(i+1);
            }
        }
        Collections.shuffle(buttonTag);
        for(int n = 0; n < buttonList.size(); n++){
            buttonList.get(n).setTag(buttonTag.get(n));
        }
    }
}
