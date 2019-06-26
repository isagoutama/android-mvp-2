package com.project.belajajrretrofit.view.register;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.belajajrretrofit.view.login.LoginActivity;
import com.project.belajajrretrofit.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, RegisterView{
    private EditText edtNama, edtEmail, edtPassword, edtConfPassword;
    private RegisterPresenter registerPresenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerPresenter = new RegisterPresenter();
        onAttachView();

        edtNama = findViewById(R.id.edt_nama);
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        edtConfPassword = findViewById(R.id.edt_conf_password);

        Button btnSubmitReg = findViewById(R.id.btn_submit_reg);
        Button btnLogin = findViewById(R.id.btn_login);

//        btnSubmitReg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        btnSubmitReg.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit_reg:
                String nama = edtNama.getText().toString();
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();

                boolean isInputValidated = true;
                if (nama.isEmpty()) {
//                    Toast.makeText(this, "Nama harus diisi !", Toast.LENGTH_SHORT).show();
                    edtNama.setError("harus diisi !");
                    isInputValidated = false;
                }

                if (email.isEmpty()) {
//                    Toast.makeText(this, "Nama harus diisi !", Toast.LENGTH_SHORT).show();
                    edtEmail.setError("harus diisi !");
                    isInputValidated = false;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    edtEmail.setError("email tidak valid !");
                    isInputValidated = false;
                }

                if (password.isEmpty()) {
//                    Toast.makeText(this, "Nama harus diisi !", Toast.LENGTH_SHORT).show();
                    edtPassword.setError("harus diisi !");
                    isInputValidated = false;
                }

                if (!edtConfPassword.getText().toString().equals(password)) {
                    edtConfPassword.setError("password tidak sesuai !");
                    isInputValidated = false;
                }

                if (isInputValidated) {
                    registerPresenter.register(email, nama, "", password, "123", "123", this);
                }
                break;
            case R.id.btn_login:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }


    }

    @Override
    public void onSuccessRegister() {
        Toast.makeText(this, "Berhasil register", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailedRegister() {
        Toast.makeText(this, "Gagal register", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoader() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Bentar ya...");
        progressDialog.show();
    }

    @Override
    public void hideLoader() {
        if (progressDialog != null) progressDialog.dismiss();
    }

    @Override
    public void onAttachView() {
        registerPresenter.onAttach(this);
    }

    @Override
    public void onDetachView() {
        registerPresenter.onDetach();
    }

    @Override
    protected void onDestroy() {
        onDetachView();
        super.onDestroy();
    }
}
