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

public class Individual extends Fragment {


    Button btnNext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //View v=  DataBindingUtil.inflate(inflater, container, false);

        View v = inflater.inflate(R.layout.general_instructions_fragment, container, false);


        initViews(v);
        return v;
    }


    private void initViews(View v) {

      btnNext=  v.findViewById(R.id.btnNext);
      btnNext.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(getActivity(), SearchActivity.class);
              startActivity(intent);
          }
      });

    }

}