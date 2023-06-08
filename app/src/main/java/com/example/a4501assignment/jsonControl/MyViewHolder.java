package com.example.a4501assignment.jsonControl;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a4501assignment.R;

public class MyViewHolder extends RecyclerView.ViewHolder {
//Item inside the RecyclerView

    protected TextView txtItem;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        txtItem = itemView.findViewById(R.id.txtItem);
    }
}
