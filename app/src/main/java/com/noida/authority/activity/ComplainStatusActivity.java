package com.noida.authority.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.noida.authority.R;
import com.noida.authority.adapter.ComplainAdapter;

public class ComplainStatusActivity extends AppCompatActivity {
    RecyclerView rvComplainStatusList;
    ComplainAdapter complainAdapter;
    TextView title;
    ImageView back_arrow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain_status);
        rvComplainStatusList  = findViewById(R.id.rvComplainStatusList);

        rvComplainStatusList.setLayoutManager(new LinearLayoutManager(this));
        complainAdapter = new ComplainAdapter(this);
        rvComplainStatusList.setAdapter(complainAdapter);

        title = findViewById(R.id.title);
        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        title.setText("Complaint Status");
    }
}
