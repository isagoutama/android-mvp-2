package com.project.belajajrretrofit.model;

import com.google.gson.annotations.SerializedName;

public class Order {
    @SerializedName("id")
    private String id;

    @SerializedName("Subcategory")
    private String subcategory;

    @SerializedName("order_status_text")
    private String orderStatus;

    @SerializedName("Vendor")
    private String vendor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}
