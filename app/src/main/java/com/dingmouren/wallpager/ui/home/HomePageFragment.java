package com.dingmouren.wallpager.ui.home;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.dingmouren.colorpicker.ColorPickerDialog;
import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.base.BaseFragment;
import com.dingmouren.wallpager.ui.MainActivity;

import butterknife.BindView;

/**
 * Created by dingmouren on 2017/5/18.
 */

public class HomePageFragment extends BaseFragment {

    @BindView(R.id.toolbar)Toolbar mToolbar;
    @BindView(R.id.view_pager) ViewPager mViewPager;
    @BindView(R.id.tab_layout) TabLayout mTabLayout;

    public static HomePageFragment newInstance(){
        return new HomePageFragment();
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


    private void initToolbar() {
        mToolbar.setTitle(R.string.home_title);
        mToolbar.setTitleTextColor(Color.WHITE);
        ((MainActivity)getActivity()).setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.img_slide_menu);
    }


    private void initTablayout() {
//        mTabLayout.addTab(mTabLayout.newTab().setText("新作"));
        HomePageAdapter homePageAdapter = new HomePageAdapter(getFragmentManager());
        mViewPager.setAdapter(homePageAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void initListener() {
        mToolbar.setNavigationOnClickListener(v ->  ((MainActivity)getActivity()).toggleDrawer());
    }
}
