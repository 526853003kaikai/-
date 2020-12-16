package com.example.p7day01;

import retrofit2.Retrofit;

public class RetrofitManager {

    //懒汉式
    private static RetrofitManager retrofitManager;

    private RetrofitManager() {
        new Retrofit.Builder().baseUrl(ApiService.URL);
    }

    public synchronized static RetrofitManager getRetrofitManager() {

        synchronized (RetrofitManager.class) {
            if (retrofitManager == null) {
                if (retrofitManager == null) {
                    retrofitManager = new RetrofitManager();
                }
            }
            return retrofitManager;
        }
    }

}
