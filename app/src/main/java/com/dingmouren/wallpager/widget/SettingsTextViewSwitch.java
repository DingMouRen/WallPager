package com.dingmouren.wallpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.dingmouren.wallpager.Constant;
import com.dingmouren.wallpager.MyApplication;
import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.interfaces.Themeable;
import com.dingmouren.wallpager.utils.ColorPalette;
import com.dingmouren.wallpager.utils.SPUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dingmouren on 2017/5/4.
 */

public class SettingsTextViewSwitch extends FrameLayout implements Themeable,View.OnClickListener{
    @DrawableRes  private final int mIconId;
    @StringRes private final int mTitleId;
    @StringRes private final int mCaptionId;
    @BindView(R.id.icon) ImageView mImgIcon;
    @BindView(R.id.title) TextView mTvTitle;
    @BindView(R.id.caption)TextView mTvCaption;
    @BindView(R.id.toggle) SwitchCompat mToggle;
    private OnClickListener mOnClickListener;
    public SettingsTextViewSwitch(Context context) {
        this(context,null);
    }

    public SettingsTextViewSwitch(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SettingsTextViewSwitch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setBackgroundResource(R.drawable.ripple);//水波纹效果的背景

        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.view_settings_switch,this);//将初始化出来的视图应用到这个ViewGroup

        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.SettingsTextViewSwitch);
        mIconId = a.getResourceId(R.styleable.SettingsTextViewSwitch_settingIcon,0);
        mTitleId = a.getResourceId(R.styleable.SettingsTextViewSwitch_settingTitle,0);
        mCaptionId = a.getResourceId(R.styleable.SettingsTextViewSwitch_settingCaption,0);
        a.recycle();
    }
    @Override
    protected void onFinishInflate() {
        ButterKnife.bind(this);
        mImgIcon.setImageResource(mIconId);
        mTvTitle.setText(mTitleId);
        mTvCaption.setText(mCaptionId);
        mToggle.setChecked(isChecked());
        super.setOnClickListener(this);
        super.onFinishInflate();
    }

    public void setOnClickListener(OnClickListener listener){
        this.mOnClickListener = listener;
    }


    private boolean isChecked() {
        return (boolean) SPUtil.get(MyApplication.sContext, Constant.STATUS_TRANSLUCENT,false);
    }

    @Override
    public void onClick(View v) {
        SPUtil.put(MyApplication.sContext,Constant.STATUS_TRANSLUCENT,!isChecked());
        mToggle.setChecked(isChecked());
        refreshTheme();
        if (mOnClickListener != null){
            mOnClickListener.onClick(v);
        }
    }

    @Override
    public void refreshTheme() {
        int color = (Integer) SPUtil.get(MyApplication.sContext,Constant.COLOR_ACCENT,getResources().getColor(R.color.md_pink_A200));
        int noCheckThumbColor = getResources().getColor(R.color.md_grey_600);
        int noCheckTrackColor = getResources().getColor(R.color.md_grey_400);
        int trackColor = ColorPalette.getTransparentColor(color,100);
        mToggle.getThumbDrawable().setColorFilter(isChecked() ? color :noCheckThumbColor ,PorterDuff.Mode.MULTIPLY);//设置拇指按钮颜色
        mToggle.getTrackDrawable().setColorFilter(isChecked() ? trackColor:noCheckTrackColor, PorterDuff.Mode.MULTIPLY);//设置轨迹颜色
    }


}
