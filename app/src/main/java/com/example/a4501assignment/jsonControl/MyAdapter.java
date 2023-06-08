package com.example.a4501assignment.jsonControl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a4501assignment.R;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    String[] mData;
    private OnRecyclerViewClickListener listener;
    public MyAdapter(Context context, String[] mData){
        this.context = context;
        this.mData = mData;
    }

    public void setItemClickListener(OnRecyclerViewClickListener itemClickListener){
        listener = itemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        if(listener != null){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClickListener(view);
                }
            });
        }

        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtItem.setText(mData[position]);

    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

}