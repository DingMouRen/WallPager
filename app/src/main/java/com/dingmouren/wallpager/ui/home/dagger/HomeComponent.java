package com.dingmouren.wallpager.ui.home.dagger;

import com.dingmouren.wallpager.ApplicationComponent;
import com.dingmouren.wallpager.model.GlideImageLoader;
import com.dingmouren.wallpager.ui.home.HomeFragment;
import com.dingmouren.wallpager.ui.home.HomePresenter;

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
