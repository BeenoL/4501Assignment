package com.example.a4501assignment.soundControl;

import android.content.Context;
import android.media.MediaPlayer;

import com.example.a4501assignment.R;

public class onPlayScreenMusic {
    MediaPlayer mediaPlayer;

    public onPlayScreenMusic(Context context){
        mediaPlayer = MediaPlayer.create(context, R.raw.screen);
    }

    public void playScreenMusic(){
        mediaPlayer.start();
    }

    public void stopScreenMusic(){
        mediaPlayer.pause();
    }

    public void releaseBackgroundMusic(){
        mediaPlayer.release();
    }
}
