package com.dingmouren.wallpager.ui.home;

import android.graphics.Color;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.dingmouren.colorpicker.ColorPickerDialog;
import com.dingmouren.wallpager.Constant;
import com.dingmouren.wallpager.MyApplication;
import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.base.BaseFragment;
import com.dingmouren.wallpager.ui.MainActivity;
import com.dingmouren.wallpager.utils.SPUtil;

import butterknife.BindView;
import io.realm.annotations.PrimaryKey;

/**
 * Created by dingmouren on 2017/5/18.
 */

public class HomePageFragment extends BaseFragment {
    private static final String TAG = HomePageFragment.class.getName();

    @BindView(R.id.toolbar)Toolbar mToolbar;
    @BindView(R.id.view_pager) ViewPager mViewPager;
    @BindView(R.id.tab_layout) TabLayout mTabLayout;

    public HomePageAdapter mHomePageAdapter;

    public static HomePageFragment newInstance(){
        return new HomePageFragment();
    }

    @Override
    public void init() {
        mHomePageAdapter = new HomePageAdapter(getFragmentManager());
    }

    @Override
    public int requestLayout() {
        return R.layout.fragment_home_page;
    }

    @Override
    public void initView() {
        initToolbar();
        initTablayout();
    }

    @Override
    public void initListener() {
        mToolbar.setNavigationOnClickListener(v ->  ((MainActivity)getActivity()).toggleDrawer());
    }


    private void initToolbar() {
        mToolbar.setTitle(R.string.app_name);
        mToolbar.setTitleTextColor(Color.WHITE);
        ((MainActivity)getActivity()).setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.img_slide_menu);
    }


    private void initTablayout() {
        mViewPager.setAdapter(mHomePageAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
