package com.noida.authority.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.noida.authority.R;

public class OfficerComplaintDetailsActivity extends AppCompatActivity {

    TextView title, txtDetails, txtResolve, txtProgress;
    ImageView back_arrow, start_circle4;
    View viewStatus;
    LinearLayout llUpload;

    private static final int CAMERA_REQUEST = 1888;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_officer_complaint_details);

        title = findViewById(R.id.title);
        txtDetails = findViewById(R.id.txtDetails);
        txtResolve = findViewById(R.id.txtResolve);
        viewStatus = findViewById(R.id.viewStatus);
        txtProgress = findViewById(R.id.txtProgress);
        llUpload = findViewById(R.id.llUpload);
        start_circle4 = findViewById(R.id.start_circle4);
        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        title.setText("Complaint Details");

        txtDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResolve.setVisibility(View.VISIBLE);
            }
        });
        txtResolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llUpload.setVisibility(View.VISIBLE);
                txtDetails.setVisibility(View.GONE);
            }
        });
        if (getIntent().getExtras() != null) {

            if (getIntent().hasExtra("Demand")) {

                if (getIntent().getExtras().getString("Demand").equalsIgnoreCase("Demand")) {
                    start_circle4.setImageDrawable(getResources().getDrawable(R.drawable.ic_circle_correct));
                    txtDetails.setVisibility(View.GONE);
                    viewStatus.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBlueLight)));

                }
            }
        } else {
            txtDetails.setVisibility(View.VISIBLE);
            txtProgress.setText("IN PROGRESS");
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void CallCamera(View view)
    {
        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
        }
        else
        {
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, CAMERA_REQUEST);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE)
        {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
            else
            {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            //imageView.setImageBitmap(photo);
        }
    }
}
