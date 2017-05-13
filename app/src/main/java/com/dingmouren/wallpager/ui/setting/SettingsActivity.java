package com.dingmouren.wallpager.ui.setting;

import android.os.Build;
import android.support.v7.widget.Toolbar;

import com.dingmouren.colorpicker.ColorPickerDialog;
import com.dingmouren.colorpicker.OnColorPickerListener;
import com.dingmouren.wallpager.Constant;
import com.dingmouren.wallpager.MyApplication;
import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.base.BaseActivity;
import com.dingmouren.wallpager.utils.ColorPalette;
import com.dingmouren.wallpager.utils.SPUtil;
import com.dingmouren.wallpager.widget.SettingsBasicTextView;
import com.dingmouren.wallpager.widget.SettingsTextViewSwitch;

import butterknife.BindView;

/**
 * Created by dingmouren on 2017/5/3.
 */

public class SettingsActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.primary_color)
    SettingsBasicTextView mPrimatyColorSelect;
    @BindView(R.id.accent_color)
    SettingsBasicTextView mAccentColorSelect;
    @BindView(R.id.status_switch)
    SettingsTextViewSwitch mStatusSwitch;

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
        mToolbar.setNavigationOnClickListener((view) -> onBackPressed());
        mPrimatyColorSelect.setOnClickListener((view) -> seclectPrimaryColor());
        mAccentColorSelect.setOnClickListener((view) -> seclectAccentColor());
        mStatusSwitch.setOnClickListener(v -> updateStatusBarUI());
    }


    /**
     * 选择主色
     */
    private void seclectPrimaryColor() {

        ColorPickerDialog dialog = new ColorPickerDialog(SettingsActivity.this,
                (Integer) SPUtil.get(MyApplication.sContext, Constant.COLOR_PRIMARY, getResources().getColor(R.color.md_cyan_A200)), new OnColorPickerListener() {
            @Override
            public void onColorCancel(ColorPickerDialog dialog) {

            }

            @Override
            public void onColorChange(ColorPickerDialog dialog, int color) {
                mToolbar.setBackgroundColor(color);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    boolean isTranslucentStatusBar = (boolean) SPUtil.get(MyApplication.sContext,Constant.STATUS_TRANSLUCENT,false);
                    if (isTranslucentStatusBar){
                        getWindow().setStatusBarColor(ColorPalette.getObscuredColor(color));
                    }else {
                        getWindow().setStatusBarColor(color);
                    }
                }
            }

            @Override
            public void onColorConfirm(ColorPickerDialog dialog, int color) {
                SPUtil.put(MyApplication.sContext, Constant.COLOR_PRIMARY, color);
                updateUiElements();
            }
        });
        dialog.show();
    }


    /**
     * 选择重点颜色
     */
    private void seclectAccentColor() {

        ColorPickerDialog dialog = new ColorPickerDialog(SettingsActivity.this,
                (Integer) SPUtil.get(MyApplication.sContext, Constant.COLOR_PRIMARY, getResources().getColor(R.color.md_cyan_A200)), new OnColorPickerListener() {
            @Override
            public void onColorCancel(ColorPickerDialog dialog) {

            }

            @Override
            public void onColorChange(ColorPickerDialog dialog, int color) {
            }

            @Override
            public void onColorConfirm(ColorPickerDialog dialog, int color) {
                SPUtil.put(MyApplication.sContext, Constant.COLOR_ACCENT, color);
                updateUiElements();
            }
        });
        dialog.show();
    }


}
