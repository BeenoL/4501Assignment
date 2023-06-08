package com.example.a4501assignment.recordControl;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a4501assignment.R;

public class MyViewHolder extends RecyclerView.ViewHolder {
//Item inside the RecyclerView

    public TextView name;
    public TextView moves;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        moves = itemView.findViewById(R.id.moves);
    }
}
