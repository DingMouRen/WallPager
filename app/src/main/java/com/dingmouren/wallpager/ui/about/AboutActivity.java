package com.dingmouren.wallpager.ui.about;

import android.support.v7.widget.Toolbar;

import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by dingmouren on 2017/5/25.
 */

public class AboutActivity extends BaseActivity {
    @BindView(R.id.toolbar) Toolbar mToolbar;
    @Override
    public int requestLayout() {
        return R.layout.activity_about;
    }

    @Override
    public void initView() {
        mToolbar.setTitle("关于");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public void initListener() {
        mToolbar.setNavigationOnClickListener(v -> onBackPressed());
    }
}
