package com.dingmouren.wallpager.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.dingmouren.wallpager.Constant;
import com.dingmouren.wallpager.MyApplication;
import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.interfaces.Themeable;
import com.dingmouren.wallpager.utils.SPUtil;

/**
 * Created by dingmouren on 2017/5/25.
 */

public class ThemeableTextView extends TextView implements Themeable{
    public ThemeableTextView(Context context) {
        super(context);
    }

    public ThemeableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ThemeableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void refreshTheme() {
        setTextColor((Integer) SPUtil.get(MyApplication.sContext, Constant.COLOR_PRIMARY, R.color.md_cyan_A200));
    }
}
