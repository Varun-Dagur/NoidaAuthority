package com.noida.authority.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.noida.authority.R;
import com.noida.authority.body_model.DrawerCategory;

import java.util.List;

public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.MyHolder> {
    Context context;

    List<DrawerCategory> list;

    public DrawerAdapter(Context context, List<DrawerCategory> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DrawerAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.nav_list_row, parent, false);
        return new DrawerAdapter.MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DrawerAdapter.MyHolder holder, int position) {

        holder.icon.setImageResource(list.get(position).getIcon());
        holder.category.setText(list.get(position).getCategory());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView category;
        ImageView icon;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.icon);
            category = itemView.findViewById(R.id.category);

        }
    }
}