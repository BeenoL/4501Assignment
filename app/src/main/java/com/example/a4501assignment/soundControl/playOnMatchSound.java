package com.example.a4501assignment.soundControl;

import android.content.Context;
import android.media.MediaPlayer;

import com.example.a4501assignment.R;

public class playOnMatchSound {

    MediaPlayer mediaPlayer;

    public playOnMatchSound(Context context){
        mediaPlayer = MediaPlayer.create(context, R.raw.match);
    }

    public void playOnMatchSound(){
        mediaPlayer.start();
    }

    public void stopBackgroundMusic(){
        mediaPlayer.stop();
    }
}
