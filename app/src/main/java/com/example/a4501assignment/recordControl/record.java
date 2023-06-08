package com.example.a4501assignment.recordControl;

public class record {
    private int moves;
    private String time, daytime;

    public record(int moves, String time, String dayTime){
        this.moves = moves;
        this.daytime =dayTime;
        this.time = time;
    }

    public int getMoves(){
        return moves;
    }

    public String getTime(){
        return time;
    }

    public String getDaytime(){
        return daytime;
    }
}
