package com.example.a4501assignment.jsonControl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.a4501assignment.R;
import com.example.a4501assignment.rankingControl.ranking;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<ranking> mData;
    public MyAdapter(Context context, ArrayList<ranking> mData){
        this.context = context;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public ranking getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.rankinglayout, parent, false);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView moves = (TextView) convertView.findViewById(R.id.moves);
        name.setText("Name : " + mData.get(position).getName());
        moves.setText("Moves: " + mData.get(position).getMoves());
        return convertView;
    }
}