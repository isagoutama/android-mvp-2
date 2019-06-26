package com.project.belajajrretrofit.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.tu-kang.com/dev/")
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}