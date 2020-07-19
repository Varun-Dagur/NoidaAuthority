package com.noida.authority.mernretrofit;

import com.noida.authority.body_model.TokenResponse;
import com.noida.authority.response_model.ComplaintResponse;
import com.noida.authority.response_model.DepartmentResponse;
import com.noida.authority.response_model.LoginResponse;
import com.noida.authority.response_model.ServiceResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MernApiInterface {

    @GET("v1/master/service")
    Call<List<ServiceResponse>> getServices(@Query("departmentId") int deptId);


    @GET("v1/master/department")
    Call<List<DepartmentResponse>> getDepartments();


    @GET("v1/customer/complaint/")
    Call<List<ComplaintResponse>> getComplaints(@Query("mobile") int mobile);

    @FormUrlEncoded
    @POST("v1/customer/complaint/")
    Call<String> registerComplaint(@Field("departmentId") int departmentId, @Field("serviceId") int serviceid,
                                 @Field("subject") String subject, @Field("complaint") String complaint,
                                 @Field("requestLocation") String requestLocation, @Field("name") String name,
                                 @Field("mobile") String mobile, @Query("email") String email,
                                 @Field("comAddress") String comAddress, @Field("idProof") String idProof,
                                 @Field("sector") String sector, @Field("block") String block,
                                 @Field("village") String village, @Field("plotNo") String plotNo,
                                 @Field("address") String address );





}
