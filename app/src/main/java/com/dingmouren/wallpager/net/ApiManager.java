package com.dingmouren.wallpager.net;

import android.content.Context;

import com.dingmouren.wallpager.Constant;
import com.jiongbull.jlog.JLog;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dingmouren on 2017/5/2.
 */

public class ApiManager {
    private static final int READ_TIME_OUT = 5;
    private static final int CONNECT_TIME_OUT = 15;
    private Api mApiService;
    private ApiManager(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(message -> showRetrofitLog(message)).setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(CONNECT_TIME_OUT,TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Constant.UNSPLASH_MAIN_URL)
                .build();
        mApiService = retrofit.create(Api.class);
    }

    private static class SingletonHolder{
        private static final ApiManager INSTANCE = new ApiManager();
    }

    public static ApiManager getInstance(){
        return SingletonHolder.INSTANCE;
    }

    /**
     * 打印日志
     * 返回的是json，就打印格式化好了的json，不是json就原样打印
     * @param message
     */
    private void showRetrofitLog(String message){

            JLog.e("Retrofit:",message);
    }

    public Api getApiService(){
        return mApiService;
    }


}
