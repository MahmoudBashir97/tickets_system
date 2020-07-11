package com.mahmoud.bashir.tickets_system.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitJSON {


    private static Retrofit ourInstance;

    Gson gson = new GsonBuilder().serializeNulls().create();
    HttpLoggingInterceptor loggingInterceptor= new HttpLoggingInterceptor();



    public static Retrofit getInstance() {

        if(ourInstance ==null)


            ourInstance= new Retrofit.Builder()
                    .baseUrl("https://haflty.000webhostapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // when u using Rxjava with Retrofit u need Adapter call RxJava2CallAdapterFactory.create()
                    .build();

        return ourInstance;
    }


    public RetrofitJSON() {
    }
}
