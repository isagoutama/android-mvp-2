package com.project.belajajrretrofit.view.login;

import com.project.belajajrretrofit.view.base.View;

import java.util.HashMap;

public interface LoginView extends View {
    void onSuccessLogin();
    void onFailedLogin();
    void showLoader();
    void hideLoader();
    void onInputInvalid(HashMap<String, String> submitLogin);
}
