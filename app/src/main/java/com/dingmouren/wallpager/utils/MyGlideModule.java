package com.dingmouren.wallpager.utils;

import android.content.Context;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.request.target.ViewTarget;
import com.dingmouren.wallpager.R;

/**
 * Created by dingmouren on 2017/5/29.
 */

public class MyGlideModule implements GlideModule {
    private static final String TAG = "MyGlideModule";
    private int mMemoryCacheSize = (int) Runtime.getRuntime().maxMemory() / 8;
    private int mDiskCacheSize = 1024 * 1024 * 100;
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        ViewTarget.setTagId(R.id.glide_tag_id);
        MemorySizeCalculator calculator = new MemorySizeCalculator(context);
        int defaultMemoryCacheSize = calculator.getMemoryCacheSize();//返回运行的设备的推荐内存缓存大小（以字节为单位）,16M
        int defaultBitmapPoolSize = calculator.getBitmapPoolSize();//返回运行的设备的推荐位图池大小（以字节为单位）,32M
        Log.e(TAG,"glide默认的内存缓存大小:"+defaultMemoryCacheSize+" bitmap缓存池大小:"+defaultBitmapPoolSize);
        //设置内存缓存大小
        builder.setMemoryCache(new LruResourceCache(mMemoryCacheSize));
        builder.setBitmapPool(new LruBitmapPool(defaultBitmapPoolSize * 2));
        //设置磁盘缓存，缓存到私有缓存中，当卸载app时随之卸载
        builder.setDiskCache(new InternalCacheDiskCacheFactory(context,"glide",mDiskCacheSize));
//        builder.setDiskCache(new ExternalCacheDiskCacheFactory(context,"glide",mDiskCacheSize)); 磁盘缓存设置在sd卡中
        //设置图片的解码格式,默认的就是RGB_565,不带透明度，一个像素占2个字节，ARGB_8888:32位图，有透明度，一个像素占4个字节；ARGB_4444：16位图，有透明度，一个像素占2个字节。
        builder.setDecodeFormat(DecodeFormat.PREFER_RGB_565);
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
