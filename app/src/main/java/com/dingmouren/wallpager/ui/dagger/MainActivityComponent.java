package com.dingmouren.wallpager.ui.dagger;

import com.dingmouren.wallpager.ApplicationComponent;
import com.dingmouren.wallpager.ui.home.recent.RecentFragment;
import com.dingmouren.wallpager.ui.home.recent.RecentPresenter;

import dagger.Component;

/**
 * Created by dingmouren on 2017/5/11.
 */
@PerMainActivity
@Component(dependencies = ApplicationComponent.class,modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(RecentFragment fragment);
    RecentPresenter getRecentPresenter();
}
