package com.noida.authority.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.noida.authority.R;

public class ComplaintActivity extends AppCompatActivity {

    Button btnCheckComplain, lodgeComplaint;
    TextView title;
    ImageView back_arrow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaints);

        btnCheckComplain = findViewById(R.id.btnCheckComplain);
        lodgeComplaint = findViewById(R.id.lodge_complaint);
        title = findViewById(R.id.title);
        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        title.setText("Complaints");

        btnCheckComplain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ComplaintActivity.this, ComplainStatusActivity.class);
                startActivity(i);
            }
        });


        lodgeComplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ComplaintActivity.this, LodgeNewComplaint.class);
                startActivity(i);
            }
        });


    }
}
