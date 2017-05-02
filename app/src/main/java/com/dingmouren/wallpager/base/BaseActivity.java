package com.dingmouren.wallpager.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by dingmouren on 2017/5/2.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(requestLayout());
        ButterKnife.bind(this);
        initView();
        initListener();
        initData();
    }

    /**
     * 设置布局前的初始化
     */
    public void  init(){}
    /**
     * 布局
     * @return
     */
    public abstract int requestLayout();

    /**
     * View需要初始化的
     */
    public  void initView(){}

    /**
     * 初始化监听器
     */
    public void initListener(){}

    /**
     * 初始化数据
     */
    public void initData(){}

}
