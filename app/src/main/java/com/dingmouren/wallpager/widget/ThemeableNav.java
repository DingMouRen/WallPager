package com.dingmouren.wallpager.widget;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.util.AttributeSet;
import android.util.Log;

import com.dingmouren.wallpager.Constant;
import com.dingmouren.wallpager.MyApplication;
import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.interfaces.Themeable;
import com.dingmouren.wallpager.utils.SPUtil;

/**
 * Created by dingmouren on 2017/5/23.
 */

public class ThemeableNav extends NavigationView implements Themeable {
    private static final String TAG = ThemeableNav.class.getName();
    public ThemeableNav(Context context) {
        super(context);
    }

    public ThemeableNav(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ThemeableNav(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void refreshTheme() {
        getHeaderView(0).findViewById(R.id.nav_header_container).setBackgroundColor((Integer) SPUtil.get(MyApplication.sContext, Constant.COLOR_PRIMARY, R.color.md_cyan_A200));
    }
}
