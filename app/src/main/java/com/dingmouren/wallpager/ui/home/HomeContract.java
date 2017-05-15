package com.dingmouren.wallpager.ui.home;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.dingmouren.wallpager.base.BasePresenter;
import com.dingmouren.wallpager.base.BaseView;
import com.dingmouren.wallpager.model.bean.UnsplashResult;

import java.util.List;

/**
 * Created by dingmouren on 2017/5/2.
 */

public interface HomeContract {

    interface View extends BaseView{
        RecyclerView getRecyclerView();
        SwipeRefreshLayout getSwipeRefreshLayout();
        void setData(List<UnsplashResult> data);
    }

    interface Presenter extends BasePresenter{

    }
}
