package com.noida.authority.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.noida.authority.R;
import com.noida.authority.adapter.ComplainAdapter;
import com.noida.authority.adapter.OfficerComplainAdapter;

public class OfficerRequestActivity extends AppCompatActivity {
    TextView title;
    ImageView back_arrow;

    RecyclerView rvComplainStatusList;
    OfficerComplainAdapter complainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_officer_request);

        title = findViewById(R.id.title);
        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        title.setText("Complaints");


        rvComplainStatusList = findViewById(R.id.rvComplainStatusList);
        rvComplainStatusList.setLayoutManager(new LinearLayoutManager(this));
        complainAdapter = new OfficerComplainAdapter(this);
        rvComplainStatusList.setAdapter(complainAdapter);


    }
}
