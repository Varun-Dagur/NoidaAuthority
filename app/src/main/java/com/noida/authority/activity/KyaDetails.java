package com.noida.authority.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.noida.authority.R;
import com.noida.authority.utils.BaseActivity;

public class KyaDetails extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kya_details);

        setToolbarTitle("KYA Details");
    }
}
