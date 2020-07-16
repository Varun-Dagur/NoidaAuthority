package com.noida.authority.adapter;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    public HomeClickListener clickListener;

    public HomeAdapter(Context context, HomeClickListener listener) {
        this.context = context;
        sessionManager = new SessionManager(context);
        yes = sessionManager.getKyaStatus();
        clickListener = listener;
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
            holder.imgProduct.setImageResource(R.drawable.ic_ilt_property_services);
            holder.txtItemName.setText("Property & Services");
            holder.layout.setBackgroundResource(R.color.colorGreen);
        } else if (position == 1) {
            holder.imgProduct.setImageResource(R.drawable.ic_ilt_complaint);
            holder.txtItemName.setText("Complaint");
            holder.layout.setBackgroundResource(R.color.colorBlue);
        } else if (position == 2) {
            holder.imgProduct.setImageResource(R.drawable.ic_ilt_information);
            holder.txtItemName.setText("Information");
            holder.layout.setBackgroundResource(R.color.colorYellow);

        } else if (position == 3) {
            holder.imgProduct.setImageResource(R.drawable.ic_ilt_new_ipdates);
            holder.txtItemName.setText("Know your allottee");
            holder.layout.setBackgroundResource(R.color.colorRedish);

        } else if (position == 4) {

            holder.imgProduct.setImageResource(R.drawable.ic_ilt_new_ipdates);
            holder.txtItemName.setText("Noida Jal");
            holder.layout.setBackgroundResource(R.color.colorGreen);

        }
        else if (position == 5) {

            holder.imgProduct.setImageResource(R.drawable.ic_ilt_new_ipdates);
            holder.txtItemName.setText("ERP");
            holder.layout.setBackgroundResource(R.color.colorBlue);

        }
        else if (position == 6) {

            holder.imgProduct.setImageResource(R.drawable.ic_ilt_new_ipdates);
            holder.txtItemName.setText("Authority Online");
            holder.layout.setBackgroundResource(R.color.colorYellow);

        }
        else if (position == 7) {

            holder.imgProduct.setImageResource(R.drawable.ic_ilt_new_ipdates);
            holder.txtItemName.setText("Building Map Approval");
            holder.layout.setBackgroundResource(R.color.colorRedish);

        }
        else if (position == 8) {

            holder.imgProduct.setImageResource(R.drawable.ic_ilt_new_ipdates);
            holder.txtItemName.setText("Civil Work");
            holder.layout.setBackgroundResource(R.color.colorGreen);

        }
        else if (position == 9) {

            holder.imgProduct.setImageResource(R.drawable.ic_ilt_new_ipdates);
            holder.txtItemName.setText("IVR/Call Center");
            holder.layout.setBackgroundResource(R.color.colorBlue);

        }

//        else if (position == 4) {
//            holder.rvStatus.setVisibility(View.VISIBLE);
//            holder.imgProduct.setImageResource(R.drawable.ic_kya);
//            holder.txtItemName.setText("Perform KYA");
//            if (yes) {
//                holder.txtStatus.setText("Verified");
//            } else {
//                holder.imgStatus.setBackgroundTintList(context.getResources().getColorStateList(R.color.colorAccent));
//
//                holder.txtStatus.setText("Unverified");
//            }
//        }


    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView imgProduct;
        TextView txtItemName;
        RelativeLayout rvStatus;
        TextView txtStatus;
        ImageView imgStatus;
        RelativeLayout layout;


        @SuppressLint("MissingPermission")
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            layout  = itemView.findViewById(R.id.background);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            txtItemName = itemView.findViewById(R.id.txtItemName);
            rvStatus = itemView.findViewById(R.id.rvStatus);
            txtStatus = itemView.findViewById(R.id.txtStatus);
            imgStatus = itemView.findViewById(R.id.imgStatus);



            itemView.setOnClickListener(v -> {
                clickListener.onItemClickListener(getAdapterPosition());
            });
        }
    }


    public interface HomeClickListener {
        void onItemClickListener(int position);

    }





}