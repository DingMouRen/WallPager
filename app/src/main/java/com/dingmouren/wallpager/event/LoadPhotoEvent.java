package com.dingmouren.wallpager.event;

/**
 * Created by dingmouren on 2017/5/22.
 */

public class LoadPhotoEvent {
    private int progress;
    private String photoId;

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
