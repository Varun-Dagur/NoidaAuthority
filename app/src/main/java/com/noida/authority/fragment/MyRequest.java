package com.noida.authority.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.noida.authority.R;
import com.noida.authority.adapter.ComplainAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyRequest extends Fragment {

    RecyclerView rvComplainStatusList;
    ComplainAdapter complainAdapter;

    public MyRequest() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_request, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvComplainStatusList = view.findViewById(R.id.rvComplainStatusList);
        rvComplainStatusList.setLayoutManager(new LinearLayoutManager(getContext()));
        complainAdapter = new ComplainAdapter(getContext());
        rvComplainStatusList.setAdapter(complainAdapter);


    }
}
