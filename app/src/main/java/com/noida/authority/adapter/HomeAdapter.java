package com.noida.authority.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.noida.authority.R;
import com.noida.authority.activity.ComplaintActivity;
import com.noida.authority.activity.GeneralInstruction;
import com.noida.authority.activity.GraphActivity;
import com.noida.authority.activity.LoginActivity;
import com.noida.authority.activity.SearchActivity;
import com.noida.authority.activity.WebVersion;
import com.noida.authority.utils.SessionManager;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyHolder> {
    Context context;
    Dialog dialogLayout;
    SessionManager sessionManager;
    boolean yes;

    public HomeAdapter(Context context) {
        this.context = context;
        sessionManager = new SessionManager(context);
        yes = sessionManager.getKyaStatus();

    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.adapter_home, parent, false);
        return new MyHolder(v);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        if (position == 0) {
            holder.imgProduct.setImageResource(R.drawable.ic_property_services);
            holder.txtItemName.setText("Property & Services");

        } else if (position == 1) {
            holder.imgProduct.setImageResource(R.drawable.ic_complaint);
            holder.txtItemName.setText("Complaint");
        } else if (position == 2) {
            holder.imgProduct.setImageResource(R.drawable.ic_information);
            holder.txtItemName.setText("Information");

        } else if (position == 3) {
            holder.imgProduct.setImageResource(R.drawable.ic_know_your_alotte);
            holder.txtItemName.setText("Know your allottee");

        } /*else if (position == 4) {
            holder.imgProduct.setImageResource(R.drawable.ic_graph);
            holder.txtItemName.setText("Dashboard");

        } */
        else if (position == 4) {
            holder.rvStatus.setVisibility(View.VISIBLE);
            holder.imgProduct.setImageResource(R.drawable.ic_kya);
            holder.txtItemName.setText("Perform KYA");
            if (yes) {
                holder.txtStatus.setText("Verified");
            } else {
                holder.imgStatus.setBackgroundTintList(context.getResources().getColorStateList(R.color.colorAccent));

                holder.txtStatus.setText("Unverified");
            }
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView imgProduct;
        TextView txtItemName;
        RelativeLayout rvStatus;
        TextView txtStatus;
        ImageView imgStatus;


        public MyHolder(@NonNull View itemView) {
            super(itemView);

            imgProduct = itemView.findViewById(R.id.imgProduct);
            txtItemName = itemView.findViewById(R.id.txtItemName);
            rvStatus = itemView.findViewById(R.id.rvStatus);
            txtStatus = itemView.findViewById(R.id.txtStatus);
            imgStatus = itemView.findViewById(R.id.imgStatus);

            itemView.setOnClickListener(v -> {
                if (getAdapterPosition() == 0) {

                    Intent i = new Intent(context, WebVersion.class);
                    context.startActivity(i);

                } else if (getAdapterPosition() == 1) {
                    Intent i = new Intent(context, ComplaintActivity.class);
                    context.startActivity(i);
                } else if (getAdapterPosition() == 2) {

                    Toast.makeText(context, "Work in progress", Toast.LENGTH_LONG).show();
                   /* Intent i = new Intent(context, GeneralInstruction.class);
                    context.startActivity(i);*/

                } else if (getAdapterPosition() == 3) {
                    Toast.makeText(context, "Work in progress", Toast.LENGTH_LONG).show();
                    /*Intent i = new Intent(context, SearchActivity.class);
                    context.startActivity(i);*/
                } /*else if (getAdapterPosition() == 4) {

                    Intent i = new Intent(context, GraphActivity.class);
                    context.startActivity(i);
                } */else if (getAdapterPosition() == 4) {

                    if (yes) {
                        Intent i = new Intent(context, GeneralInstruction.class);
                        context.startActivity(i);
                    } else {

                        Intent i = new Intent(context, GeneralInstruction.class);
                        context.startActivity(i);

                    }

                    //callDialog();
                }
            });
        }
    }
}