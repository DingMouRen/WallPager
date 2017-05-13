package com.dingmouren.wallpager.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.base.BaseActivity;
import com.dingmouren.wallpager.ui.home.HomeFragment;
import com.dingmouren.wallpager.ui.setting.SettingsActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)  Toolbar mToolbar;
    @BindView(R.id.drawer_layout) DrawerLayout mDrawerLayout;
    @BindView(R.id.nav_view) NavigationView mNavigationView;
    @BindView(R.id.coordinator)  CoordinatorLayout mCoordinatorLayout;


    private FragmentManager mFragmentManager;
    private ActionBarDrawerToggle mDrawerToggle;
    private boolean mOpenSettings = false;

    @Override
    public void init() {
        mFragmentManager = getSupportFragmentManager();
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
                    break;
                case R.id.drawer_favourite:

                    break;
                case R.id.drawer_settings:
                    mOpenSettings = true;
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
            if (mOpenSettings){
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                mOpenSettings = false;
            }
        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };

}
