package com.dingmouren.wallpager.ui.home;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dingmouren.wallpager.MyApplication;
import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.base.BaseFragment;

import java.lang.ref.WeakReference;

import butterknife.BindView;

/**
 * Created by dingmouren on 2017/5/2.
 */

public class HomeFragment extends BaseFragment implements HomeContract.View{

    private static final int DELAY_TIME_OUT = 1500;

    @BindView(R.id.recycler) RecyclerView mRecyclerView;
    @BindView(R.id.swipe_refresh)SwipeRefreshLayout mSwipeRefreshLayout;

    private Handler mHandler;
    private DelayRunnable mDelayRunnable;
    private HomePresenter mHomePresenter;
    private HomeAdapter mHomeAdapter;

    @Override
    public void init() {
        mHandler = new Handler();
        mDelayRunnable = new DelayRunnable(this);
        mHomeAdapter = new HomeAdapter();
    }

    @Override
    public int requestLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MyApplication.sContext));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mHomeAdapter);
    }

    @Override
    public void initListener() {
        mHomePresenter = new HomePresenter((HomeContract.View) this);
        mHomePresenter.setRefreshListener();//下拉加载下一页，没有上拉加载更多
    }

    @Override
    public void initData() {
        mHomePresenter.requestData();
    }


    @Override
    public void setRefresh(boolean refresh) {
        if (refresh)
            mSwipeRefreshLayout.setRefreshing(true);
        else
            mHandler.postDelayed(mDelayRunnable,DELAY_TIME_OUT);
    }

    @Override
    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    @Override
    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return mSwipeRefreshLayout;
    }

    @Override
    public HomeAdapter getAdapter() {
        return mHomeAdapter;
    }

    /**
     * 延时任务
     */
    public static class DelayRunnable implements Runnable{
       private WeakReference<HomeFragment> mHomeFragmentWeakReference;
       public DelayRunnable(HomeFragment fragment){
           this.mHomeFragmentWeakReference = new WeakReference<HomeFragment>(fragment);
       }
       @Override
       public void run() {
            HomeFragment homeFragment = mHomeFragmentWeakReference.get();
           if (homeFragment != null){
               homeFragment.mSwipeRefreshLayout.setRefreshing(false);
           }
       }
   }
}
