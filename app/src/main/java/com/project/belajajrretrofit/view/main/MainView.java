package com.project.belajajrretrofit.view.main;

import com.project.belajajrretrofit.model.Order;
import com.project.belajajrretrofit.view.base.View;

import java.util.List;

public interface MainView extends View {
    void onSuccessGetOrders(List<Order> orders);
    void onFailedGetOrders(String message);
    void showLoader();
    void hideLoader();
}
