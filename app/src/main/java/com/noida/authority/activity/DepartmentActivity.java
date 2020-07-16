package com.noida.authority.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.noida.authority.R;
import com.noida.authority.adapter.DepartmentAdapter;
import com.noida.authority.adapter.HomeAdapter;

public class DepartmentActivity extends AppCompatActivity {
    TextView title;
    ImageView back_arrow;
    RecyclerView departmentView;
    DepartmentAdapter deptAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);


        title = findViewById(R.id.title);
        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        title.setText("Choose Department");

        departmentView = findViewById(R.id.DepartmentGrid);
        departmentView.setLayoutManager(new GridLayoutManager(DepartmentActivity.this, 2, LinearLayoutManager.VERTICAL, false));

        deptAdapter = new DepartmentAdapter(DepartmentActivity.this);
        departmentView.setAdapter(deptAdapter);




    }
}
