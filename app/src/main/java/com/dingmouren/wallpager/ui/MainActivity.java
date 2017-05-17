package com.dingmouren.wallpager.ui;

import android.content.Intent;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.base.BaseActivity;
import com.dingmouren.wallpager.ui.channelSort.ChannelManageFragment;
import com.dingmouren.wallpager.ui.home.HomeFragment;
import com.dingmouren.wallpager.ui.setting.SettingsActivity;
import com.dingmouren.wallpager.utils.ScreenUtils;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getName();
    @BindView(R.id.toolbar)  Toolbar mToolbar;
    @BindView(R.id.drawer_layout) DrawerLayout mDrawerLayout;
    @BindView(R.id.nav_view) NavigationView mNavigationView;
    @BindView(R.id.coordinator)  CoordinatorLayout mCoordinatorLayout;
    @BindView(R.id.fab)  FloatingActionButton mFab;


    private FragmentManager mFragmentManager;
    private ActionBarDrawerToggle mDrawerToggle;
    private int mItemIsChecked ;
    private HomeFragment mHomeFragment;
    private ChannelManageFragment mChannelManageFragment;

    @Override
    public void init() {
        mFragmentManager = getSupportFragmentManager();
        mHomeFragment = new HomeFragment();
        mChannelManageFragment = new ChannelManageFragment();
        Log.e(TAG, ScreenUtils.getStatusHeight(this)+"");
    }

    @Override
    public int requestLayout() {
        return R.layout.activity_main;
    }


    @Override
    public void initView() {
        mToolbar.setTitle(getString(R.string.home_title));
        setSupportActionBar(mToolbar);
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,mToolbar,R.string.drawer_open,R.string.drawer_close);
        mDrawerToggle.syncState();//将抽屉和toolbar实现联动
        mFragmentManager.beginTransaction().add(R.id.frame_layout,new HomeFragment()).commit();
    }

    @Override
    public void initListener() {
        mNavigationView.setNavigationItemSelectedListener(mOnNavItemSelectedListener);
        mDrawerLayout.addDrawerListener(mDrawerListener);
    }


    /**
     * 抽屉布局中条目选中监听
     */
    private NavigationView.OnNavigationItemSelectedListener mOnNavItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.drawer_home:
                    mItemIsChecked = 0;
                    break;
                case R.id.drawer_sort:
                    mItemIsChecked = 1;
                    break;
                case R.id.drawer_favourite:
                    mItemIsChecked = 2;
                    break;
                case R.id.drawer_settings:
                    mItemIsChecked = 3;
                    break;
            }
            item.setChecked(true);
            mDrawerLayout.closeDrawers();
            return true;
        }
    };

    /**
     * Drawerlayout的状态监听
     */
    private DrawerLayout.DrawerListener mDrawerListener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {

        }

        @Override
        public void onDrawerOpened(View drawerView) {

        }

        @Override
        public void onDrawerClosed(View drawerView) {
            switch (mItemIsChecked){
                case 0:
                    mToolbar.setTitle(getString(R.string.home_title));
                    FragmentTransaction ft0 =  mFragmentManager.beginTransaction();
                    ft0.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft0.replace(R.id.frame_layout,mHomeFragment).commit();
                    mFab.animate().alpha(1).setDuration(800).start();
                    break;
                case 1:
                   mToolbar.setTitle(getResources().getString(R.string.sort_title));
                    FragmentTransaction ft1 =  mFragmentManager.beginTransaction();
                    ft1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft1.replace(R.id.frame_layout,mChannelManageFragment).commit();
                    mFab.animate().alpha(0).setDuration(800).start();
                    break;
                case 2:
                    break;
                case 3:
                    startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                    break;
            }
        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };

}
