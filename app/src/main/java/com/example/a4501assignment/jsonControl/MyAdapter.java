package com.example.a4501assignment.jsonControl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.a4501assignment.rankingControl.ranking;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<ranking> mData;
    public MyAdapter(Context context, ArrayList<ranking> mData){
        this.context = context;
        this.mData = mData;
    }

   //@NonNull
   //@Override
   //public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
   //    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rankinglayout, parent, false);

   //    MyViewHolder myViewHolder = new MyViewHolder(view);
   //    if(listener != null){
   //        view.setOnClickListener(new View.OnClickListener() {
   //            @Override
   //            public void onClick(View view) {
   //                listener.onItemClickListener(view);
   //            }
   //        });
   //    }
   //    return myViewHolder;
   //}

   //@Override
   //public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
   //    holder.name.setText(mData.get(position).getName());
   //    holder.moves.setText(mData.get(position).getMoves());
   //}

   //@Override
   //public int getItemCount() {
   //     return mData.size();
   // }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}