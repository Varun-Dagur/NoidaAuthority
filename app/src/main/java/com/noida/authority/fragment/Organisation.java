package com.noida.authority.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.noida.authority.R;
import com.noida.authority.activity.KyaAllotteeInfo;
import com.noida.authority.activity.SearchActivity;

public class Organisation extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //View v=  DataBindingUtil.inflate(inflater, container, false);

        View v = inflater.inflate(R.layout.activity_genral_organisation, container, false);

        Button btnNext = v.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });

        //initViews(v);
        return v;
    }

/*
    private void initViews(View v) {
        imgBackArrow = v.findViewById(R.id.imgBackArrow);
        logout = v.findViewById(R.id.logout);
        txtLeftHeader = v.findViewById(R.id.txtLeftHeader);
        txtHeaderName = v.findViewById(R.id.txtHeaderName);
        txtLeftHeader.setVisibility(View.GONE);
        logout.setVisibility(View.GONE);
        imgBackArrow.setVisibility(View.VISIBLE);
        txtHeaderName.setText(getResources().getString(R.string.general));
    }
*/
}
