package com.project.belajajrretrofit.api;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.project.belajajrretrofit.BuildConfig;
import com.project.belajajrretrofit.model.LoginResponse;
import com.project.belajajrretrofit.model.Order;
import com.project.belajajrretrofit.model.OrderResponse;
import com.project.belajajrretrofit.model.RegisterResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiManager {
    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    public void getOrders(final Context context, String apiKey, String orderId, final GetOrdersCallback getOrdersCallback){
        final Call<OrderResponse> orderResponseCall = apiInterface.getOrders(apiKey, orderId);
        orderResponseCall.enqueue(new Callback<OrderResponse>() {
            @Override
            public void onResponse(Call<OrderResponse> call, Response<OrderResponse> response) {
                if (response.isSuccessful()) getOrdersCallback.ketikaBerhasil(response.body().getMessage().getOrders());
                else getOrdersCallback.ketikaGagal("API ERROR !");
            }

            @Override
            public void onFailure(Call<OrderResponse> call, Throwable t) {
                if (t instanceof IOException) getOrdersCallback.ketikaGagal("Internet Error");
                else getOrdersCallback.ketikaGagal("Terjadi kesalahan");
            }
        });
    }

    public interface GetOrdersCallback {
        void ketikaBerhasil(List<Order> orders);
        void ketikaGagal(String message);
    }

    public void register(final Context context, String apiKey, HashMap<String, String> object, final RegisterCallback registerCallback){
        final Call<RegisterResponse> registerResponseCall = apiInterface.register(apiKey, object.get("email"),
                object.get("nama"), object.get("phone"), object.get("password"), object.get("hfPushId"), object.get("version"),
                object.get("build"), object.get("imei"));

        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                if (response.isSuccessful()) registerCallback.onSuccessRegiter();
                else registerCallback.onFailedRegister();
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                if (t instanceof IOException) registerCallback.onFailedRegister();
                else registerCallback.onFailedRegister();
            }
        });
    }

    public interface RegisterCallback{
        void onSuccessRegiter();
        void onFailedRegister();
    }

    public void login(final Context context, String email, String password, final LoginCallback loginCallback){
        final Call<LoginResponse> loginResponseCall = apiInterface.login("8nrKgxv3mp", email, password, "123", BuildConfig.VERSION_NAME, String.valueOf(BuildConfig.VERSION_CODE),"21331");
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) loginCallback.onSuccessLogin();
                else loginCallback.onFailedLogin();
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                if (t instanceof IOException) loginCallback.onFailedLogin();
                else loginCallback.onFailedLogin();
            }
        });
    }

    public interface LoginCallback{
        void onSuccessLogin();
        void onFailedLogin();
    }
}


