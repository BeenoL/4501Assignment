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

    public static void openDataBase(Context context){
        File outFile = context.getDatabasePath("Record");
        String outFileName = outFile.getPath();
        database = SQLiteDatabase.openDatabase(outFileName, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        //sql = "DROP TABLE IF EXISTS Record";
        //database.execSQL(sql);
        sql = "CREATE TABLE IF NOT EXISTS Record (ID INTEGER PRIMARY KEY AUTOINCREMENT, Step int, Time text, dayTime text);";
        database.execSQL(sql);
        database.close();
        //database = SQLiteDatabase.openDatabase(outFileName, null, SQLiteDatabase.OPEN_READWRITE);
        //database.execSQL(sql);
    }

    public static Cursor readRecord(Context context){
        try {
            File outFile = context.getDatabasePath("Record");
            String outFileName = outFile.getPath();
            database = SQLiteDatabase.openDatabase(outFileName, null, SQLiteDatabase.OPEN_READONLY);
            cursor = database.rawQuery("SELECT Step, Time, dayTime FROM Record ORDER BY ID DESC", null);
            //database.close();
        }catch (SQLException e){
           Toast.makeText(context.getApplicationContext(), "Read Wrong", Toast.LENGTH_SHORT).show();
        }
        return cursor;
    }

              //  db.execSQL("INSERT INTO Seller(sID, sPassword, sName, sGender) values"
              //          + "(1005, 'pswd1005', 'Josephine', 'F'); ");

    public static void writeRecord(Context context, int moves, String time, String dayTime){
        try {
            File outFile = context.getDatabasePath("Record");
            String outFileName = outFile.getPath();
            database = SQLiteDatabase.openDatabase(outFileName, null, SQLiteDatabase.OPEN_READWRITE);
            //database.execSQL("INSERT INTO Record (Step, Time, dayTime) VALUES (" + moves + ", " + time + ", " + dayTime+ ");");
            //(1) near "12": syntax error in "INSERT INTO Record (Step, Time, dayTime) VALUES (8, 62, 08/06/2023 12:31);"
            //database.execSQL("INSERT INTO Record (Step, Time, dayTime) VALUES (" + 1 + ", " + "time" + ", " + "dayTime" + ");");
            //no such column: time in "INSERT INTO Record (Step, Time, dayTime) VALUES (1, time, dayTime);"
            //database.close();
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
