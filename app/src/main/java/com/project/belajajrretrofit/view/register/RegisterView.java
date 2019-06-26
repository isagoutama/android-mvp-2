package com.project.belajajrretrofit.view.register;

import com.project.belajajrretrofit.view.base.View;

public interface RegisterView extends View {
    void onSuccessRegister();
    void onFailedRegister();
    void showLoader();
    void hideLoader();
}
