package com.dingmouren.test.ui.home;

import com.dingmouren.test.ApplicationComponent;
import com.dingmouren.test.dagger.scope.PerFragment;

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
