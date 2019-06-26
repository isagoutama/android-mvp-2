package com.project.belajajrretrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderResponse {

    public class Message{
        @SerializedName("in_progress")
        private List<Order> orders;

        public List<Order> getOrders() {
            return orders;
        }

        public void setOrders(List<Order> orders) {
            this.orders = orders;
        }
    }

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private Message message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
