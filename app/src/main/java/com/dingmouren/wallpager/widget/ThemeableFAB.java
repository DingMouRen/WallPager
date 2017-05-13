package com.dingmouren.wallpager.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;

import com.dingmouren.wallpager.Constant;
import com.dingmouren.wallpager.MyApplication;
import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.interfaces.Themeable;
import com.dingmouren.wallpager.utils.SPUtil;

/**
 * Created by dingmouren on 2017/5/4.
 */

public class ThemeableFAB extends FloatingActionButton implements Themeable{
    private ColorStateList mColorStateList;
    public ThemeableFAB(Context context) {
        super(context);
    }

    public ThemeableFAB(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ThemeableFAB(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void refreshTheme() {
        int color = (int) SPUtil.get(MyApplication.sContext, Constant.COLOR_ACCENT,getResources().getColor(R.color.md_pink_A200));
        mColorStateList = ColorStateList.valueOf(color);
        setBackgroundTintList(mColorStateList);
        setAlpha(0.65f);
    }
}
