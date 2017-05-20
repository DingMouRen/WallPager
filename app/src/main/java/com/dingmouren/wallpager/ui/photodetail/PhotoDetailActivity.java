package com.dingmouren.wallpager.ui.photodetail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;

import com.dingmouren.wallpager.Constant;
import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.base.BaseActivity;
import com.dingmouren.wallpager.model.bean.UnsplashResult;

/**
 * Created by dingmouren on 2017/5/20.
 */

public class PhotoDetailActivity extends BaseActivity {
    private static final String UNSPLASH_RESULT = "unsplash_result";
    public static void newInstance(Context context, UnsplashResult unsplashResult){
        Intent intent = new Intent(context,PhotoDetailActivity.class);
        intent.putExtra(UNSPLASH_RESULT,unsplashResult);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public int requestLayout() {
        return R.layout.activity_photo_detail;
    }

    @Override
    public void initView() {
        if (getIntent() == null){
            return;
        }
        PhotoDetailFragment photoDetailFragment = PhotoDetailFragment.newInstance((UnsplashResult)getIntent().getSerializableExtra(UNSPLASH_RESULT));
        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.container,photoDetailFragment)
                .commit();

    }
}
