package com.dingmouren.wallpager.ui.home;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.dingmouren.wallpager.Constant;
import com.dingmouren.wallpager.model.UnsplashResult;
import com.dingmouren.wallpager.net.ApiManager;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dingmouren on 2017/5/2.
 */

public class HomePresenter implements HomeContract.Presenter {

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private HomeAdapter mHomeAdapter;
    private HomeContract.View mView;
    private int mPage = 1;

    public HomePresenter(HomeContract.View view){
        this.mView = view;
        this.mRecyclerView = view.getRecyclerView();
        this.mSwipeRefreshLayout = view.getSwipeRefreshLayout();
        this.mHomeAdapter = view.getAdapter();
    }
    @Override
    public void requestData() {
        mView.setRefresh(true);
        ApiManager.getInstance().getApiService().getPhotos(Constant.UNSPLASH_APP_KEY,mPage,10,Constant.ORDER_BY_POPULAR)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(unsplashResults -> parseData(unsplashResults),this::loadError);
    }

    private void loadError(Throwable throwable){
        throwable.printStackTrace();
    }

    private void parseData(List<UnsplashResult> data){
        if (data != null) {
            mPage = mPage + 1;
            mHomeAdapter.setList(data);
            mHomeAdapter.notifyDataSetChanged();
            mView.setRefresh(false);
        }
    }

    public void setRefreshListener(){
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                requestData();
            }
        });
    }

}
