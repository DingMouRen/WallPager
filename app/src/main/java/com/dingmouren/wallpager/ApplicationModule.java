package com.dingmouren.wallpager;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dingmouren on 2017/5/11.
 */
@Module
public class ApplicationModule {

    private final MyApplication mMyApplication;

    public ApplicationModule(MyApplication application){
        this.mMyApplication = application;
    }

    @Provides
    @Singleton
    Context provideApplication(){
        return mMyApplication;
    }

}
