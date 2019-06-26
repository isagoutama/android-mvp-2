package com.project.belajajrretrofit.api;

import com.project.belajajrretrofit.model.LoginResponse;
import com.project.belajajrretrofit.model.OrderResponse;
import com.project.belajajrretrofit.model.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("customer_v2/signup_v4/format/json")
    Call<RegisterResponse> register(
            @Header("X-API-KEY") String apiKey,
            @Field("txtEmail") String email,
            @Field("txtName") String name,
            @Field("txtMobilePhone") String phone,
            @Field("txtPassword") String password,
            @Field("hfPushID") String hfPushId,
            @Field("version") String version,
            @Field("build") String build,
            @Field("hfNumber") String imei
    );

    @FormUrlEncoded
    @POST("customer_v2/signin_v4/format/json")
    Call<LoginResponse> login(
            @Header("X-API-KEY") String apiKey,
            @Field("txtEmail") String email,
            @Field("txtPassword") String password,
            @Field("hfPushID") String hfPushId,
            @Field("version") String version,
            @Field("build") String build,
            @Field("hfNumber") String imei
    );

    @FormUrlEncoded
    @POST("customer_v2/orderlist_v2/format/json")
    Call<OrderResponse> getOrders(
            @Header("X-API-KEY") String apiKey,
            @Field("customer_id") String customerId
    );


}
