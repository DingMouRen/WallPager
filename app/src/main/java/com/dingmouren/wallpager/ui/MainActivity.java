package com.dingmouren.wallpager.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.base.BaseActivity;
import com.dingmouren.wallpager.ui.channelSort.ChannelManageFragment;
import com.dingmouren.wallpager.ui.home.HomePageFragment;
import com.dingmouren.wallpager.ui.setting.SettingsActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = MainActivity.class.getName();
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.nav_view)
    NavigationView mNavigationView;

    private Fragment[] mFragments;
    private HomePageFragment mHomePageFragment;
    private int mCurrentTabIndex;
    private int mIndex;
    private long mExitTime;

    @Override
    public int requestLayout() {
        return R.layout.activity_main;
    }


    @Override
    public void initView() {
        initFragments();//初始化fragment
        initNav();//初始化侧滑菜单
    }

    /**
     * 初始化fragment
     */
    private void initFragments() {
        mHomePageFragment = HomePageFragment.newInstance();
        ChannelManageFragment channelManageFragment = ChannelManageFragment.newInstance();
        mFragments = new Fragment[]{
                mHomePageFragment,
                channelManageFragment
        };

        //显示HomePageFragment
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame_layout,mHomePageFragment)
                .show(mHomePageFragment)
                .commit();
    }

    /**
     * 初始化侧滑菜单
     */
    private void initNav() {
      mNavigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mDrawerLayout.closeDrawers();
        switch (item.getItemId()){
            case R.id.drawer_home:
                changeFragmentIndex(item,0);
                return true;
            case R.id.drawer_sort:
                changeFragmentIndex(item,1);
                return true;
            case R.id.drawer_favourite:
                return true;
            case R.id.drawer_settings:
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                return true;
        }
        return false;
    }

    /**
     * 切换Fragment下标
     */
    private void changeFragmentIndex(MenuItem item, int index){
        mIndex = index;
        switchFragment();
        item.setChecked(true);
    }

    /**
     * 切换Fragment
     */
    private void switchFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (!mFragments[mIndex].isAdded()){
            ft.add(R.id.frame_layout,mFragments[mIndex]);
        }
        ft.setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .hide(mFragments[mCurrentTabIndex])
                .show(mFragments[mIndex])
                .commit();
        mCurrentTabIndex = mIndex;
    }

    /**
     * 侧滑菜单开关
     */
    public void toggleDrawer(){
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawers();
        }else {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
    }
}
