package com.dingmouren.test.ui.home;

import com.dingmouren.test.dagger.scope.PerFragment;

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
