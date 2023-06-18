package com.example.a4501assignment.recordControl;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a4501assignment.R;

import java.util.ArrayList;


public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<record> mData;
    public MyAdapter(Context context, ArrayList<record> mData){
        this.context = context;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.recordlayout, parent, false);
        TextView dayTime = (TextView) convertView.findViewById(R.id.dayTime);
        TextView time = (TextView) convertView.findViewById(R.id.recordTime);
        TextView moves = (TextView) convertView.findViewById(R.id.recordMoves);
        dayTime.setText("" + mData.get(position).getDaytime());
        time.setText("" + mData.get(position).getTime() + "s");
        moves.setText("" + mData.get(position).getMoves());
        return convertView;
    }
}