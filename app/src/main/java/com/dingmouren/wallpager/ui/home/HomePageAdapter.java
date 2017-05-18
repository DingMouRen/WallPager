package com.dingmouren.wallpager.ui.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.dingmouren.wallpager.ui.home.recent.RecentFragment;

/**
 * Created by dingmouren on 2017/5/18.
 */

public class HomePageAdapter extends FragmentPagerAdapter {

    private String[] channelStr = new String[]{"新作","精选","建筑","饮食","自然","物品","人物","科技"};
    public HomePageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return RecentFragment.newInstance(101);
            case 1:
                return RecentFragment.newInstance(102);
            case 2:
                return RecentFragment.newInstance(103);
            case 3:
                return RecentFragment.newInstance(104);
            case 4:
                return RecentFragment.newInstance(105);
            case 5:
                return RecentFragment.newInstance(106);
            case 6:
                return RecentFragment.newInstance(107);
            case 7:
                return RecentFragment.newInstance(108);

        }
        return null;
    }

    @Override
    public int getCount() {
        return channelStr.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return channelStr[position];
    }
}
