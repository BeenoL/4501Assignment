package com.example.a4501assignment.dataBaseControl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBHelper {

    public static SQLiteDatabase database;
    static String sql;
    static Cursor cursor;

    public static void openDataBase(Context context){               //create and open database when
        File outFile = context.getDatabasePath("Record");
        String outFileName = outFile.getPath();
        database = SQLiteDatabase.openDatabase(outFileName, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        sql = "CREATE TABLE IF NOT EXISTS Record (ID INTEGER PRIMARY KEY AUTOINCREMENT, Step int, Time text, dayTime text);";
        database.execSQL(sql);
        database.close();
    }

    public static Cursor readRecord(Context context){               //get user play record
        try {
            File outFile = context.getDatabasePath("Record");
            String outFileName = outFile.getPath();
            database = SQLiteDatabase.openDatabase(outFileName, null, SQLiteDatabase.OPEN_READONLY);
            cursor = database.rawQuery("SELECT Step, Time, dayTime FROM Record ORDER BY ID DESC", null);
        }catch (SQLException e){
           Toast.makeText(context.getApplicationContext(), "Read Wrong", Toast.LENGTH_SHORT).show();
        }
        return cursor;
    }

    public static void writeRecord(Context context, int moves, String time, String dayTime){    //write record to database
        try {
            File outFile = context.getDatabasePath("Record");
            String outFileName = outFile.getPath();
            database = SQLiteDatabase.openDatabase(outFileName, null, SQLiteDatabase.OPEN_READWRITE);
            ContentValues insert = new ContentValues();
            insert.put("Step", moves);
            insert.put("Time", time);
            insert.put("dayTime", dayTime);
            int result = (int) database.insert("Record", null, insert);
        }catch (SQLException e){
            Toast.makeText(context.getApplicationContext(), "Insert Wrong", Toast.LENGTH_SHORT).show();
        }
    }

}
