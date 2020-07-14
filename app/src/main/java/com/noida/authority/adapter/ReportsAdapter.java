package com.noida.authority.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.noida.authority.R;
import com.noida.authority.response_model.ServiceReportResponse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ReportsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    Context context;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    List<ServiceReportResponse> dataServiceReportResponseList = new ArrayList<>();
    int viewType;

    public ReportsAdapter(Context context, List<ServiceReportResponse> serviceReportResponseList, int type) {
        this.context = context;
        this.dataServiceReportResponseList = serviceReportResponseList;
        this.viewType = type;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM) {
            // Here Inflating your recyclerview item layout
            View v = LayoutInflater.from(context).inflate(R.layout.complain_column, parent, false);
            return new ReportsAdapter.MyHolder(v);
        } else if (viewType == TYPE_HEADER) {
            // Here Inflating your header view
            View itemView = LayoutInflater.from(context).inflate(R.layout.complain_header, parent, false);
            return new ReportsAdapter.HeaderViewHolder(itemView);
        }
        else return null;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder){


            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            if(viewType == 0) {
                headerViewHolder.exportToExcel.setVisibility(View.GONE);
            }

        }
        else if (holder instanceof MyHolder){

            final MyHolder itemViewHolder = (MyHolder) holder;

            // Following code give a row of header and decrease the one position from listview items
            final ServiceReportResponse data = dataServiceReportResponseList.get(position-1);

            // You have to set your listview items values with the help of model class and you can modify as per your needs

            itemViewHolder.department.setText(data.getDepartment());
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

    private class HeaderViewHolder extends RecyclerView.ViewHolder {
        Button exportToExcel;


        public HeaderViewHolder(View view) {
            super(view);
            exportToExcel = view.findViewById(R.id.exportExcel);

        }
    }


    public class MyHolder extends RecyclerView.ViewHolder {

        TextView department, totalRequest, withinTime, BeyondTime, withinTimePending, moreThanaWeek,
                moreThanFortNight, moreThanMonth, objection,averageProcessingTime, averageDelayTime;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            department = itemView.findViewById(R.id.department);
            totalRequest = itemView.findViewById(R.id.total_request);
            withinTime = itemView.findViewById(R.id.within_time);
            BeyondTime = itemView.findViewById(R.id.beyond_time);

            withinTimePending = itemView.findViewById(R.id.within_time_pending);
            moreThanaWeek = itemView.findViewById(R.id.more_than_weak);
            moreThanFortNight = itemView.findViewById(R.id.more_than_fortnight);
            moreThanMonth = itemView.findViewById(R.id.more_than_a_month);

            objection = itemView.findViewById(R.id.objection);
            averageProcessingTime = itemView.findViewById(R.id.average_processing_time);
            averageDelayTime = itemView.findViewById(R.id.average_delay_time);

        }

    }




}
