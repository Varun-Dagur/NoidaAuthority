package com.noida.authority.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.noida.authority.R;
import com.noida.authority.adapter.HomeAdapter;
import com.noida.authority.body_model.TokenResponse;
import com.noida.authority.retrofit.ApiManager;
import com.noida.authority.retrofit.ApiResponseInterface;
import com.noida.authority.utils.Constants;
import com.noida.authority.utils.SessionManager;

public class Home extends Fragment implements ApiResponseInterface {
    HomeAdapter homeAdapter;
    RecyclerView rvList;
    SessionManager sessionManager;
    String user = "";
    String userPassword = "";
    String typeword = "";
    ApiManager apiManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment, container, false);
        sessionManager = new SessionManager(getActivity());
        user = sessionManager.getUserName();
        userPassword = sessionManager.getUserPassword();
        typeword = sessionManager.getTYPE_Password();

        initViews(v);
        apiManager = new ApiManager(getContext(), this);
        if (user != null) {
            apiManager.requestToken(user, userPassword, typeword);

        }

        return v;
    }

    private void initViews(View v) {
        rvList = v.findViewById(R.id.rvList);
        rvList.setLayoutManager(new GridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false));

        homeAdapter = new HomeAdapter(getActivity());
        rvList.setAdapter(homeAdapter);


    }

    @Override
    public void isError(String errorCode) {

    }

    @Override
    public void isSuccess(Object response, int ServiceCode) {
        if (ServiceCode == Constants.Token_REQUEST) {

            TokenResponse tokenBean = (TokenResponse) response;
            String token = tokenBean.getAccess_token();
            sessionManager.saveToke("Bearer " + token);
            checkKya();


        } else if (ServiceCode == Constants.IS_KYA) {
            boolean b = (boolean) response;

            if (!b) {
                sessionManager.saveKyaStatus(b);
                //  callDialog();
            } else {
                sessionManager.saveKyaStatus(b);
                Toast.makeText(getContext(), "KYA Already Completed", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void checkKya() {
        apiManager.getKyaDetails("Bearer " + new SessionManager(getContext()).getUserToken(), /*"9811206110"*/user);
    }
}
