package com.dingmouren.wallpager.interfaces;

import android.support.annotation.NonNull;
import android.widget.ImageView;

/**
 * Created by dingmouren on 2017/5/15.
 * 图片下载要实现的接口
 */

public interface InterfaceImgLoad {
    void loadImage(@NonNull String url, @NonNull ImageView imageView);
}
