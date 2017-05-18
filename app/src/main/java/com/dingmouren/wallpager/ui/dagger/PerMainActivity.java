package com.dingmouren.wallpager.ui.dagger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by dingmouren on 2017/5/11.
 * 自定义作用域
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerMainActivity {
}
