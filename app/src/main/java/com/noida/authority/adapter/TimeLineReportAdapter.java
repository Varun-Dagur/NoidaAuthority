package com.noida.authority.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.noida.authority.R;
import com.noida.authority.response_model.TimeLineResponse;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimeLineReportAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    List<TimeLineResponse> dataServiceReportResponseList = new ArrayList<>();
    public ServiceTimeLineClickListener clickListener;


    public TimeLineReportAdapter(Context context, List<TimeLineResponse> serviceReportResponseList, ServiceTimeLineClickListener paramclickListener) {
        this.context = context;
        this.dataServiceReportResponseList = serviceReportResponseList;
        this.clickListener = paramclickListener;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM) {
            // Here Inflating your recyclerview item layout
            View v = LayoutInflater.from(context).inflate(R.layout.detailed_timeline_column, parent, false);
            return new MyHolder(v);
        } else if (viewType == TYPE_HEADER) {
            // Here Inflating your header view
            View itemView = LayoutInflater.from(context).inflate(R.layout.detailed_timeline_header, parent, false);
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
            final TimeLineResponse data = dataServiceReportResponseList.get(position-1);

            // You have to set your listview items values with the help of model class and you can modify as per your needs

            itemViewHolder.referenceNo.setText(String.valueOf(data.getRequestId()));
            itemViewHolder.registrationId.setText(String.valueOf(data.getRegistrationNo()));
            itemViewHolder.propertyNo.setText(String.valueOf(data.getPropertyNo()));
            itemViewHolder.applicantName.setText(String.valueOf(data.getApplicant()));
            try {
                itemViewHolder.requestDate.setText(convertDateFormat(data.getRequestDate().substring(0,9)));
                itemViewHolder.forwardedDate.setText(convertDateFormat(data.getRequestDate().substring(0,9)));
                itemViewHolder.approvalDate.setText(convertDateFormat(data.getValidationDate().substring(0,9)));
            } catch (ParseException e) {

                e.printStackTrace();
            }
            itemViewHolder.status.setText(String.valueOf(data.getStatus()));
            itemViewHolder.forwardedTo.setText(String.valueOf(data.getApprover()));



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

        TextView referenceNo, registrationId, propertyNo, applicantName, requestDate, status,
                forwardedTo, forwardedDate, approvalDate;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            referenceNo = itemView.findViewById(R.id.reference_no);
            registrationId = itemView.findViewById(R.id.registration_id);
            propertyNo = itemView.findViewById(R.id.property_no);
            applicantName = itemView.findViewById(R.id.applicant_name);
            requestDate = itemView.findViewById(R.id.request_date);
            status = itemView.findViewById(R.id.status);
            forwardedTo = itemView.findViewById(R.id.forwardedto);
            forwardedDate = itemView.findViewById(R.id.forwardeddate);
            approvalDate = itemView.findViewById(R.id.approvaldate);

        }

    }

    public interface ServiceTimeLineClickListener {

        void onItemClickListener(int position, String tag);


    }

    public String convertDateFormat(String inputDate) throws ParseException {
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy");
        //String inputDateStr="2013-06-24";
        Date date = inputFormat.parse(inputDate);
        String outputDateStr = outputFormat.format(date);

        return outputDateStr;
    }

}
