package com.example.a4501assignment.jsonControl;

import android.util.Log;

import com.example.a4501assignment.rankingControl.ranking;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MyThread {

    private String url;
    ArrayList<ranking> listIiem;
    String data = "";

    public volatile boolean parsingComplete = true;

    public MyThread(String url, ArrayList<ranking> listIiem){
        this.listIiem = null;
        this.listIiem = listIiem;
        this.url = url;
    }

    public ArrayList getListIiem(){
        return listIiem;
    }

    public void readJson(String data){
        try{
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = new JSONArray(jsonObject.getJSONArray(""));
            listIiem = new ArrayList<>();
            for(int i = 0; i < jsonArray.length(); i++){
                String name = jsonArray.getJSONObject(i).getString("Name");     //decode the JSON and put it into Arraylist
                int moves = jsonArray.getJSONObject(i).getInt("Moves");
                ranking ranking = new ranking(name, moves);
                listIiem.add(ranking);                                              //add item into arrayList
            }
            parsingComplete = false;    //parsing complete
        }catch(Exception e){
            Log.d("getJson", e.getMessage());
        }
    }

    public void fetchJSON(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url1 = new URL(url);
                    HttpURLConnection connection = (HttpURLConnection) url1.openConnection();   //read JSON from provided website
                    connection.setConnectTimeout(10000);
                    connection.setReadTimeout(10000);
                    connection.setRequestMethod("GET");
                    connection.setDoInput(true);
                    connection.connect();

                    InputStream inputStream = connection.getInputStream();      //put the received items into data
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    int inputStreamData = inputStreamReader.read();             //
                    while (inputStreamData != -1) {             //
                        char current = (char) inputStreamData;              //
                        inputStreamData = inputStreamReader.read();             //
                        data += current;                //
                    }               //
                    readJson(data);
                    inputStream.close();
                }catch (Exception e){
                    Log.d("connection", e.getMessage());
                }
            }
        });
        thread.start();
    }
}
