package com.dingmouren.wallpager.widget;

import android.content.Context;
import android.graphics.Color;
import android.icu.text.DateFormat;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;

import com.dingmouren.wallpager.Constant;
import com.dingmouren.wallpager.MyApplication;
import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.interfaces.Themeable;
import com.dingmouren.wallpager.utils.SPUtil;

import java.lang.reflect.Field;

/**
 * Created by dingmouren on 2017/5/18.
 */

public class ThemeableTabLayout extends TabLayout implements Themeable{
    public ThemeableTabLayout(Context context) {
        super(context);
    }

    public ThemeableTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ThemeableTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void refreshTheme() {
        setBackgroundColor((Integer) SPUtil.get(MyApplication.sContext, Constant.COLOR_PRIMARY, R.color.md_cyan_A200));
    }
}
