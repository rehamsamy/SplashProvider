package com.openthedoorprovider.utils;

import com.openthedoorprovider.pojo.ChangePasswordResponse;
import com.openthedoorprovider.pojo.LoginResponse;
import com.openthedoorprovider.pojo.RegisterProviderResponse;
import com.openthedoorprovider.pojo.UpdateProfileResponse;

import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;

public interface RetrofitInterface {

    @POST("api/provider/login")
    Call<LoginResponse> loginUser(@QueryMap Map<String, Object> map);


    @Multipart
    @POST("api/provider/register")
    Call<RegisterProviderResponse> registerProvider(@QueryMap Map<String,Object> map,@Part MultipartBody.Part image, @Part MultipartBody.Part file);


    @POST("api/provider/updateprofile")
    Call<UpdateProfileResponse> updateProfile(@QueryMap Map<String,Object> map);

    @POST("api/provider/changepassword")
    Call<ChangePasswordResponse> changePassword(@QueryMap Map<String,Object> map);



}
