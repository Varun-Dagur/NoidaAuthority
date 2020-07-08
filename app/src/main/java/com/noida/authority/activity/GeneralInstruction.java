package com.noida.authority.activity;

import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.noida.authority.R;
import com.noida.authority.fragment.Individual;
import com.noida.authority.fragment.Organisation;

public class GeneralInstruction extends AppCompatActivity implements View.OnClickListener {
    FrameLayout mainFrame;
    Fragment fragment = null;
    ImageView back_arrow;

    TextView txtLeftHeader, title, txtOrganisation, txtIndividual;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);

        initViews();

    }

    private void initViews() {

        back_arrow = findViewById(R.id.back_arrow);
        txtOrganisation = findViewById(R.id.txtOrganisation);
        txtIndividual = findViewById(R.id.txtIndividual);
        title = findViewById(R.id.title);

        back_arrow.setVisibility(View.VISIBLE);
        back_arrow.setOnClickListener(this);
        txtIndividual.setOnClickListener(this);
        txtOrganisation.setOnClickListener(this);
        title.setText(getResources().getString(R.string.general));

        mainFrame = findViewById(R.id.mainFrame);
        fragment = new Individual();
        loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainFrame, fragment)
                    .commit();
            return true;
        }
        return false;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_arrow:
                onBackPressed();
                break;
            case R.id.txtOrganisation:

                txtOrganisation.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                txtOrganisation.setTextColor(getResources().getColor(R.color.colorBlack));

                txtIndividual.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBlackLight)));
                txtIndividual.setTextColor(getResources().getColor(R.color.colorWhite));


                fragment = new Organisation();
                loadFragment(fragment);
                break;

            case R.id.txtIndividual:

                txtIndividual.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                txtIndividual.setTextColor(getResources().getColor(R.color.colorBlack));

                txtOrganisation.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBlackLight)));
                txtOrganisation.setTextColor(getResources().getColor(R.color.colorWhite));


                fragment = new Individual();
                loadFragment(fragment);
                break;
        }
    }
}