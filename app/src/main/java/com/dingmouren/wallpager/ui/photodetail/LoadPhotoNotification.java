package com.dingmouren.wallpager.ui.photodetail;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.util.Log;
import android.widget.RemoteViews;

import com.dingmouren.wallpager.Constant;
import com.dingmouren.wallpager.MyApplication;
import com.dingmouren.wallpager.R;

/**
 * Created by dingmouren on 2017/5/22.
 */

public class LoadPhotoNotification extends Notification {
    private static final String TAG = LoadPhotoNotification.class.getName();
    private NotificationManager mNotificationManager;
    private RemoteViews mRemoteViews;
    private Notification mNotification;

    public LoadPhotoNotification() {
        mNotificationManager = (NotificationManager) MyApplication.sContext.getSystemService(Context.NOTIFICATION_SERVICE);
        mRemoteViews = new RemoteViews(MyApplication.sContext.getPackageName(), R.layout.notification_load_photo);
        mNotification = new Notification.Builder(MyApplication.sContext)
                .setSmallIcon(R.drawable.ic_notification)
                .setContent(mRemoteViews)
                .setContentTitle(MyApplication.sContext.getResources().getString(R.string.notification_title))
                .setAutoCancel(false)
                .build();
    }

    public void updateProgress(int progress){
        if (progress >= 0){
            mRemoteViews.setProgressBar(R.id.progressbar,100,progress,false);
            mRemoteViews.setTextViewText(R.id.tv_progress,progress+"%");
        }
        mNotificationManager.notify(101,mNotification);
    }

    public void clearNotification(){
        mNotificationManager.cancelAll();
    }
}
