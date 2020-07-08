package com.noida.authority.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import com.noida.authority.R;
import com.noida.authority.activity.ComplaintDetailsActivity;
import com.noida.authority.activity.OfficerComplaintDetailsActivity;


public class OfficerComplainAdapter extends RecyclerView.Adapter<OfficerComplainAdapter.MyHolder> {
    Context context;

    public OfficerComplainAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public OfficerComplainAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.officer_request_row, parent, false);
        return new OfficerComplainAdapter.MyHolder(v);
    }

    @SuppressLint("NewApi")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        if (position == 0) {
            holder.viewStatus.setBackgroundTintList(ColorStateList.valueOf(context.getColor(R.color.colorBlueLight)));

            holder.txtStatus.setText("Demand");
        } else if (position == 1) {
            holder.viewStatus.setBackgroundTintList(ColorStateList.valueOf(context.getColor(R.color.colorAccent)));

            holder.txtStatus.setText("IN PROGRESS");

        } else if (position == 2) {
            holder.viewStatus.setBackgroundTintList(ColorStateList.valueOf(context.getColor(R.color.colorAccent)));

            holder.txtStatus.setText("IN PROGRESS");

        }
    }




    @Override
    public int getItemCount() {
        return 3;
    }

    public class MyHolder extends RecyclerView.ViewHolder {


        TextView txtDetails, txtStatus;
        View viewStatus;

        public MyHolder(@NonNull View itemView) {
            super(itemView);


            txtDetails = itemView.findViewById(R.id.txtDetails);
            txtStatus = itemView.findViewById(R.id.txtStatus);
            viewStatus = itemView.findViewById(R.id.viewStatus);

            txtDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() == 0) {

                        Intent i = new Intent(context, OfficerComplaintDetailsActivity.class);
                        i.putExtra("Demand", "Demand");
                        context.startActivity(i);
                    } else if (getAdapterPosition() == 1) {

                        Intent i = new Intent(context, OfficerComplaintDetailsActivity.class);
                        context.startActivity(i);
                    } else if (getAdapterPosition() == 2) {

                        Intent i = new Intent(context, OfficerComplaintDetailsActivity.class);
                        context.startActivity(i);
                    }

                }
            });
        }
    }
}

