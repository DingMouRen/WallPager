package com.dingmouren.wallpager.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.FloatRange;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.dingmouren.wallpager.Constant;
import com.dingmouren.wallpager.MyApplication;
import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.interfaces.Themeable;
import com.dingmouren.wallpager.utils.DensityUtils;
import com.dingmouren.wallpager.utils.SPUtil;
import com.dingmouren.wallpager.utils.ScreenUtils;

/**
 * Created by dingmouren on 2017/5/17.
 * 该视图可以模拟状态栏的高度。您可以通过此视图填充状态栏
 */

public class StatusBarView extends View implements Themeable{

    public StatusBarView(Context context) {
        super(context);
    }

    public StatusBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StatusBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    /** <br> UI. */

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension( MeasureSpec.getSize(widthMeasureSpec),
               getStatusBarHeight());
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public void refreshTheme() {
        setBackgroundColor((Integer) SPUtil.get(MyApplication.sContext, Constant.COLOR_PRIMARY, R.color.md_cyan_A200));
    }
}
