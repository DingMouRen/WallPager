package com.dingmouren.wallpager.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;
import com.dingmouren.wallpager.Constant;
import com.dingmouren.wallpager.MyApplication;
import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.event.LoadPhotoEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by dingmouren on 2017/5/22.
 */

public class PhotoLoadService extends IntentService {
    private static final String TAG = PhotoLoadService.class.getName();
    private static final String ACTION = "com.dingmouren.wallpager.intentservice.loadphoto";
    private static final String PHOTO_LOAD_URL = "photo_load_url";
    private static final String PHOTO_ID = "photo_id";
    private LoadPhotoEvent mLoadPhotoEvent;
    public static Intent newIntent(Context context,String downUrl,String photoId){
        Intent intent = new Intent(context,PhotoLoadService.class);
        intent.setAction(ACTION);
        intent.putExtra(PHOTO_LOAD_URL,downUrl);
        intent.putExtra(PHOTO_ID,photoId);
        return intent;
    }
    public PhotoLoadService() {
        super(TAG);
        EventBus.getDefault().register(this);
        mLoadPhotoEvent = new LoadPhotoEvent();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onHandleIntent(Intent intent) {
        String photoLoadUrl = null;
        String photoId = null;
       if (intent != null) {
           photoLoadUrl = intent.getStringExtra(PHOTO_LOAD_URL);
           photoId = intent.getStringExtra(PHOTO_ID);
       }
        File file = new File(Environment.getExternalStorageDirectory()+"/WallPager/"+photoId+".jpg");
        if (file.exists()){
            mLoadPhotoEvent.setPhotoId("exist");
            EventBus.getDefault().postSticky(mLoadPhotoEvent);//发送事件,图片文件已存在
            return;
        }
        HttpURLConnection connec = null;
        try{
            URL url = new URL(photoLoadUrl);
            connec = (HttpURLConnection) url.openConnection();
            connec.setDoInput(true);
            connec.setConnectTimeout(20 * 1000);
            int code = connec.getResponseCode();
            if (code == 200){
                InputStream is = connec.getInputStream();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                int length = -1;
                int progress = 0;
                int contentLength = connec.getContentLength();
                byte[] buffer = new byte[1024];
                while((length = is.read(buffer))!= -1){
                    progress+= length;
                    mLoadPhotoEvent.setProgress(progress * 100 / contentLength);
                    mLoadPhotoEvent.setPhotoId(photoId);
                    EventBus.getDefault().postSticky(mLoadPhotoEvent);//发送事件,更新UI
                    bos.write(buffer,0,length);
                }
                bos.flush();
                bos.close();
                is.close();
                savePhoto(photoId,bos);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (connec != null) connec.disconnect();
        }
    }


    private void savePhoto(String photoId,ByteArrayOutputStream bos){
       Bitmap bitmap = BitmapFactory.decodeByteArray(bos.toByteArray(),0,bos.toByteArray().length);
        File photoDir = new File(Environment.getExternalStorageDirectory(),"WallPager");
        if (!photoDir.exists()){
            photoDir.mkdir();
        }
        File file = new File(photoDir,photoId+".jpg");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 其次把文件插入到系统图库
        try {
            MediaStore.Images.Media.insertImage(MyApplication.sContext.getContentResolver(),
                    file.getAbsolutePath(), file.getName(), null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 最后通知图库更新
        MyApplication.sContext.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + photoDir.getAbsolutePath())));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void doNothing(LoadPhotoEvent event){

    }
}
