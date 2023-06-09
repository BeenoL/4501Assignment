package com.example.a4501assignment.screen;

import static com.example.a4501assignment.recordControl.readRecord.readRecord;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a4501assignment.R;
import com.example.a4501assignment.dataBaseControl.DBHelper;
import com.example.a4501assignment.recordControl.MyAdapter;
import com.example.a4501assignment.recordControl.readRecord;
import com.example.a4501assignment.recordControl.record;

import java.util.ArrayList;

public class recordActivity extends AppCompatActivity {
    ListView recordList;
    Cursor cursor;
    MyAdapter myAdapter;
    ArrayList<record> records;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        recordList = findViewById(R.id.recordList);

        records = new ArrayList<>();
        cursor = DBHelper.readRecord(getApplicationContext());
        records = readRecord.readRecord(cursor, records);
        myAdapter = new MyAdapter(getApplicationContext(), records);
        recordList.setAdapter(myAdapter);
    }
}