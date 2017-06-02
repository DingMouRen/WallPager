package com.dingmouren.wallpager.api;

import com.dingmouren.wallpager.Constant;
import com.jiongbull.jlog.JLog;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dingmouren on 2017/5/20.
 */

public class ApiManager {
    private static final int READ_TIME_OUT = 15;
    private static final int WRITE_TIME_OUT = 15;
    private static final int CONNECT_TIME_OUT = 15;
    private Api mApi;
    public static ApiManager sApiManager;
    private ApiManager() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(message -> {
            JLog.json(message);
        }).setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(CONNECT_TIME_OUT,TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIME_OUT,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)//重连
                .addInterceptor(loggingInterceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Constant.UNSPLASH_MAIN_URL)
                .build();
        mApi = retrofit.create(Api.class);
    }

    public static ApiManager getSingle(){
        if (sApiManager == null){
            sApiManager = new ApiManager();
        }
        return sApiManager;
    }

    public Api getApi(){
        return mApi;
    }

}
