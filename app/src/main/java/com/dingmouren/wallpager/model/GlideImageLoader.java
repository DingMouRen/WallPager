package com.dingmouren.wallpager.model;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.dingmouren.wallpager.MyApplication;
import com.dingmouren.wallpager.interfaces.InterfaceImgLoad;

/**
 * Created by dingmouren on 2017/5/15.
 */

public class GlideImageLoader implements InterfaceImgLoad {


    @Override
    public void loadImage(@NonNull String url,int holderImg, @NonNull ImageView imageView) {
        Glide.with(MyApplication.sContext).load(url)
                .crossFade(500)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(imageView);
    }

    @Override
    public void loadAutoImage(@NonNull String url, int holderImg, @NonNull ImageView imageView) {
//        Glide.with(MyApplication.sContext)
//                .load(url)
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                .listener(new RequestListener<String, GlideDrawable>() {
//                    @Override
//                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
//                        if (imageView == null) return false;
//                        if (imageView.getScaleType() != ImageView.ScaleType.FIT_XY){
//                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//                        }
//
//                        ViewGroup.LayoutParams params = imageView.getLayoutParams();
//                        int width = imageView.getWidth() - imageView.getPaddingLeft() - imageView.getPaddingRight();
//                        float scale = (float) width / resource.getIntrinsicWidth();
//                        int height = Math.round(resource.getIntrinsicHeight() * scale);
//                        params.height = height + imageView.getPaddingBottom() + imageView.getPaddingTop();
//                        imageView.setLayoutParams(params);
//                        return false;
//                    }
//                })
//                .placeholder(holderImg)
//                .error(holderImg)
//                .into(imageView);
        Glide.with(MyApplication.sContext)
                .load(url)
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        if (resource != null){
                            imageView.setImageBitmap(resource);
                        }
                    }
                });

    }

}
