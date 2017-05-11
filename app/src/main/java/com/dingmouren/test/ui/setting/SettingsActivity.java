package com.dingmouren.test.ui.setting;

import android.support.v7.widget.Toolbar;

import com.dingmouren.test.Constant;
import com.dingmouren.test.MyApplication;
import com.dingmouren.test.R;
import com.dingmouren.test.base.BaseActivity;
import com.dingmouren.test.utils.SPUtil;
import com.dingmouren.test.widget.SettingsBasicTextView;
import com.dingmouren.test.widget.SettingsTextViewSwitch;

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
