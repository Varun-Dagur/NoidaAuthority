package com.noida.authority.retrofit;

import com.noida.authority.body_model.PropertyResponse;
import com.noida.authority.body_model.TokenResponse;
import com.noida.authority.response_model.BlockResponse;
import com.noida.authority.response_model.LoginResponse;
import com.noida.authority.response_model.SaveResponse;
import com.noida.authority.response_model.SectorResponse;
import com.noida.authority.response_model.ServiceReportResponse;

import java.io.File;
import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("token")
    @FormUrlEncoded
    Call<TokenResponse> getToken(@Field("username") String mobStr, @Field("password") String passwordStr,
                                 @Field("grant_type") String type);

    @POST("api/LoginController/Login")
    Call<LoginResponse> getLogin(@Query("username") String mobStr, @Query("password") String passwordStr);


    @GET("api/LoginController/GetPropertyDetailsByMobileNumber")
    Call<Object> getKyaDetails(@Header("Authorization") String token, @Query("mobileNo") String mobileNumber);


    @GET("api/KYAController/GetBlocks")
    Call<List<BlockResponse>> getBlocks(@Header("Authorization") String token);


    @GET("api/KYAController/GetSector")
    Call<List<SectorResponse>> getSectors(@Header("Authorization") String token);


    @GET("api/PropertyController/GetPropertyDetailsByAddress")
    Call<PropertyResponse> getPropertyDetails(@Header("Authorization") String token, @Query("sectorName") String sector,
                                              @Query("blockName") String blockName, @Query("PlotNo") String PlotNo);


    @GET("api/KYAController/GetPropertyDetailsByRid")
    Call<PropertyResponse> getPropertyDetails(@Header("Authorization") String token,
                                              @Query("RegistrationId") String registrationId);

    @GET("api/DashboardController/GetServiceReportsDeptWise")
    Call<List<ServiceReportResponse>>getServiceReportDeptWise(@Query("deptid") String deptid,
                                                @Query("StartDate") String startDate,
                                                @Query("EndDate") String endDate,
                                                @Query("ReqestThrough") String reqestThrough );

    @Multipart
    @POST("api/KYAController/SavePropertyDetailForKYA")
    Call<SaveResponse> uploadDoc(@Header("Authorization") String token, @Part MultipartBody.Part file,
                                 @Part MultipartBody.Part file1, @Part MultipartBody.Part file2,
                                 @Query("sector") String sectorName,
                                 @Query("block") String blockName, @Query("PlotNo") String plotNo,
                                 @Query("RegistrationId") String registrationId, @Query("Name") String applicant,
                                 @Query("Address") String applicantAddress, @Query("Type") String gender,
                                 @Query("Department") String department, @Query("MobileNo") String mobileNo,
                                 @Query("EmailId") String email, @Query("Pan") String panNumber);







  /*   @GET("v1/attendance/attendance-type")
    Call<AttendanceTypeResponse> getAttendanceType(@Header("Authorization") String token,
                                                   @Query("p") int page, @Query("l") int l);

    @POST("v1/attendance/check-in")
    Call<MarkAttendenceResponse> markAttendence(@Header("Authorization") String token,
                                                @Body MarkAttendenceBody parameters);

    @POST("v1/attendance/check-out")
    Call<MarkAttendenceResponse> outAttendence(@Header("Authorization") String token);

    @Multipart
    @PUT("v1/employee/profile-picture")
    Call<ProfilePicUploadResponse> uploadProfilePic(@Header("Authorization") String token, @Part MultipartBody.Part file, @Part("userId") int userId);

    @Multipart
    @PUT("v1/employee/document")
    Call<DocumentResponse> documentUpload(@Header("Authorization") String token, @Part("userId") int userId,
                                          @Part("documentTypeId") int documentTypeId,
                                          @Part("documentNumber") String documentNumber,
                                          @Part MultipartBody.Part file);


*/
}

