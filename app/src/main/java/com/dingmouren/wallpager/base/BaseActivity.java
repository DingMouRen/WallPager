package com.dingmouren.wallpager.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dingmouren.wallpager.Constant;
import com.dingmouren.wallpager.MyApplication;
import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.interfaces.Themeable;
import com.dingmouren.wallpager.interfaces.UiElementInizializer;
import com.dingmouren.wallpager.utils.ColorPalette;
import com.dingmouren.wallpager.utils.SPUtil;
import com.dingmouren.wallpager.utils.ViewUtil;

import butterknife.ButterKnife;

/**
 * Created by dingmouren on 2017/5/2.
 */

public abstract class BaseActivity extends AppCompatActivity implements UiElementInizializer{
    private static final String TAG = BaseActivity.class.getName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        initTheme();
        setContentView(requestLayout());
        ButterKnife.bind(this);
        initInjector();
        initView();
        initListener();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUiElements();
    }

    /**
     * 设置布局前的初始化
     */
    public void  init(){}
    /**
     * 初始化主题
     */
    public void initTheme(){}
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

    /**
     * 更新组件UI
     */
    @Override
    public void updateUiElements() {
        for (View view : ViewUtil.getAllChildren(findViewById(android.R.id.content))){
            if (view instanceof Themeable){
                ((Themeable)view).refreshTheme();
            }
        }
        updateStatusBarUI();
    }

    /**
     * 更改状态栏颜色
     */
    public void updateStatusBarUI(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            boolean isTranslucentStatusBar = (boolean) SPUtil.get(MyApplication.sContext,Constant.STATUS_TRANSLUCENT,false);
            int color = (Integer) SPUtil.get(MyApplication.sContext, Constant.COLOR_PRIMARY, getResources().getColor(R.color.md_teal_A400));
            getWindow().setStatusBarColor(color);
//            if (isTranslucentStatusBar){
//                getWindow().setStatusBarColor(ColorPalette.getObscuredColor(color));
//            }else {
//                getWindow().setStatusBarColor(color);
//            }
        }
    }
}
