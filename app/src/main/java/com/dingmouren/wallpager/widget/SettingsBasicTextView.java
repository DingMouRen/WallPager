package com.dingmouren.wallpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.interfaces.Themeable;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dingmouren on 2017/5/4.
 */

public class SettingsBasicTextView extends FrameLayout implements Themeable {
    @DrawableRes private final int mIconId;
    @StringRes private final int mTitleId;
    @StringRes private final int mCaptionId;
    @BindView(R.id.icon) ImageView mImgIcon;
    @BindView(R.id.title) TextView mTvTitle;
    @BindView(R.id.caption)TextView mTvCaption;
    public SettingsBasicTextView(Context context) {
        this(context,null);
    }

    public SettingsBasicTextView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SettingsBasicTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setBackgroundResource(R.drawable.ripple);//水波纹效果的背景

        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.view_setting_basic,this);//将初始化出来的视图应用到这个ViewGroup

        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.SettingsBasicTextView);
        mIconId = a.getResourceId(R.styleable.SettingsBasicTextView_settingIcon,0);
        mTitleId = a.getResourceId(R.styleable.SettingsBasicTextView_settingTitle,0);
        mCaptionId = a.getResourceId(R.styleable.SettingsBasicTextView_settingCaption,0);
        a.recycle();
    }

    @Override
    protected void onFinishInflate() {
        ButterKnife.bind(this);
        mImgIcon.setImageResource(mIconId);
        mTvTitle.setText(mTitleId);
        mTvCaption.setText(mCaptionId);
        super.onFinishInflate();
    }

    @Override
    public void refreshTheme() {

    }
}
