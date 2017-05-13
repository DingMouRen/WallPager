package com.dingmouren.wallpager.ui.home;

import com.dingmouren.wallpager.ApplicationComponent;
import com.dingmouren.wallpager.dagger.scope.PerFragment;

import dagger.Component;

/**
 * Created by dingmouren on 2017/5/11.
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class,modules = HomeModule.class)
public interface HomeComponent {
    void inject(HomeFragment fragment);
    HomePresenter getHomePresenter();
}
