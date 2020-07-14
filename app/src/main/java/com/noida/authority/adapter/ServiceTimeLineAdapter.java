package com.noida.authority.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.noida.authority.R;
import com.noida.authority.response_model.ServiceReportResponse;
import com.noida.authority.response_model.ServiceTimeLineModel;

import java.util.ArrayList;
import java.util.List;

public class ServiceTimeLineAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{

    Context context;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    List<ServiceTimeLineModel> dataServiceReportResponseList = new ArrayList<>();
    public ServiceTimeClickListener clickListener;


    public ServiceTimeLineAdapter(Context context, List<ServiceTimeLineModel> serviceReportResponseList, ServiceTimeClickListener paramclickListener) {
        this.context = context;
        this.dataServiceReportResponseList = serviceReportResponseList;
        this.clickListener = paramclickListener;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM) {
            // Here Inflating your recyclerview item layout
            View v = LayoutInflater.from(context).inflate(R.layout.timeline_column, parent, false);
            return new MyHolder(v);
        } else if (viewType == TYPE_HEADER) {
            // Here Inflating your header view
            View itemView = LayoutInflater.from(context).inflate(R.layout.timeline_header, parent, false);
            return new HeaderViewHolder(itemView);
        }
        else return null;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder){


            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;


        }
        else if (holder instanceof MyHolder){

            final MyHolder itemViewHolder = (MyHolder) holder;

            // Following code give a row of header and decrease the one position from listview items
            final ServiceTimeLineModel data = dataServiceReportResponseList.get(position-1);

            // You have to set your listview items values with the help of model class and you can modify as per your needs


            itemViewHolder.servicename.setText(data.getServiceName());

            itemViewHolder.totalRequest.setText(String.valueOf(data.getTotal()));

            itemViewHolder.withinTime.setText(String.valueOf(data.getCompletedWithinTime()));
            itemViewHolder.BeyondTime.setText(String.valueOf(data.getCompletedBeyondTime()));
            itemViewHolder.withinTimePending.setText(String.valueOf(data.getPendingWithTime()));
            itemViewHolder.moreThanaWeek.setText(String.valueOf(data.getPendingMoreThanWeek()));
            itemViewHolder.moreThanFortNight.setText(String.valueOf(data.getPendingMoreThanFortNight()));
            itemViewHolder.moreThanMonth.setText(String.valueOf(data.getPendingMoreThanOneMonth()));
            itemViewHolder.objection.setText(String.valueOf(data.getTotalObjection()));
            itemViewHolder.averageProcessingTime.setText(String.valueOf(data.getAverageProcessingTime()));
            itemViewHolder.averageDelayTime.setText(String.valueOf(data.getAverageDelaytime()));

        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }



    @Override
    public int getItemCount() {
        return dataServiceReportResponseList.size()+1;
    }

    @Override
    public void onClick(View view) {

    }

    private class HeaderViewHolder extends RecyclerView.ViewHolder {
        Button exportToExcel;


        public HeaderViewHolder(View view) {
            super(view);
            exportToExcel = view.findViewById(R.id.exportExcel);

        }
    }


    public class MyHolder extends RecyclerView.ViewHolder {

        TextView servicename, totalRequest, withinTime, BeyondTime, withinTimePending, moreThanaWeek,
                moreThanFortNight, moreThanMonth, objection,averageProcessingTime, averageDelayTime;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            servicename = itemView.findViewById(R.id.service_name);
            totalRequest = itemView.findViewById(R.id.total_request);
            totalRequest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   // Toast.makeText(context, "ITEM PRESSED = " + String.valueOf(getAdapterPosition())+" ITEM TAG :"+String.valueOf(view.getTag()), Toast.LENGTH_SHORT).show();

                    clickListener.onItemClickListener(getAdapterPosition(), String.valueOf(view.getTag()));
                }
            });


            withinTime = itemView.findViewById(R.id.within_time);
            withinTime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Toast.makeText(context, "ITEM PRESSED = " + String.valueOf(getAdapterPosition())+" ITEM TAG :"+String.valueOf(view.getTag()), Toast.LENGTH_SHORT).show();

                    clickListener.onItemClickListener(getAdapterPosition(), String.valueOf(view.getTag()));
                }
            });
            BeyondTime = itemView.findViewById(R.id.beyond_time);
            withinTime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Toast.makeText(context, "ITEM PRESSED = " + String.valueOf(getAdapterPosition())+" ITEM TAG :"+String.valueOf(view.getTag()), Toast.LENGTH_SHORT).show();

                    clickListener.onItemClickListener(getAdapterPosition(), String.valueOf(view.getTag()));
                }
            });

            withinTimePending = itemView.findViewById(R.id.within_time_pending);
            withinTimePending.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Toast.makeText(context, "ITEM PRESSED = " + String.valueOf(getAdapterPosition())+" ITEM TAG :"+String.valueOf(view.getTag()), Toast.LENGTH_SHORT).show();

                    clickListener.onItemClickListener(getAdapterPosition(), String.valueOf(view.getTag()));
                }
            });
            moreThanaWeek = itemView.findViewById(R.id.more_than_weak);
            moreThanaWeek.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Toast.makeText(context, "ITEM PRESSED = " + String.valueOf(getAdapterPosition())+" ITEM TAG :"+String.valueOf(view.getTag()), Toast.LENGTH_SHORT).show();

                    clickListener.onItemClickListener(getAdapterPosition(), String.valueOf(view.getTag()));
                }
            });
            moreThanFortNight = itemView.findViewById(R.id.more_than_fortnight);
            moreThanFortNight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Toast.makeText(context, "ITEM PRESSED = " + String.valueOf(getAdapterPosition())+" ITEM TAG :"+String.valueOf(view.getTag()), Toast.LENGTH_SHORT).show();

                    clickListener.onItemClickListener(getAdapterPosition(), String.valueOf(view.getTag()));
                }
            });
            moreThanMonth = itemView.findViewById(R.id.more_than_a_month);
            moreThanMonth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Toast.makeText(context, "ITEM PRESSED = " + String.valueOf(getAdapterPosition())+" ITEM TAG :"+String.valueOf(view.getTag()), Toast.LENGTH_SHORT).show();

                    clickListener.onItemClickListener(getAdapterPosition(), String.valueOf(view.getTag()));
                }
            });

            objection = itemView.findViewById(R.id.objection);
            objection.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Toast.makeText(context, "ITEM PRESSED = " + String.valueOf(getAdapterPosition())+" ITEM TAG :"+String.valueOf(view.getTag()), Toast.LENGTH_SHORT).show();

                    clickListener.onItemClickListener(getAdapterPosition(), String.valueOf(view.getTag()));
                }
            });
            averageProcessingTime = itemView.findViewById(R.id.average_processing_time);
            averageDelayTime = itemView.findViewById(R.id.average_delay_time);

        }

    }

    public interface ServiceTimeClickListener {

        void onItemClickListener(int position, String tag);


    }

}
