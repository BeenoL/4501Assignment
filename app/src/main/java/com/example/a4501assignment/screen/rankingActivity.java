package com.example.a4501assignment.screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.a4501assignment.R;
import com.example.a4501assignment.jsonControl.MyAdapter;
import com.example.a4501assignment.jsonControl.MyThread;
import com.example.a4501assignment.jsonControl.OnRecyclerViewClickListener;

public class rankingActivity extends AppCompatActivity {

    private RecyclerView recycler_view;
    private MyAdapter adapter;
    String[] dataArray;
    MyThread myThread;
    String url = "https://ranking-mobileasignment-wlicpnigvf.cn-hongkong.fcapp.run";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        url = getApplication().getResources().getString(R.string.url);  //set the url to provided json url

        recycler_view = findViewById(R.id.rV);      //initialize the listview
        recycler_view.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MyAdapter(this, dataArray);
        recycler_view.setAdapter(adapter);

        myThread = new MyThread(url);
        myThread.fetchJSON();
        while(myThread.parsingComplete);

        dataArray = myThread.getListIiem();

    }
}