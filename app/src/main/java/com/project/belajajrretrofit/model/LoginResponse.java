package com.project.belajajrretrofit.model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    public class Message {
        @SerializedName("id")
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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
