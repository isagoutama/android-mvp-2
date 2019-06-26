package com.project.belajajrretrofit.view.main;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.project.belajajrretrofit.R;
import com.project.belajajrretrofit.adapter.OrderListAdapter;
import com.project.belajajrretrofit.api.ApiClient;
import com.project.belajajrretrofit.api.ApiInterface;
import com.project.belajajrretrofit.model.Order;
import com.project.belajajrretrofit.model.OrderResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter mainPresenter;
    private Context context;
    private RecyclerView rvOrder;
    private OrderListAdapter orderListAdapter;
    private List<Order> orders = new ArrayList<>();
    private ProgressDialog progressDialog;

    @Override
    public void onAttachView() {
        mainPresenter.onAttach(this);
    }

    @Override
    public void onDetachView() {
        mainPresenter.onDetach();
    }

    @Override
    public void onSuccessGetOrders(List<Order> orders) {
        this.orderListAdapter.setOrders(orders);
    }

    @Override
    public void onFailedGetOrders(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoader() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Tunggu bentar...");
        progressDialog.show();
    }

    @Override
    public void hideLoader() {
        if (progressDialog != null){
            progressDialog.dismiss();
        }
    }

    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter();
        onAttachView();

        context = this;
        rvOrder = findViewById(R.id.rv_order);
        rvOrder.setLayoutManager(new LinearLayoutManager(context));
        orderListAdapter = new OrderListAdapter();
        rvOrder.setAdapter(orderListAdapter);
        mainPresenter.getOrders(context);
    }


    @Override
    protected void onDestroy() {
        onDetachView();
        super.onDestroy();
    }
}
