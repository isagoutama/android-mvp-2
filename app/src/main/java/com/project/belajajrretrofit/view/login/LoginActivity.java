package com.project.belajajrretrofit.view.login;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.belajajrretrofit.BuildConfig;
import com.project.belajajrretrofit.R;
import com.project.belajajrretrofit.api.ApiClient;
import com.project.belajajrretrofit.api.ApiInterface;
import com.project.belajajrretrofit.model.LoginResponse;

import java.io.IOException;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginView {

    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    private EditText edtEmail, edtPassword;
    private LoginPresenter loginPresenter;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);

        Button btnSubmitLogin = findViewById(R.id.btn_submit_login);
        btnSubmitLogin.setOnClickListener(this);
        loginPresenter = new LoginPresenter();
        onAttachView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_submit_login:
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();

//                HashMap<String, String> object = new HashMap<>();
//                object.put("email", email);
//                object.put("password", password);
//                loginPresenter.
//                loginPresenter.login(email, password, this);
                loginPresenter.validateInput(this, email, password);
                break;
        }
    }

    @Override
    public void onSuccessLogin() {
        Toast.makeText(this, "login berhasil", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailedLogin() {
        Toast.makeText(this, "login gagal", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoader() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Nunggu login...");
        progressDialog.show();
    }

    @Override
    public void hideLoader() {
        if (progressDialog !=  null){
            progressDialog.dismiss();
        }
    }

    @Override
    public void onInputInvalid(HashMap<String, String> submitLogin) {
        if (submitLogin.get("errorEmail") != null){
            edtEmail.setError(submitLogin.get("errorEmail"));
        }

        if (submitLogin.get("errorPassword") !=  null){
            edtPassword.setError(submitLogin.get("errorPassword"));
        }
    }

    @Override
    public void onAttachView() {
        loginPresenter.onAttach(this);
    }

    @Override
    public void onDetachView() {
        loginPresenter.onDetach();
    }

    @Override
    protected void onDestroy() {
        onDetachView();
        super.onDestroy();
    }
}
