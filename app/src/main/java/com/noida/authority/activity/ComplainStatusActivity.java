package com.noida.authority.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.noida.authority.R;
import com.noida.authority.adapter.ComplainAdapter;
import com.noida.authority.mernretrofit.MernApiManager;
import com.noida.authority.mernretrofit.MernApiResponseInterface;
import com.noida.authority.response_model.ComplaintResponse;

import java.util.List;

public class ComplainStatusActivity extends AppCompatActivity implements MernApiResponseInterface {
    RecyclerView rvComplainStatusList;
    ComplainAdapter complainAdapter;
    TextView title;
    ImageView back_arrow;

    MernApiManager mernApiManager;
    List<ComplaintResponse> complaintResponseList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain_status);
        rvComplainStatusList  = findViewById(R.id.rvComplainStatusList);

        rvComplainStatusList.setLayoutManager(new LinearLayoutManager(this));


        title = findViewById(R.id.title);
        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        title.setText("Complaint Status");

        mernApiManager = new MernApiManager(this, this);
        mernApiManager.getComplaints(9634);


    }


    @Override
    public void isServerError(String errorCode) {

    }

    @Override
    public void isServerSuccess(Object response, int ServiceCode) {
        complaintResponseList = (List<ComplaintResponse>)response;
        complainAdapter = new ComplainAdapter(this, complaintResponseList);
        rvComplainStatusList.setAdapter(complainAdapter);

    }
}
