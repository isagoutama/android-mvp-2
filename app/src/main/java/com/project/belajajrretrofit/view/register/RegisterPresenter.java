package com.project.belajajrretrofit.view.register;

import android.content.Context;
import android.widget.Toast;

import com.project.belajajrretrofit.BuildConfig;
import com.project.belajajrretrofit.api.ApiClient;
import com.project.belajajrretrofit.api.ApiInterface;
import com.project.belajajrretrofit.api.ApiManager;
import com.project.belajajrretrofit.model.RegisterResponse;
import com.project.belajajrretrofit.view.base.Presenter;

import java.io.IOException;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter implements Presenter<RegisterView> {
    private RegisterView registerView = null;

    @Override
    public void onAttach(RegisterView view) {
        registerView = view;
    }

    @Override
    public void onDetach() {
        registerView = null;
    }

    public void register(String email,
                         String name,
                         String phone,
                         String password,
                         String hfPushId,
                         String imei, final Context context){
        ApiManager apiManager = new ApiManager();
        HashMap<String, String> object = new HashMap<String, String>();
        object.put("email", email);
        object.put("nama", name);
        object.put("phone", phone);
        object.put("password", password);
        object.put("hfPushid", hfPushId);
        object.put("imei",imei);
        if (registerView != null) registerView.showLoader();
        apiManager.register(context, "8nrKgxv3mp", object, new ApiManager.RegisterCallback() {
            @Override
            public void onSuccessRegiter() {
                if (registerView != null){
                    registerView.hideLoader();
                    registerView.onSuccessRegister();
                }
            }

            @Override
            public void onFailedRegister() {
                if (registerView != null){
                    registerView.hideLoader();
                    registerView.onFailedRegister();
                }
            }
        });
    }
}
