package com.example.a4501assignment.soundControl;

import android.content.Context;
import android.media.MediaPlayer;

import com.example.a4501assignment.R;

public class onPlayBackgroundSound {

    MediaPlayer mediaPlayer;

    public onPlayBackgroundSound(Context context){
        mediaPlayer = MediaPlayer.create(context, R.raw.background);
    }

    public void playBackgroundMusic(){
        mediaPlayer.start();
    }

    public void stopBackgroundMusic(){
        mediaPlayer.pause();
    }

    public void releaseBackgroundMusic(){
        mediaPlayer.release();
    }
}
