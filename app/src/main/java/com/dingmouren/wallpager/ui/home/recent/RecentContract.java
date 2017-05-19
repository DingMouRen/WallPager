package com.dingmouren.wallpager.ui.home.recent;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.dingmouren.wallpager.base.BasePresenter;
import com.dingmouren.wallpager.base.BaseView;
import com.dingmouren.wallpager.model.bean.UnsplashResult;

import java.util.List;

/**
 * Created by dingmouren on 2017/5/2.
 */

public interface RecentContract {

    interface View extends BaseView{
        void setData(List<UnsplashResult> data);
        int getCategoryId();
    }

    interface Presenter extends BasePresenter{

    }
}
