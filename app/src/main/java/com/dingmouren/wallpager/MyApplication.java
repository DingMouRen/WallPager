package com.dingmouren.wallpager;

import android.app.Application;
import android.content.Context;

import com.jiongbull.jlog.JLog;

/**
 * Created by dingmouren on 2017/5/2.
 */

public class MyApplication extends Application {

    public static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        this.sContext = this;
        JLog.init(this);
    }
}
