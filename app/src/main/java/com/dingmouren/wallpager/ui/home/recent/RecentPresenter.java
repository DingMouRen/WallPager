package com.dingmouren.wallpager.ui.home.recent;

import com.dingmouren.wallpager.Constant;
import com.dingmouren.wallpager.model.bean.UnsplashResult;
import com.dingmouren.wallpager.api.Api;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dingmouren on 2017/5/2.
 */

public class RecentPresenter implements RecentContract.Presenter {

    private RecentContract.View mView;
    private Api mApi;
    private int mPage = 1;
    private int mCategory;
    @Inject
    public RecentPresenter(RecentFragment fragment, Api api){
        this.mApi = api;
        this.mView = fragment;
    }

    public void setCategory(int category) {
        this.mCategory = category;
    }

    @Override
    public void requestData() {
        switch (mCategory){
            case 101:
                mApi.getRecentPhotos(Constant.UNSPLASH_APP_KEY,mPage,Constant.NUM_PER_PAGE,Constant.ORDER_BY_LATEST)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(unsplashResults -> parseData(unsplashResults),this::loadError);
                break;
            case 102:
                mApi.getCuratedPhotos(Constant.UNSPLASH_APP_KEY,mPage,Constant.NUM_PER_PAGE,Constant.ORDER_BY_LATEST)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(unsplashResults -> parseData(unsplashResults),this::loadError);
                break;
            case 103:
                mApi.getBuildingsPhotos(Constant.UNSPLASH_APP_KEY,mPage,Constant.NUM_PER_PAGE)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(unsplashResults -> parseData(unsplashResults),this::loadError);
                break;
            case 104:
                mApi.getFoodsPhotos(Constant.UNSPLASH_APP_KEY,mPage,Constant.NUM_PER_PAGE)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(unsplashResults -> parseData(unsplashResults),this::loadError);
                break;
            case 105:
                mApi.getNaturePhotos(Constant.UNSPLASH_APP_KEY,mPage,Constant.NUM_PER_PAGE)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(unsplashResults -> parseData(unsplashResults),this::loadError);
                break;
            case 106:
                mApi.getGoodsPhotos(Constant.UNSPLASH_APP_KEY,mPage,Constant.NUM_PER_PAGE)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(unsplashResults -> parseData(unsplashResults),this::loadError);
                break;
            case 107:
                mApi.getPersonPhotos(Constant.UNSPLASH_APP_KEY,mPage,Constant.NUM_PER_PAGE)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(unsplashResults -> parseData(unsplashResults),this::loadError);
                break;
            case 108:
                mApi.getTechnologyPhotos(Constant.UNSPLASH_APP_KEY,mPage,Constant.NUM_PER_PAGE)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(unsplashResults -> parseData(unsplashResults),this::loadError);
                break;
        }

    }

    private void loadError(Throwable throwable){
        throwable.printStackTrace();
    }

    private void parseData(List<UnsplashResult> data){
        if (data != null) {
            mPage = mPage + 1;
            mView.setData(data);
        }
    }

}
