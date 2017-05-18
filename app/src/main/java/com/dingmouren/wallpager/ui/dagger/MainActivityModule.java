package com.dingmouren.wallpager.ui.dagger;

import com.dingmouren.wallpager.ui.home.recent.RecentFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dingmouren on 2017/5/11.
 */
@Module
public class MainActivityModule {

    private RecentFragment mHomeFragment;

    public MainActivityModule(RecentFragment fragment){
        this.mHomeFragment = fragment;
    }


    @Provides
    @PerMainActivity
    public RecentFragment provideRecentFragment(){
        return  mHomeFragment;
    }


}
