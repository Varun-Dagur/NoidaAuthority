package com.noida.authority.activity.complaintview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.noida.authority.R;
import com.tiper.MaterialSpinner;


public class ComplaintBasic extends AppCompatActivity {


    private static final String[] ITEMS = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6"};

    private ArrayAdapter<String> adapter;

    MaterialSpinner spinner1, spinner2;

    TextView title;
    ImageView back_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_basic);

        title = findViewById(R.id.title);
        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        title.setText("Register A Complaint");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1 = findViewById(R.id.department_spinner);
        spinner1.setAdapter(adapter);

        spinner2 = findViewById(R.id.ComplaintType_spinner);
        spinner2.setAdapter(adapter);


    }


}
