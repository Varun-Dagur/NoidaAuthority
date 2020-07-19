package com.noida.authority.mernretrofit;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.noida.authority.response_model.ComplaintResponse;
import com.noida.authority.response_model.DepartmentResponse;
import com.noida.authority.response_model.LoginResponse;
import com.noida.authority.response_model.ServiceResponse;
import com.noida.authority.retrofit.ApiClient;
import com.noida.authority.retrofit.ApiInterface;
import com.noida.authority.retrofit.ApiResponseInterface;
import com.noida.authority.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

public class MernApiManager {

    private Context mContext;
    private ProgressDialog dialog;
    private MernApiResponseInterface mApiResponseInterface;
    MernApiInterface apiService;

    public MernApiManager(Context context, MernApiResponseInterface apiResponseInterface) {
        this.mContext = context;
        this.mApiResponseInterface = apiResponseInterface;
        apiService = MernApiClient.getClient().create(MernApiInterface.class);
        dialog = new ProgressDialog(mContext);
    }

    public void getDepartments() {
        showDialog();
        MernApiInterface apiService = MernApiClient.getClient().create(MernApiInterface.class);
        Call<List<DepartmentResponse>> call = apiService.getDepartments();
        call.enqueue(new Callback<List<DepartmentResponse>>() {
            @Override
            public void onResponse(Call<List<DepartmentResponse>> call, Response<List<DepartmentResponse>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    mApiResponseInterface.isServerSuccess(response.body(), Constants.GET_DEPARTMENT);
                } else {

                    //   mApiResponseInterface.isError(response.body().getError());
                }
                closeDialog();
            }

            @Override
            public void onFailure(Call<List<DepartmentResponse>> call, Throwable t) {
                closeDialog();

                Toast.makeText(mContext, "Network Error", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getServices(int departmentId) {
        showDialog();
        MernApiInterface apiService = MernApiClient.getClient().create(MernApiInterface.class);
        Call<List<ServiceResponse>> call = apiService.getServices(departmentId);
        call.enqueue(new Callback<List<ServiceResponse>>() {
            @Override
            public void onResponse(Call<List<ServiceResponse>> call, Response<List<ServiceResponse>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    mApiResponseInterface.isServerSuccess(response.body(), Constants.GET_SERVICE);
                } else {

                    //   mApiResponseInterface.isError(response.body().getError());
                }
                closeDialog();
            }

            @Override
            public void onFailure(Call<List<ServiceResponse>> call, Throwable t) {
                closeDialog();

                Toast.makeText(mContext, "Network Error", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getComplaints(int mobile) {
        showDialog();
        MernApiInterface apiService = MernApiClient.getClient().create(MernApiInterface.class);
        Call<List<ComplaintResponse>> call = apiService.getComplaints(mobile);
        call.enqueue(new Callback<List<ComplaintResponse>>() {
            @Override
            public void onResponse(Call<List<ComplaintResponse>> call, Response<List<ComplaintResponse>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    mApiResponseInterface.isServerSuccess(response.body(), Constants.GET_SERVICE);
                } else {

                    //   mApiResponseInterface.isError(response.body().getError());
                }
                closeDialog();
            }

            @Override
            public void onFailure(Call<List<ComplaintResponse>> call, Throwable t) {
                closeDialog();

                Toast.makeText(mContext, "Network Error", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void registerComplaint( int departmentId,  int serviceid,
                                   String subject,  String complaint,
                                   String requestLocation,  String name,
                                   String mobile,  String email,
                                   String comAddress,  String idProof,
                                   String sector, String block,
                                   String village,  String plotNo,
                                   String address) {
        showDialog();
        MernApiInterface apiService = MernApiClient.getClient().create(MernApiInterface.class);
        Call<String> call = apiService.registerComplaint(departmentId, serviceid, subject, complaint,
                 requestLocation, name, mobile, email, comAddress, idProof, sector, block, village, plotNo, address);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                Log.d("Response: ",response.errorBody().toString());

                if (response.isSuccessful() && response.body() != null) {

                    mApiResponseInterface.isServerSuccess(response.body(), Constants.REGISTER_COMPLAINT);

                } else {

                    //   mApiResponseInterface.isError(response.body().getError());
                }
                closeDialog();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                closeDialog();

                Log.d("Error :",t.getMessage());
                Toast.makeText(mContext, "Network Error", Toast.LENGTH_LONG).show();
            }
        });
    }








    private void showDialog() {
        dialog.setMessage("Please wait...");
        dialog.show();
    }

    private void closeDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

}
