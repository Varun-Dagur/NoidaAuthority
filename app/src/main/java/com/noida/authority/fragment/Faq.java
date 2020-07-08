package com.noida.authority.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.noida.authority.R;

public class Faq extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //View v=  DataBindingUtil.inflate(inflater, container, false);

        View v = inflater.inflate(R.layout.acitivity_faq, container, false);


        initViews(v);
        return v;
    }


    private void initViews(View v) {

    }
}
