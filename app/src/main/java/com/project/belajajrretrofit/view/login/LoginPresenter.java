package com.project.belajajrretrofit.view.login;

import android.content.Context;
import android.util.Patterns;

import com.project.belajajrretrofit.api.ApiManager;
import com.project.belajajrretrofit.view.base.Presenter;

import java.util.HashMap;

public class LoginPresenter implements Presenter<LoginView> {
    private LoginView loginView = null;

    @Override
    public void onAttach(LoginView view) {
        loginView = view;
    }

    @Override
    public void onDetach() {
        loginView = null;
    }

    public void login(String email, String password, Context context) {
        if (loginView != null) {
            loginView.showLoader();
        }

        ApiManager apiManager = new ApiManager();
        apiManager.login(context, email, password, new ApiManager.LoginCallback() {
            @Override
            public void onSuccessLogin() {
                if (loginView != null) {
                    loginView.hideLoader();
                    loginView.onSuccessLogin();
                }
            }

            @Override
            public void onFailedLogin() {
                if (loginView != null) {
                    loginView.hideLoader();
                    loginView.onFailedLogin();
                }
            }
        });

    }

    private HashMap<String, String> isSubmitValidated(String email, String password, Context context) {
        HashMap<String, String> validate = new HashMap<>();
        boolean isInputValidated = true;
        if (email.isEmpty()) {
            validate.put("errorEmail", "Email harus diisi");
            isInputValidated = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            validate.put("errorEmail", "Email tidak valid");
            isInputValidated = false;
        }

        if (password.isEmpty()) {
            validate.put("errorPassword", "Passwor harus diisi");
            isInputValidated = false;
        }
        if (isInputValidated) {
            login(email, password, context);
        }
        return validate;
    }

    public void validateInput(Context context, String email, String password) {
        HashMap<String, String> errorValidation = new HashMap<>();
        boolean isInputValidated = true;

        if (email.isEmpty()) {
            errorValidation.put("errorEmail", "Email harus diisi");
            isInputValidated = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            errorValidation.put("errorEmail", "Email tidak valid");
            isInputValidated = false;
        }

        if (password.isEmpty()) {
            errorValidation.put("errorPassword", "Passwor harus diisi");
            isInputValidated = false;
        }

        if (isInputValidated) {
            login(email, password, context);
        } else {
            if (loginView != null) loginView.onInputInvalid(errorValidation);
        }
    }
}
