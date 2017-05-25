package com.dingmouren.wallpager.model.bean;

import io.realm.RealmObject;

/**
 * Created by dingmouren on 2017/5/25.
 */

public class FavPhoto extends RealmObject {
    private String id;
    private int width;
    private int height;
    private String created_at;
    private String fullUrl;
    private String rawUrl;
    private String requlatUrl;
    private String smallUrl;
    private String thumbUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public String getRawUrl() {
        return rawUrl;
    }

    public void setRawUrl(String rawUrl) {
        this.rawUrl = rawUrl;
    }

    public String getRequlatUrl() {
        return requlatUrl;
    }

    public void setRequlatUrl(String requlatUrl) {
        this.requlatUrl = requlatUrl;
    }

    public String getSmallUrl() {
        return smallUrl;
    }

    public void setSmallUrl(String smallUrl) {
        this.smallUrl = smallUrl;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }
}
