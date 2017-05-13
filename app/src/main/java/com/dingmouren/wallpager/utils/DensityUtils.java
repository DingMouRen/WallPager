package com.dingmouren.wallpager.utils;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by dingmouren on 2017/5/3.
 * 常用的单位转换类
 */

public class DensityUtils {

    /**
     * dp转px
     * @param context
     * @param dpValue
     * @return
     */
    public static int dp2px(Context context,float dpValue){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dpValue,context.getResources().getDisplayMetrics());
    }

    /**
     * sp转px
     * @param context
     * @param spValue
     * @return
     */
    public static int sp2px(Context context,float spValue){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,spValue,context.getResources().getDisplayMetrics());
    }

    /**
     * px转dp
     * @param context
     * @param pxValue
     * @return
     */
    public static float px2dp(Context context,float pxValue){
        return pxValue/context.getResources().getDisplayMetrics().density;
    }

    /**
     * px转sp
     * @param context
     * @param pxValue
     * @return
     */
    public static float px2sp(Context context,float pxValue){
        return pxValue / context.getResources().getDisplayMetrics().scaledDensity;
    }
}
