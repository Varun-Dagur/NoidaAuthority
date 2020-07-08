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
import com.noida.authority.adapter.NotificationAdapter;

public class NotificationActivity extends AppCompatActivity {
    TextView title;
    ImageView back_arrow;
    NotificationAdapter notificationAdapter;
    RecyclerView rvNotificationList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_notification);

        rvNotificationList = findViewById(R.id.rvNotificationList);
        rvNotificationList.setLayoutManager(new LinearLayoutManager(this));
        title = findViewById(R.id.title);
        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        title.setText("Notifications");
        notificationAdapter = new NotificationAdapter(this);
        rvNotificationList.setAdapter(notificationAdapter);
    }
}
