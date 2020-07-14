package com.noida.authority.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.noida.authority.R;
import com.noida.authority.adapter.ReportsAdapter;
import com.noida.authority.adapter.TimeLineReportAdapter;
import com.noida.authority.response_model.ServiceReportResponse;
import com.noida.authority.response_model.TimeLineResponse;
import com.noida.authority.retrofit.ApiManager;
import com.noida.authority.retrofit.ApiResponseInterface;

import java.util.ArrayList;
import java.util.List;

public class TimeLineReportActivity extends AppCompatActivity implements ApiResponseInterface {

    TextView title;
    ImageView back_arrow;

    ApiManager apiManager;
    RecyclerView timeLineRecyclerView;
    List<TimeLineResponse> timeLineReportResponseList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line_report);

        title = findViewById(R.id.title);
        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        title.setText("TIMELINE OF SERVICES (ONLINE)");
        apiManager = new ApiManager(this, this);

        timeLineRecyclerView = findViewById(R.id.TimeLineReportGrid);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return true;
            }
        };

        timeLineRecyclerView.setLayoutManager(linearLayoutManager);
        timeLineReportResponseList = new ArrayList<>();

        apiManager.getTimeLineResponse(getIntent().getStringExtra("deptID"),
                getIntent().getStringExtra("StartDate"),
                getIntent().getStringExtra("EndDate"),
                getIntent().getStringExtra("type"),
                getIntent().getStringExtra("requestthrough"),
                "ServiceDetails",
                getIntent().getStringExtra("serviceid"));

    }


    @Override
    public void isError(String errorCode) {
        Toast.makeText(this, "Network Error", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void isSuccess(Object response, int ServiceCode) {

        timeLineReportResponseList = (List<TimeLineResponse>) response;
        TimeLineReportAdapter reportsAdapter = new TimeLineReportAdapter(this, timeLineReportResponseList, new TimeLineReportAdapter.ServiceTimeLineClickListener() {
            @Override
            public void onItemClickListener(int position, String tag) {

            }
        });
        timeLineRecyclerView.setAdapter(reportsAdapter);

    }
}
