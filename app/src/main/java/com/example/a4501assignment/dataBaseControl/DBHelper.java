package com.example.a4501assignment.dataBaseControl;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.io.File;

public class DBHelper {

    static SQLiteDatabase database;
    static String sql;
    static Cursor cursor;

    public static void openDataBase(Context context){
        File outFile = context.getDatabasePath("Record");
        String outFileName = outFile.getPath();
        database = SQLiteDatabase.openDatabase(outFileName, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        sql = "CREATE TABLE Record (ID int PRIMARY KEY AUTOINCREMENT, Step int, Time text);";
        database.execSQL(sql);
        database.close();
    }

    public static void readRecord(Context context){
        try {
            File outFile = context.getDatabasePath("Record");
            String outFileName = outFile.getPath();
            database = SQLiteDatabase.openDatabase(outFileName, null, SQLiteDatabase.OPEN_READONLY);
            cursor = database.rawQuery("SELECT * FROM Record", null);
            database.close();
        }catch (SQLException e){
           Toast.makeText(context.getApplicationContext(), "Something Wrong", Toast.LENGTH_SHORT).show();
        }
    }

              //  db.execSQL("INSERT INTO Seller(sID, sPassword, sName, sGender) values"
              //          + "(1005, 'pswd1005', 'Josephine', 'F'); ");

    public static void writeRecord(Context context, int step, String time){
        try {
            File outFile = context.getDatabasePath("Record");
            String outFileName = outFile.getPath();
            database = SQLiteDatabase.openDatabase(outFileName, null, SQLiteDatabase.OPEN_READWRITE);
            database.execSQL("INSERT INTO Record(Step, Time) values + " + "(" + step + time + ");");
            database.close();
        }catch (SQLException e){
            Toast.makeText(context.getApplicationContext(), "Something Wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
