package com.noida.authority.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.noida.authority.R;
import com.noida.authority.activity.ComplaintActivity;
import com.noida.authority.activity.GeneralInstruction;
import com.noida.authority.activity.WebVersion;
import com.noida.authority.activity.ui.home.CallCenter;
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
    private static final int CALL_PERMISSION_CODE = 100;


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

        homeAdapter = new HomeAdapter(getActivity(), new HomeAdapter.HomeClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onItemClickListener(int position) {
                if (position == 0) {

                    Intent i = new Intent(getActivity(), WebVersion.class);
                    i.putExtra("Url","http://suggestion.mynoida.in/Account/Login");
                    getActivity().startActivity(i);

                } else if (position == 1) {
                    Intent i = new Intent(getActivity(), ComplaintActivity.class);
                    getActivity().startActivity(i);
                } else if (position == 2) {

                    Toast.makeText(getActivity(), "Work in progress", Toast.LENGTH_LONG).show();
                   /* Intent i = new Intent(context, GeneralInstruction.class);
                    context.startActivity(i);*/

                } else if (position == 3) {


                    Intent i = new Intent(getActivity(), GeneralInstruction.class);
                    getActivity().startActivity(i);


                } else if (position == 4) {

                    Toast.makeText(getActivity(), "Work in progress", Toast.LENGTH_LONG).show();

                } else if (position == 5) {

                    Toast.makeText(getActivity(), "Work in progress", Toast.LENGTH_LONG).show();
                }
                else if (position == 6) {

                    Intent i = new Intent(getActivity(), WebVersion.class);
                    i.putExtra("Url","https://www.noidaauthorityonline.in");
                    getActivity().startActivity(i);

                }
                else if (position == 7) {

                    Toast.makeText(getActivity(), "Work in progress", Toast.LENGTH_LONG).show();

                }
                else if (position == 8) {
                    Intent i = new Intent(getActivity(), WebVersion.class);
                    i.putExtra("Url","https://pims.mynoida.in/Account/Login/");
                    getActivity().startActivity(i);

                   // Toast.makeText(getActivity(), "Work in progress", Toast.LENGTH_LONG).show();
                }

                else if (position == 9) {

//                    if (getActivity().checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
//                    {
//                        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, CALL_PERMISSION_CODE);
//                    }
//                    else
//                    {
//                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "01202425025"));
//                        getActivity().startActivity(intent);
//                    }


                    Intent intent = new Intent(getActivity(), CallCenter.class);
                    startActivity(intent);


                }

            }
        });
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



    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CALL_PERMISSION_CODE)
        {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {

                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "01202425025"));
                getActivity().startActivity(intent);

            }
            else
            {
                Toast.makeText(getActivity(), "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }






}
