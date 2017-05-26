package com.dingmouren.wallpager.ui.splash;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.transition.Fade;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.dingmouren.wallpager.ApplicationComponent;
import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.base.BaseActivity;
import com.dingmouren.wallpager.ui.MainActivity;

import butterknife.BindView;

/**
 * Created by dingmouren on 2017/5/26.
 */

public class SplashActivity extends BaseActivity {
    @BindView(R.id.desc)   TextView mDesc;
    @BindView(R.id.appname)   TextView mAppName;
    @BindView(R.id.logo) ImageView mImageView;
    @Override
    public void init() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Fade fade = new Fade();
                fade.setDuration(800);
                getWindow().setExitTransition(fade);
                getWindow().setEnterTransition(fade);
            }
    }

    @Override
    public int requestLayout() {
        return R.layout.activity_splash;
    }


    @Override
    public void initView() {
        AssetManager assetManager = getAssets();
        Typeface typeface = Typeface.createFromAsset(assetManager, "fonts/font_style1.ttf");
        mDesc.setTypeface(typeface);
        new Handler().postDelayed(() -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class),     ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this).toBundle());
                delayFinish();
            }else {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                delayFinish();
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }
        }, 1000);
    }

    private void delayFinish(){
        new Handler().postDelayed(()->finish(),1000);
    }

}
