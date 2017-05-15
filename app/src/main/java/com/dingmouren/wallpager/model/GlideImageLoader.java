package com.dingmouren.wallpager.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dingmouren.wallpager.MyApplication;
import com.dingmouren.wallpager.interfaces.InterfaceImgLoad;

import javax.inject.Inject;

/**
 * Created by dingmouren on 2017/5/15.
 */

public class GlideImageLoader implements InterfaceImgLoad {

    @Override
    public void loadImage(@NonNull String url, @NonNull ImageView imageView) {
        Glide.with(MyApplication.sContext).load(url).crossFade(500).centerCrop().into(imageView);
    }
}
