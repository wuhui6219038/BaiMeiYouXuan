package com.baimeiyx.www.http;

import com.baimeiyx.www.http.api.BaiMeiApiService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataManager {
    private static Retrofit retrofit = null;

    private DataManager() {

    }

    public static void _init() {
        _initRetrofit();
    }

    private static OkHttpClient _initOkhttp() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();
        return okHttpClient;

    }

    //初始化
    private static void _initRetrofit() {
        retrofit = new Retrofit.Builder()
                .client(_initOkhttp())
                .baseUrl(BaiMeiApiService.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static BaiMeiApiService getBaiMeiApiService() {
        return retrofit.create(BaiMeiApiService.class);

    }
}
