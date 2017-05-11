package com.dingmouren.wallpager;

import android.content.Context;

import org.androidannotations.annotations.App;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by dingmouren on 2017/5/11.
 */
@Singleton
@Component (modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(MyApplication myApplication);
    Context getApplicationContext();
}
