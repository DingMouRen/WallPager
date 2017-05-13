package com.dingmouren.wallpager.utils;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;

import com.dingmouren.wallpager.MyApplication;

/**
 * Created by dingmouren on 2017/5/3.
 */

public class MyFABBehavior extends FloatingActionButton.Behavior {
    private static final String TAG = MyFABBehavior.class.getName();
    public MyFABBehavior(Context context, AttributeSet attrs) {
        super();
    }
//依赖的实现
    @Override//用于决定是否产生依赖行为
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        return dependency instanceof AppBarLayout;//依赖于AppBarLayout位置和大小的变化
    }

    @Override//依赖的控件发生大小或者位置变化时产生回调
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        float scaleY = Math.abs(dependency.getY()) / dependency.getHeight();
        child.setTranslationY((child.getHeight() +  DensityUtils.dp2px(MyApplication.sContext,16)) * scaleY );//随着AppBarLayout的出现而出现，隐藏而隐藏
        return true;
    }
}
