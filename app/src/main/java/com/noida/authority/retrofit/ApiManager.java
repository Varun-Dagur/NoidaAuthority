package com.noida.authority.retrofit;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.noida.authority.body_model.PropertyResponse;
import com.noida.authority.body_model.TokenResponse;
import com.noida.authority.response_model.BlockResponse;
import com.noida.authority.response_model.LoginResponse;
import com.noida.authority.response_model.RetrofitErrorResponse;
import com.noida.authority.response_model.SaveResponse;
import com.noida.authority.response_model.SectorResponse;
import com.noida.authority.response_model.ServiceReportResponse;
import com.noida.authority.utils.Constants;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiManager {
    private Context mContext;
    private ProgressDialog dialog;
    private ApiResponseInterface mApiResponseInterface;
    ApiInterface apiService;

    public ApiManager(Context context, ApiResponseInterface apiResponseInterface) {
        this.mContext = context;
        this.mApiResponseInterface = apiResponseInterface;
        apiService = ApiClient.getClient().create(ApiInterface.class);
        dialog = new ProgressDialog(mContext);
    }

    public void loginRequest(String mobStr, String passwordStr) {
        showDialog();
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<LoginResponse> call = apiService.getLogin(mobStr, passwordStr);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    mApiResponseInterface.isSuccess(response.body(), Constants.LOGIN_REQUEST);
                } else {

                    //   mApiResponseInterface.isError(response.body().getError());
                }
                closeDialog();
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                closeDialog();

                Toast.makeText(mContext, "Network Error", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void requestToken(String mobStr, String passwordStr, String type) {
        showDialog();
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<TokenResponse> call = apiService.getToken(mobStr, passwordStr, type);
        call.enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    mApiResponseInterface.isSuccess(response.body(), Constants.Token_REQUEST);
                } else {

                    //   mApiResponseInterface.isError(response.body().getError());
                }
                closeDialog();
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                closeDialog();

                Toast.makeText(mContext, "Network Error", Toast.LENGTH_LONG).show();
            }
        });
    }


    public void getServiceReportByDept(String deptId, String startDate, String endDate, String requestthrough){
        showDialog();
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<ServiceReportResponse>> call = apiService.getServiceReportDeptWise(deptId, startDate, endDate, requestthrough);
        call.enqueue(new Callback<List<ServiceReportResponse>>() {
            @Override
            public void onResponse(Call<List<ServiceReportResponse>> call, Response<List<ServiceReportResponse>> response) {

                if (response.isSuccessful() && response.body() != null) {
                    mApiResponseInterface.isSuccess(response.body(), Constants.Token_REQUEST);
                } else {
                      // mApiResponseInterface.isError(response.body().getError());
                }
                closeDialog();
            }

            @Override
            public void onFailure(Call<List<ServiceReportResponse>> call, Throwable t) {
                closeDialog();

                Toast.makeText(mContext, "Network Error", Toast.LENGTH_LONG).show();
            }
        });
    }


    public void getKyaDetails(String token, String mobStr) {
        showDialog();
        Call<Object> call = apiService.getKyaDetails(token, mobStr);
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if (response.isSuccessful() && response.body() != null) {
                    mApiResponseInterface.isSuccess(response.body(), Constants.IS_KYA);

                } else {
                   /* JsonParser parser = new JsonParser();
                    JsonElement mJson = null;
                    try {
                        mJson = parser.parse(response.errorBody().string());
                        Gson gson = new Gson();
                        RetrofitErrorResponse errorResponse = gson.fromJson(mJson, RetrofitErrorResponse.class);
                        mApiResponseInterface.isError(errorResponse.getMessage());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }*/
                }

                closeDialog();
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                closeDialog();
                Toast.makeText(mContext, "Network Error", Toast.LENGTH_LONG).show();
            }
        });
    }


    public void getBlockList(String token) {
        showDialog();
        Call<List<BlockResponse>> call = apiService.getBlocks("Bearer " + token);
        call.enqueue(new Callback<List<BlockResponse>>() {
            @Override
            public void onResponse(Call<List<BlockResponse>> call, Response<List<BlockResponse>> response) {

                if (response.isSuccessful() && response.body() != null) {
                    mApiResponseInterface.isSuccess(response.body(), Constants.GET_BLOCK);


                } else {
                    /*JsonParser parser = new JsonParser();
                    JsonElement mJson = null;
                    try {
                        mJson = parser.parse(response.errorBody().string());
                        Gson gson = new Gson();
                        RetrofitErrorResponse errorResponse = gson.fromJson(mJson, RetrofitErrorResponse.class);
                        mApiResponseInterface.isError(errorResponse.getMessage());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }*/
                }

                closeDialog();
            }


            public void onFailure(Call<List<BlockResponse>> call, Throwable t) {
                closeDialog();
                Toast.makeText(mContext, "Network Error", Toast.LENGTH_LONG).show();
            }
        });
    }






    public void getSectorList(String token) {
        showDialog();
        Call<List<SectorResponse>> call = apiService.getSectors("Bearer " + token);
        call.enqueue(new Callback<List<SectorResponse>>() {
            @Override
            public void onResponse(Call<List<SectorResponse>> call, Response<List<SectorResponse>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    mApiResponseInterface.isSuccess(response.body(), Constants.GET_SECTOR);

                } else {
                    /*JsonParser parser = new JsonParser();
                    JsonElement mJson = null;
                    try {
                        mJson = parser.parse(response.errorBody());
                        Gson gson = new Gson();
                        RetrofitErrorResponse errorResponse = gson.fromJson(mJson, RetrofitErrorResponse.class);
                        mApiResponseInterface.isError(errorResponse.getMessage());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }*/
                }

                closeDialog();
            }

            public void onFailure(Call<List<SectorResponse>> call, Throwable t) {
                Toast.makeText(mContext, "Network Error", Toast.LENGTH_LONG).show();
            }
        });
    }


    public void searchKyaByRegId(String token, String regId) {
        showDialog();
        Call<PropertyResponse> call = apiService.getPropertyDetails(token, regId);
        call.enqueue(new Callback<PropertyResponse>() {
            @Override
            public void onResponse(Call<PropertyResponse> call, Response<PropertyResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    mApiResponseInterface.isSuccess(response.body(), Constants.SEARCH_KYA_WITH_RegId);
                } else {
                    /*JsonParser parser = new JsonParser();
                    JsonElement mJson = null;
                    try {
                        mJson = parser.parse(response.errorBody().string());
                        Gson gson = new Gson();
                        RetrofitErrorResponse errorResponse = gson.fromJson(mJson, RetrofitErrorResponse.class);
                        mApiResponseInterface.isError(errorResponse.getMessage());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }*/
                }

                closeDialog();
            }

            public void onFailure(Call<PropertyResponse> call, Throwable t) {
                Toast.makeText(mContext, "Network Error", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void searchKyaByProperty(String token, String sector, String block, String plot_flat) {
        showDialog();
        Call<PropertyResponse> call = apiService.getPropertyDetails(token, sector, block, plot_flat);
        call.enqueue(new Callback<PropertyResponse>() {
            @Override
            public void onResponse(Call<PropertyResponse> call, Response<PropertyResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    mApiResponseInterface.isSuccess(response.body(), Constants.SEARCH_KYA_PROPERTY);
                } else {
                   /* JsonParser parser = new JsonParser();
                    JsonElement mJson = null;
                    try {
                        mJson = parser.parse(String.valueOf(response.errorBody()));
                        Gson gson = new Gson();
                        RetrofitErrorResponse errorResponse = gson.fromJson(mJson, RetrofitErrorResponse.class);
                        mApiResponseInterface.isError(errorResponse.getMessage());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }*/
                }

                closeDialog();
            }

            public void onFailure(Call<PropertyResponse> call, Throwable t) {
                Toast.makeText(mContext, "Network Error", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void saveAllDoc(String token, MultipartBody.Part file, MultipartBody.Part file1, MultipartBody.Part file2,
                           String sectorName, String blockName, String plotNo,
                           String registrationId, String applicant, String applicantAddress, String gender, String department,
                           String mobileNo, String email, String panNumber) {
        showDialog();
        Call<SaveResponse> call = apiService.uploadDoc(token, file, file1, file2, sectorName, blockName, plotNo, registrationId, applicant, applicantAddress, gender, department,
                mobileNo, email, panNumber);
        call.enqueue(new Callback<SaveResponse>() {
            @Override
            public void onResponse(Call<SaveResponse> call, Response<SaveResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    mApiResponseInterface.isSuccess(response.body(), Constants.SAVE_KYA_PROPERTY);
                } else {
                    JsonParser parser = new JsonParser();
                    JsonElement mJson = null;
                    try {
                        mJson = parser.parse(response.errorBody().toString());
                        Gson gson = new Gson();
                        RetrofitErrorResponse errorResponse = gson.fromJson(mJson, RetrofitErrorResponse.class);
                        mApiResponseInterface.isError(errorResponse.getMessage());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }

                closeDialog();
            }

            public void onFailure(Call<SaveResponse> call, Throwable t) {
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
