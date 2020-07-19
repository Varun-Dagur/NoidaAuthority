package com.noida.authority.activity.ui.home;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.noida.authority.R;

public class CallCenter extends AppCompatActivity {

    TextView title;
    ImageView back_arrow;

    private static final int CALL_FIRST_PERMISSION_CODE = 201;
    private static final int CALL_SECOND_PERMISSION_CODE = 202;
    private static final int CALL_THIRD_PERMISSION_CODE = 203;
    private static final int SMS_PERMISSION_CODE = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_center);

        title = findViewById(R.id.title);
        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        title.setText("Call Center");

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void CallCenter(View view)
    {
        if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        {

            int tag = Integer. parseInt(String.valueOf(view.getTag()));
            if(tag==1) {
                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, CALL_FIRST_PERMISSION_CODE);
            }
            if(tag==2) {
                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, CALL_SECOND_PERMISSION_CODE);
            }
            if(tag==3) {
                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, CALL_THIRD_PERMISSION_CODE);
            }
        }
        else
        {
            int tag = (int) view.getTag();
            if(tag==1) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "01202425025"));
                startActivity(intent);
            }
            if(tag==2) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "01202425026"));
                startActivity(intent);
            }
            if(tag==3) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "01202425027"));
                startActivity(intent);
            }
        }
    }






    @RequiresApi(api = Build.VERSION_CODES.M)
    public void callSMS(View view)
    {
        if (checkSelfPermission(Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[]{Manifest.permission.SEND_SMS}, SMS_PERMISSION_CODE);
        }
        else
            {
                CallMessage();
            }
    }


    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == CALL_FIRST_PERMISSION_CODE)
        {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "01202425025"));
                startActivity(intent);
            }
            else
            {
                Toast.makeText(CallCenter.this, "Call Permission Denied", Toast.LENGTH_LONG).show();
            }
        }
        if (requestCode == CALL_SECOND_PERMISSION_CODE)
        {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "01202425026"));
                startActivity(intent);
            }
            else
            {
                Toast.makeText(CallCenter.this, "Call Permission Denied", Toast.LENGTH_LONG).show();
            }
        }
        if (requestCode == CALL_THIRD_PERMISSION_CODE)
        {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "01202425027"));
                startActivity(intent);
            }
            else
            {
                Toast.makeText(CallCenter.this, "Call Permission Denied", Toast.LENGTH_LONG).show();
            }
        }




        if (requestCode == SMS_PERMISSION_CODE)
        {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                CallMessage();
            }
            else
            {
                Toast.makeText(CallCenter.this, "SMS Permission Denied", Toast.LENGTH_LONG).show();
            }
        }
    }



    public void CallMessage()
    {
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
        smsIntent.setData(Uri.parse("smsto: 9205559204"));
        smsIntent.putExtra("sms_body", "");
        if (smsIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(smsIntent);
        } else {
            Log.e("TAG", "Can't resolve app for ACTION_SENDTO Intent");
        }
    }









}
