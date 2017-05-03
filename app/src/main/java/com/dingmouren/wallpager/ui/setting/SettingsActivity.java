package com.dingmouren.wallpager.ui.setting;

import android.support.v7.widget.Toolbar;

import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by dingmouren on 2017/5/3.
 */

public class SettingsActivity extends BaseActivity {
    @BindView(R.id.toolbar)Toolbar mToolbar;
    @Override
    public int requestLayout() {
        return R.layout.activity_settings;
    }

    @Override
    public void initView() {
        mToolbar.setTitle(getString(R.string.settings_title));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public void initListener() {
        mToolbar.setNavigationOnClickListener((view)-> onBackPressed());
    }
}
