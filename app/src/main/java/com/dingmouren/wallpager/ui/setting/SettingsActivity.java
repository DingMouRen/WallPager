package com.dingmouren.wallpager.ui.setting;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.dingmouren.wallpager.Constant;
import com.dingmouren.wallpager.MyApplication;
import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.base.BaseActivity;
import com.dingmouren.wallpager.ui.home.MainActivity;
import com.dingmouren.wallpager.utils.ColorPalette;
import com.dingmouren.wallpager.utils.SPUtil;
import com.dingmouren.wallpager.widget.SettingsBasicTextView;
import com.dingmouren.wallpager.widget.SettingsTextViewSwitch;

import butterknife.BindView;
import yuku.ambilwarna.AmbilWarnaDialog;

/**
 * Created by dingmouren on 2017/5/3.
 */

public class SettingsActivity extends BaseActivity {
    @BindView(R.id.toolbar)Toolbar mToolbar;
    @BindView(R.id.primary_color)  SettingsBasicTextView mPrimatyColorSelect;
    @BindView(R.id.accent_color)  SettingsBasicTextView mAccentColorSelect;
    @BindView(R.id.status_switch) SettingsTextViewSwitch mStatusSwitch;
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
        mPrimatyColorSelect.setOnClickListener((view)->seclectPrimaryColor());
        mAccentColorSelect.setOnClickListener((view)->seclectAccentColor());
        mStatusSwitch.setOnClickListener(v -> updateStatusBarUI());
    }



    /**
     * 选择主色
     */
    private void seclectPrimaryColor() {
        AmbilWarnaDialog dialog = new AmbilWarnaDialog(SettingsActivity.this,
                (Integer) SPUtil.get(MyApplication.sContext, Constant.COLOR_PRIMARY, getResources().getColor(R.color.md_cyan_A200)),
                new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                SPUtil.put(MyApplication.sContext,Constant.COLOR_PRIMARY,color);
                updateUiElements();
            }
        });
        dialog.show();
    }


    /**
     * 选择重点颜色
     */
    private void seclectAccentColor() {
        AmbilWarnaDialog dialog = new AmbilWarnaDialog(SettingsActivity.this,
                (Integer) SPUtil.get(MyApplication.sContext, Constant.COLOR_ACCENT, getResources().getColor(R.color.md_cyan_A200)),
                new AmbilWarnaDialog.OnAmbilWarnaListener() {
                    @Override
                    public void onCancel(AmbilWarnaDialog dialog) {

                    }

                    @Override
                    public void onOk(AmbilWarnaDialog dialog, int color) {
                        SPUtil.put(MyApplication.sContext,Constant.COLOR_ACCENT,color);
                        updateUiElements();
                    }
                });
        dialog.show();
    }

}
