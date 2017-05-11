package com.dingmouren.test.ui.home;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.dingmouren.test.base.BasePresenter;
import com.dingmouren.test.base.BaseView;
import com.dingmouren.test.model.UnsplashResult;

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
