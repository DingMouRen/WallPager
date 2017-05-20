package com.dingmouren.wallpager.ui.photodetail;

import com.dingmouren.wallpager.Constant;
import com.dingmouren.wallpager.api.Api;
import com.dingmouren.wallpager.api.ApiManager;
import com.dingmouren.wallpager.model.bean.PhotoInfo;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dingmouren on 2017/5/20.
 */

public class PhotoDetailPresenter implements PhotoInfoContract.Presenter {

    private String mId;
    private PhotoInfoContract.View mView;

    public PhotoDetailPresenter(String id, PhotoInfoContract.View view) {
        mId = id;
        mView = view;
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
}
