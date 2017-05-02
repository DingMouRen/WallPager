package com.dingmouren.wallpager.ui.home;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.base.BaseActivity;
import com.dingmouren.wallpager.ui.home.HomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)  Toolbar mToolbar;

    private FragmentManager mFragmentManager;

    @Override
    public void init() {
        mFragmentManager = getSupportFragmentManager();
    }

    @Override
    public int requestLayout() {
        return R.layout.activity_main;
    }


    @Override
    public void initView() {
        mToolbar.setTitle("壁纸");
        setSupportActionBar(mToolbar);
        mFragmentManager.beginTransaction().add(R.id.frame_layout,new HomeFragment()).commit();
    }
}
