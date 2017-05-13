package com.dingmouren.wallpager.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;

import com.dingmouren.wallpager.Constant;
import com.dingmouren.wallpager.MyApplication;
import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.interfaces.Themeable;
import com.dingmouren.wallpager.utils.SPUtil;

/**
 * Created by dingmouren on 2017/5/3.
 */

public class ThemeableToolbar extends Toolbar implements Themeable {
    public ThemeableToolbar(Context context) {
        super(context);
    }

    public ThemeableToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ThemeableToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void refreshTheme() {
        setBackgroundColor((Integer) SPUtil.get(MyApplication.sContext,Constant.COLOR_PRIMARY, R.color.md_cyan_A200));
    }
}
