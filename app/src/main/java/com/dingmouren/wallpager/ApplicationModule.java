package com.dingmouren.wallpager;

import android.content.Context;

import com.dingmouren.wallpager.api.Api;
import com.jiongbull.jlog.JLog;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dingmouren on 2017/5/11.
 */
@Module
public class ApplicationModule {
    private static final int READ_TIME_OUT = 5;
    private static final int CONNECT_TIME_OUT = 15;
    private final MyApplication mMyApplication;

    public ApplicationModule(MyApplication application){
        this.mMyApplication = application;
    }

    @Provides
    @Singleton
    Context provideApplication(){
        return mMyApplication;
    }

    /**
     * 提供日志插值器
     */
    @Provides
    @Singleton
    public HttpLoggingInterceptor provideHttpLoggingInterceptor(){

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(message -> {
           JLog.json(message);
        }).setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }

    /**
     * 提供okhttp客户端
     */
    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(CONNECT_TIME_OUT,TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build();
        return okHttpClient;
    }

    /**
     * 提供retrofit对象
     */
    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient){
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Constant.UNSPLASH_MAIN_URL)
                .build();
        return retrofit;
    }

    /**
     * 提供Api类
     */
    @Provides
    @Singleton
    public Api provideApi(Retrofit retrofit){
        return retrofit.create(Api.class);
    }

}
