package com.dingmouren.wallpager;

import android.app.Application;
import android.content.Context;

import com.dingmouren.wallpager.utils.SPUtil;
import com.jiongbull.jlog.JLog;

/**
 * Created by dingmouren on 2017/5/2.
 */

public class MyApplication extends Application {

    public static Context sContext;
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.sContext = this;
        mApplicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        mApplicationComponent.inject(this);
        JLog.init(this);
        initPrimaryColor();
    }

    private void initPrimaryColor() {
        int primaryColor = (int) SPUtil.get(this,Constant.COLOR_PRIMARY,0);
        int accentColor = (int) SPUtil.get(this,Constant.COLOR_ACCENT,0);
        if (primaryColor == 0){
            SPUtil.put(this,Constant.COLOR_PRIMARY,getResources().getColor(R.color.md_cyan_A200));
        }
        if (accentColor == 0){
            SPUtil.put(this,Constant.COLOR_ACCENT,getResources().getColor(R.color.md_pink_A200));
        }
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
