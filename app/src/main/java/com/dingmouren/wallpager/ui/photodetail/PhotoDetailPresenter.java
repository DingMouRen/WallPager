package com.dingmouren.wallpager.ui.photodetail;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;

import com.dingmouren.wallpager.Constant;
import com.dingmouren.wallpager.MyApplication;
import com.dingmouren.wallpager.api.Api;
import com.dingmouren.wallpager.api.ApiManager;
import com.dingmouren.wallpager.model.bean.PhotoInfo;
import com.dingmouren.wallpager.utils.ScreenUtils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dingmouren on 2017/5/20.
 */

public class PhotoDetailPresenter implements PhotoInfoContract.Presenter {

    private String mId;
    private PhotoInfoContract.View mView;
    private WallpaperManager mWallpaperManager;
    private String mPhotoUrl;
    public PhotoDetailPresenter(String id, PhotoInfoContract.View view,String photoUrl) {
        this.mPhotoUrl = photoUrl;
        this.mWallpaperManager = WallpaperManager.getInstance(MyApplication.sContext);
        this.mId = id;
        this.mView = view;
    }

    @Override
    public void requestData() {
        ApiManager.getSingle().getApi().getPhotoInfo(mId,Constant.UNSPLASH_APP_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(photoInfo -> parseData(photoInfo),this::loadError);
    }

    private void loadError(Throwable throwable){
        throwable.printStackTrace();
    }

    public void parseData(PhotoInfo photoInfo){
        if (photoInfo != null){
            mView.setData(photoInfo);
        }
    }

    @Override
    public void setWallPager() {

        new SetWallPagerTask().execute(mPhotoUrl);
    }


    class SetWallPagerTask extends AsyncTask<String,Void,Integer>{

        @Override
        protected void onPreExecute() {
            mView.showDialog();
        }

        @Override
        protected Integer doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                HttpURLConnection connect = (HttpURLConnection) url.openConnection();
                connect.setConnectTimeout(10 * 1000);
                connect.setDoInput(true);
                connect.connect();
                int code = connect.getResponseCode();
                if (code == 200){
                    InputStream inputStream = connect.getInputStream();
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    int length = -1;
                    byte[] buffer = new byte[1024];
                    while((length = inputStream.read(buffer))!= -1){
                        bos.write(buffer,0,length);
                    }
                    bos.flush();
                    bos.close();
                    inputStream.close();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeByteArray(bos.toByteArray(),0,bos.toByteArray().length,options);
                    int reqWidth = ScreenUtils.getScreenWidth(MyApplication.sContext);
                    int reqHeight = ScreenUtils.getScreenHeight(MyApplication.sContext);
                    int rawWidth = options.outWidth;
                    int rawHeight = options.outHeight;
                    int size = 1;
                    if (rawHeight > reqHeight || rawWidth > reqWidth){
                        int halfHeight = rawHeight / 2 ;
                        int halfWidth = rawWidth / 2;
                        while ((halfHeight / size) > reqHeight && (halfWidth / size)>reqWidth){
                            size *= 2;
                        }
                    }
                    options.inSampleSize = size;
                    options.inJustDecodeBounds = false;
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bos.toByteArray(),0,bos.toByteArray().length,options);
                    mWallpaperManager.setBitmap(bitmap);
                    return 200;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return 400;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Integer integer) {
           switch (integer.intValue()){
               case 200:
                   mView.dismissDialog();
                   mView.setWallPagerSuccess();
                   break;
               case 400:
                   mView.dismissDialog();
                   mView.setWallPagerFail();
                   break;
           }
        }
    }
}
