package com.noida.authority.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.noida.authority.R;
import com.noida.authority.activity.ComplaintDetailsActivity;
import com.noida.authority.activity.LodgeNewComplaint;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.MyHolder> {

    Context context;private
    static final String[] DeptITEMS = {"Horticulture", "Sports", "Electrical", "Civil Engineering", "Land Management"};


    public DepartmentAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public DepartmentAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.adapter_dept_item, parent, false);

        return new DepartmentAdapter.MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentAdapter.MyHolder holder, int position) {
        holder.txtDetails.setText(DeptITEMS[position]);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyHolder extends RecyclerView.ViewHolder {


        TextView txtDetails;

        public MyHolder(@NonNull View itemView) {
            super(itemView);


            txtDetails = itemView.findViewById(R.id.txtItemName);
            itemView.setOnClickListener(v -> {
                Intent i = new Intent(context, LodgeNewComplaint.class);
                context.startActivity(i);

        });


//            txtDetails.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Intent i = new Intent(context, LodgeNewComplaint.class);
//                    context.startActivity(i);
//                  /*  if (getAdapterPosition() == 1) {
//
//                        Intent i = new Intent(context, ComplaintActivity.class);
//                        context.startActivity(i);
//                    } else if (getAdapterPosition() == 2) {
//
//                        Intent i = new Intent(context, GeneralInformationActivity.class);
//                        context.startActivity(i);
//
//                    } else if (getAdapterPosition() == 3) {
//
//
//                    }*/
//
//                }
//            });
        }
    }
}
