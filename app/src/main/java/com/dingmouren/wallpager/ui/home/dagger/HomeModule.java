package com.dingmouren.wallpager.ui.home.dagger;

import com.dingmouren.wallpager.model.GlideImageLoader;
import com.dingmouren.wallpager.ui.home.HomeContract;
import com.dingmouren.wallpager.ui.home.HomeFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dingmouren on 2017/5/11.
 */
@Module
public class HomeModule {

    private HomeFragment mHomeFragment;

    public HomeModule(HomeFragment fragment){
        this.mHomeFragment = fragment;
    }

    @Provides
    @PerFragment
    public HomeContract.View provideView(){
        return (HomeContract.View) mHomeFragment;
    }



}
