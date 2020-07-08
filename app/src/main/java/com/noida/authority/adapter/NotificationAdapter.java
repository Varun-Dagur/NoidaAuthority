package com.noida.authority.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.noida.authority.R;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyHolder> {
    Context context;

    int[] picList = {R.drawable.demoimg, R.drawable.demo_img_house,
            R.drawable.img_road, R.drawable.demoimg};

    public NotificationAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public NotificationAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.notification_row, parent, false);
        return new NotificationAdapter.MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.MyHolder holder, int position) {

        holder.imgProduct.setImageResource(picList[position]);
    }

    @Override
    public int getItemCount() {
        return picList.length;
    }

    public class MyHolder extends RecyclerView.ViewHolder {


        ImageView imgProduct;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.imgProduct);


        }
    }
}


