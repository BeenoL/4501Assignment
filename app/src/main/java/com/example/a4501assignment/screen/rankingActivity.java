package com.example.a4501assignment.screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.a4501assignment.R;
import com.example.a4501assignment.jsonControl.MyAdapter;
import com.example.a4501assignment.jsonControl.MyThread;
import com.example.a4501assignment.rankingControl.ranking;

import java.util.ArrayList;

public class rankingActivity extends AppCompatActivity {

    private ListView rankingList;
    private MyAdapter adapter;
    ArrayList<ranking> dataArray;
    MyThread myThread;
    String url = "https://ranking-mobileasignment-wlicpnigvf.cn-hongkong.fcapp.run";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        url = getApplication().getResources().getString(R.string.url);  //set the url to provided json url
        rankingList = findViewById(R.id.rankingList);      //initialize the listview
        myThread = new MyThread(url, dataArray);
        myThread.fetchJSON();
        while(myThread.parsingComplete);

        dataArray = myThread.getListIiem();
        adapter = new MyAdapter(getApplicationContext(), dataArray);
    }
}