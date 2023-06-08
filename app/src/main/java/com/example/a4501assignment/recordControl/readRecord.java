package com.example.a4501assignment.recordControl;

import android.annotation.SuppressLint;
import android.database.Cursor;

import java.util.ArrayList;

public class readRecord {

    public static void readRecord(Cursor cursor, ArrayList<record> records){
        while(cursor.moveToNext()){
            @SuppressLint("Range") int moves = cursor.getInt(cursor.getColumnIndex("Step"));
            @SuppressLint("Range") String dayTime = cursor.getString(cursor.getColumnIndex("dayTime"));
            @SuppressLint("Range") String time = cursor.getString(cursor.getColumnIndex("Time"));
            record record = new record(moves, dayTime, time);
            records.add(record);
        }
    }
}
