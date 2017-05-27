package com.dingmouren.wallpager;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.dingmouren.wallpager.model.dao.Channel;
import com.dingmouren.wallpager.utils.MyFABBehavior;
import com.dingmouren.wallpager.utils.SPUtil;
import com.jiongbull.jlog.JLog;
import com.tencent.bugly.crashreport.CrashReport;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

/**
 * Created by dingmouren on 2017/5/2.
 */

public class MyApplication extends Application {
    private static final String TAG = MyApplication.class.getName();

    public static Context sContext;
    private static ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        this.sContext = this;
        mApplicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        mApplicationComponent.inject(this);
        JLog.init(this);
        initPrimaryColor();
        CrashReport.initCrashReport(getApplicationContext());
    }

    private void initPrimaryColor() {
        int primaryColor = (int) SPUtil.get(this,Constant.COLOR_PRIMARY,0);
        int accentColor = (int) SPUtil.get(this,Constant.COLOR_ACCENT,0);
        if (primaryColor == 0){
            SPUtil.put(this,Constant.COLOR_PRIMARY,getResources().getColor(R.color.md_teal_A400));
        }
        if (accentColor == 0){
            SPUtil.put(this,Constant.COLOR_ACCENT,getResources().getColor(R.color.md_pink_A400));
        }
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

}
