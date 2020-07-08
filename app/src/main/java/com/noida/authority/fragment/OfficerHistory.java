package com.noida.authority.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.noida.authority.R;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.noida.authority.adapter.HistoryAdapter;


public class OfficerHistory extends Fragment {
    RecyclerView rvComplainStatusList;
    HistoryAdapter complainAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_officer_history, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {

        rvComplainStatusList = v.findViewById(R.id.rvComplainStatusList);
        rvComplainStatusList.setLayoutManager(new LinearLayoutManager(getActivity()));
        complainAdapter = new HistoryAdapter(getActivity());
        rvComplainStatusList.setAdapter(complainAdapter);

    }

}