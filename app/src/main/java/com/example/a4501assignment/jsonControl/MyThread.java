package com.example.a4501assignment.jsonControl;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyThread {

    private String url;
    String[] listIiem;
    String data = "";

    public volatile boolean parsingComplete = true;

    public MyThread(String url){
        this.url = url;
    }

    public String[] getListIiem(){
        return listIiem;
    }

    public void readJson(String data){
        try{
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = new JSONArray(jsonObject.getJSONArray(""));
            listIiem = new String[jsonArray.length()];
            for(int i = 0; i < (listIiem.length)*2; i++){
                listIiem[i] = jsonArray.getJSONObject(i).getString("Name");     //decode the JSON and put it into String array
                listIiem[2*i] = String.valueOf(jsonArray.getJSONObject(i).getInt("Moves"));
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
