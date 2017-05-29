package com.dingmouren.wallpager.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.FileDescriptor;

/**
 * Created by dingmouren on 2017/5/29.
 * 图片压缩功能
 */

public class ImageResizer {
    private static final String TAG = "ImageResizer";

    public ImageResizer() {
    }

    public Bitmap decodeSampledBitmapFromResource(Resources res,int resId,int reqWidth,int reqHeight){
        //check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res,resId,options);
        //calculate inSampleSize
        options.inSampleSize  = caculateInSampleSize(options,reqWidth,reqHeight);
        //decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res,resId,options);
    }

    public Bitmap decodeSampledBitmapFromFileDescriptor(FileDescriptor fd,int reqWidth,int reqHeight){
        //check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fd,null,options);//decodeFileDescriptor通过native生成bitmap,比decodeFiel()更加省内存
        //caculate inSampleSize
        options.inSampleSize = caculateInSampleSize(options,reqWidth,reqHeight);
        //decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFileDescriptor(fd,null,options);
    }

    public int caculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        if (reqWidth == 0 || reqHeight == 0){
            return 1;
        }
        //raw height and width of image
        final  int width = options.outWidth;
        final int height = options.outHeight;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth){
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;
            while ((halfHeight / inSampleSize )>= reqHeight && (halfWidth / inSampleSize) >= reqWidth){
                inSampleSize*=2;
            }
        }
        return inSampleSize;
    }


}
