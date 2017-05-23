package com.dingmouren.wallpager.ui.photosloaded;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by dingmouren on 2017/5/23.
 */

public class PhotosLoadedActivity extends BaseActivity {
    @BindView(R.id.toolbar) Toolbar mToolbar;
    @Override
    public int requestLayout() {
        return R.layout.activity_photos_loaded;
    }

    @Override
    public void initView() {
        mToolbar.setTitle("下载缓存");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout,new PhotosLoadedFragment())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    @Override
    public void initListener() {
        mToolbar.setNavigationOnClickListener(v -> onBackPressed());
    }
}
