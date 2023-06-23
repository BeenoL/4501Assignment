package com.example.a4501assignment.rankingControl;

public class ranking {          //ranking item for converting record from api to list item
    private String name;
    private int moves;

    public ranking(String name, int moves){
        this.name = name;
        this.moves = moves;
    }

    public String getName(){
        return name;
    }

    public int getMoves(){
        return moves;
    }
}
