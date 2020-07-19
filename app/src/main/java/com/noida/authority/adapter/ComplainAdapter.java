package com.noida.authority.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.noida.authority.R;
import com.noida.authority.activity.ComplaintDetailsActivity;
import com.noida.authority.response_model.ComplaintResponse;

import java.util.List;

public class ComplainAdapter extends RecyclerView.Adapter<ComplainAdapter.MyHolder> {
    Context context;

    List<ComplaintResponse> complaintResponseList;

    public ComplainAdapter(Context context, List<ComplaintResponse> paramComplaintResponseList) {
        this.context = context;
        this.complaintResponseList = paramComplaintResponseList;
    }

    @NonNull
    @Override
    public ComplainAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.complain_status_row, parent, false);
        return new ComplainAdapter.MyHolder(v);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull ComplainAdapter.MyHolder holder, int position) {

        ComplaintResponse complaintResponse = complaintResponseList.get(position);
        holder.complainantName.setText(complaintResponse.getName());
        holder.deptName.setText(complaintResponse.getDepartment());
        holder.serviceName.setText(complaintResponse.getService());
        //holder.complainantName.setText(complaintResponse.getName());

       /* if (position == 1) {
            holder.imgProduct.setImageDrawable(context.getDrawable(R.drawable.ic_complaint));
            holder.txtItemName.setText("Complaint");
        } else if (position == 2) {
            holder.imgProduct.setImageDrawable(context.getDrawable(R.drawable.ic_information));
            holder.txtItemName.setText("Information");

        } else if (position == 3) {
            holder.imgProduct.setImageDrawable(context.getDrawable(R.drawable.ic_kya));
            holder.txtItemName.setText("Know your allottee");

        }*/
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class MyHolder extends RecyclerView.ViewHolder {


        TextView txtDetails, deptName, serviceName, complainantName;

        public MyHolder(@NonNull View itemView) {
            super(itemView);


            txtDetails = itemView.findViewById(R.id.txtDetails);
            deptName = itemView.findViewById(R.id.dept_name);
            serviceName = itemView.findViewById(R.id.service_name);
            complainantName = itemView.findViewById(R.id.ComplainantName);

            txtDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  /*  if (getAdapterPosition() == 1) {

                        Intent i = new Intent(context, ComplaintActivity.class);
                        context.startActivity(i);
                    } else if (getAdapterPosition() == 2) {

                        Intent i = new Intent(context, GeneralInformationActivity.class);
                        context.startActivity(i);

                    } else if (getAdapterPosition() == 3) {


                    }*/
                    Intent intent = new Intent(context, ComplaintDetailsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("data", complaintResponseList.get(getAdapterPosition()));
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
        }
    }
}

