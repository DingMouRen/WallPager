package com.dingmouren.wallpager.utils;

import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;

/**
 * Created by dingmouren on 2017/5/4.
 */

public class ColorPalette {

    /**
     * 获取颜色指定透明度的颜色
     * @param color
     * @param alpha
     * @return
     */
    public static int getTransparentColor(int color,int alpha){
        return ColorUtils.setAlphaComponent(color,alpha);
    }

    /**
     * 获取遮罩层的颜色
     * @param color
     * @return
     */
    public static int getObscuredColor(int color){
        float[] hsv = new float[3];
        int obscuredColor = color;
        Color.colorToHSV(obscuredColor,hsv);
        hsv[2] *= 0.85f;
        obscuredColor = Color.HSVToColor(hsv);
        return obscuredColor;
    }
}
