package com.dingmouren.wallpager.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dingmouren.wallpager.interfaces.Themeable;
import com.dingmouren.wallpager.interfaces.UiElementInizializer;
import com.dingmouren.wallpager.utils.ViewUtil;

import butterknife.ButterKnife;

/**
 * Created by dingmouren on 2017/5/2.
 */

public abstract class BaseFragment extends Fragment implements UiElementInizializer {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(requestLayout(),container,false);
        ButterKnife.bind(this,rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initInjector();
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
     * 初始化注入
     */
    public void initInjector(){}
    /**
     * 初始化监听器
     */
    public void initListener(){}

    /**
     * 初始化数据
     */
    public void initData(){}

    @Override
    public void onResume() {
        super.onResume();
        updateUiElements();
    }

    @Override
    public void updateUiElements() {
        for (View view : ViewUtil.getAllChildren(getActivity().findViewById(android.R.id.content))){
            if (view instanceof Themeable){
                ((Themeable)view).refreshTheme();
            }
        }
    }
}
