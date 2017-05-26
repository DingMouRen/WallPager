package com.dingmouren.wallpager.ui.photodetail;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.transition.ChangeImageTransform;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;

import com.dingmouren.wallpager.Constant;
import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.base.BaseActivity;
import com.dingmouren.wallpager.model.bean.UnsplashResult;

/**
 * Created by dingmouren on 2017/5/20.
 */

public class PhotoDetailActivity extends BaseActivity {
    private static final String UNSPLASH_RESULT = "unsplash_result";
    private PhotoDetailFragment mPhotoDetailFragment;
    public static void newInstance(Activity activity, UnsplashResult unsplashResult, View view){
        Intent intent = new Intent(activity,PhotoDetailActivity.class);
        intent.putExtra(UNSPLASH_RESULT,unsplashResult);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= 21) {
            activity.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(activity, view, activity.getResources().getString(R.string.share_photo)).toBundle());
        }else {
            activity.startActivity(intent);
        }
    }

    @Override
    public void init() {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setSharedElementExitTransition(new ChangeImageTransform());
            getWindow().setSharedElementReenterTransition(new ChangeImageTransform());
        }
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
        mPhotoDetailFragment = PhotoDetailFragment.newInstance((UnsplashResult)getIntent().getSerializableExtra(UNSPLASH_RESULT) );
        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.container,mPhotoDetailFragment)
                .commit();

    }

    @SuppressLint("CommitTransaction")
    @Override
    protected void onDestroy() {
        super.onDestroy();
        getSupportFragmentManager().beginTransaction()
                .remove(mPhotoDetailFragment);
    }
}
