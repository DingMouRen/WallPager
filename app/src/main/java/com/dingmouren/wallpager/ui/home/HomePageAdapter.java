package com.dingmouren.wallpager.ui.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.dingmouren.wallpager.Constant;
import com.dingmouren.wallpager.base.BaseFragment;
import com.dingmouren.wallpager.model.dao.Channel;
import com.dingmouren.wallpager.ui.home.recent.RecentFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by dingmouren on 2017/5/18.
 */

public class HomePageAdapter extends FragmentStatePagerAdapter {
    private static final String TAG = HomePageAdapter.class.getName();
    private List<Channel> mChannelList = new ArrayList<>();
    private List<RecentFragment> mFragments = new ArrayList<>();

    public HomePageAdapter(FragmentManager fm) {
        super(fm);
        init();
    }

    public void init() {
        for (int i = 0; i < Constant.DEFAULT_CHANNELS.length; i++) {
            Channel channel = new Channel();
            channel.setName(Constant.DEFAULT_CHANNELS[i]);
            channel.setId(i + 101);
            mChannelList.add(channel);
        }
        mFragments.clear();
        for (int i = 0; i < mChannelList.size(); i++) {
            mFragments.add(RecentFragment.newInstance(mChannelList.get(i).getId()));
        }
    }

    @Override
    public Fragment getItem(int position) {

        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mChannelList.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return mChannelList.get(position).getName();
    }
}
