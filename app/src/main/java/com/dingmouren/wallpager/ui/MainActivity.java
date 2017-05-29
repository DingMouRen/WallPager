package com.dingmouren.wallpager.ui;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.transition.ChangeImageTransform;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.base.BaseActivity;
import com.dingmouren.wallpager.ui.about.AboutActivity;
import com.dingmouren.wallpager.ui.channelSort_unuse.ChannelManageFragment;
import com.dingmouren.wallpager.ui.home.HomePageFragment;
import com.dingmouren.wallpager.ui.photosloaded.PhotosLoadedActivity;
import com.dingmouren.wallpager.ui.setting.SettingsActivity;
import com.dingmouren.wallpager.utils.GlideHelper;
import com.jiongbull.jlog.BuildConfig;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener,DrawerLayout.DrawerListener {
    private static final String TAG = MainActivity.class.getName();
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.nav_view)
    NavigationView mNavigationView;

    private Fragment[] mFragments;
    private HomePageFragment mHomePageFragment;
    private int mCurrentTabIndex;
    private int mIndex;
    private int mDrawerSelectedItem = -1;//记录侧滑菜单选中条目，是重新开启新Activity
    private long exitTime;

    @Override
    public void init() {
        if (Build.VERSION.SDK_INT >= 21){
            getWindow().setEnterTransition(new Fade());
        }
    }

    @Override
    public int requestLayout() {
        return R.layout.activity_main;
    }


    @Override
    public void initView() {
        initFragments();//初始化fragment
        initNav();//初始化侧滑菜单
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setSharedElementExitTransition(new ChangeImageTransform());
            getWindow().setSharedElementReenterTransition(new ChangeImageTransform());
        }
    }

    @Override
    public void initListener() {
        mDrawerLayout.setDrawerListener(this);
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
        switch (item.getItemId()){
            case R.id.drawer_home:
                changeFragmentIndex(item,0);
                return true;
//            case R.id.drawer_sort:
//                changeFragmentIndex(item,1);
//                break;
            case R.id.drawer_invoke_system:
                mDrawerSelectedItem = 102;
                break;
            case R.id.drawer_photos_loaded:
                mDrawerSelectedItem = 101;
                break;
            case R.id.drawer_settings:
                mDrawerSelectedItem = 110;
                break;
            case R.id.drawer_about:
                mDrawerSelectedItem = 103;
                break;
        }
        mDrawerLayout.closeDrawers();
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

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {

    }

    @Override
    public void onDrawerOpened(View drawerView) {

    }

    @Override
    public void onDrawerClosed(View drawerView) {
        switch (mDrawerSelectedItem){
            case 101://图片已下载
                startActivity(new Intent(MainActivity.this,PhotosLoadedActivity.class));
                mDrawerSelectedItem = -1;
                break;
            case 102:
                Intent intent = new Intent(Intent.ACTION_SET_WALLPAPER);
                startActivity(Intent.createChooser(intent,"选择壁纸"));
                mDrawerSelectedItem = -1;
                break;
            case 103:
                startActivity(new Intent(MainActivity.this,AboutActivity.class));
                mDrawerSelectedItem = -1;
                break;
            case 110://设置
                startActivity(new Intent(MainActivity.this,SettingsActivity.class));
                mDrawerSelectedItem = -1;
                break;
        }
    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
