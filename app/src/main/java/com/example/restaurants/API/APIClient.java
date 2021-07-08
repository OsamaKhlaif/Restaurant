package com.example.restaurants.API;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static final String BASE_URL = "https://api.yelp.com";
    private static final String token = "6zrGPNnMa2Lpae-67baeo9V1AvpLubq1cY7GRCaEUch2ryZjVdxKdP7lMfYbcP-51X1bh8X-saBSgcSWZ5fs5crb6V_2NTzrLdAqDEZySXWqcgF1xt05A7NmnWXcYHYx";

    public static Retrofit getClient() {

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(chain -> {
            Request newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer " + token)
                    .build();

            return chain.proceed(newRequest);
        }).build();

        return new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }




}
