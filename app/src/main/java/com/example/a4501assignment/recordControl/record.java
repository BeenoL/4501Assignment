package com.example.a4501assignment.recordControl;

public class record {           //record item for converting record from database to list item
    private int moves;
    private String time, daytime;

    public record(int moves, String time, String dayTime){
        this.moves = moves;
        this.daytime =dayTime;
        this.time = time;
    }

    public String getMoves(){
        return String.valueOf(moves);
    }

    public String getTime(){
        return time;
    }

    public String getDaytime(){
        return daytime;
    }
}
