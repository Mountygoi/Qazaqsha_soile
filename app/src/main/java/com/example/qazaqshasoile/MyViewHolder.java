package com.example.qazaqshasoile;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView surett;
    TextView adi;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
   surett = itemView.findViewById(R.id.surett);
   adi = itemView.findViewById(R.id.adi);

    }
}
