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
            JSONArray jsonArray = new JSONArray(jsonObject.getJSONArray("campus"));
            listIiem = new String[jsonArray.length()];
            for(int i = 0; i < listIiem.length; i++){
                listIiem[i] = jsonArray.getJSONObject(i).getString("code");
            }
            parsingComplete = false;
        }catch(Exception e){
            Log.d("hi", e.getMessage());
        }
    }

    public void fetchJSON(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url1 = new URL(url);
                    HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
                    connection.setConnectTimeout(1000000);
                    connection.setReadTimeout(10000);
                    connection.setRequestMethod("GET");
                    connection.setDoInput(true);
                    connection.connect();

                    InputStream inputStream = connection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    int inputStreamData = inputStreamReader.read();
                    while (inputStreamData != -1) {
                        char current = (char) inputStreamData;
                        inputStreamData = inputStreamReader.read();
                        data += current;
                    }
                    readJson(data);
                    inputStream.close();
                }catch (Exception e){
                    Log.d("hello", e.getMessage());
                }
            }
        });
        thread.start();
    }
}
