package com.project.belajajrretrofit.view.main;

import android.content.Context;

import com.project.belajajrretrofit.api.ApiManager;
import com.project.belajajrretrofit.model.Order;
import com.project.belajajrretrofit.view.base.Presenter;

import java.util.List;

public class MainPresenter implements Presenter<MainView> {
    private MainView view = null;

    @Override
    public void onAttach(MainView view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        view = null;
    }

    public void getOrders(final Context context){
        if (view != null){
            view.showLoader();
        }

        ApiManager apiManager = new ApiManager();
        apiManager.getOrders(context, "so844c4gs0", "", new ApiManager.GetOrdersCallback() {
            @Override
            public void ketikaBerhasil(List<Order> orders) {
                if (view != null){
                    view.hideLoader();
                    view.onSuccessGetOrders(orders);
                }
            }

            @Override
            public void ketikaGagal(String message) {
                if (view != null){
                    view.hideLoader();
                    view.onFailedGetOrders(message);
                }
            }
        });
    }
}
