package com.dingmouren.wallpager.ui.photodetail;

import com.dingmouren.wallpager.base.BasePresenter;
import com.dingmouren.wallpager.base.BaseView;
import com.dingmouren.wallpager.model.bean.PhotoInfo;
import com.dingmouren.wallpager.model.bean.UnsplashResult;

import java.util.List;

/**
 * Created by dingmouren on 2017/5/20.
 */

public interface PhotoInfoContract {

    interface View extends BaseView{
        void setData(PhotoInfo photoInfo);
        void setWallPagerSuccess();
        void setWallPagerFail();
        void showDialog();
        void dismissDialog();
    }

    interface Presenter extends BasePresenter{
        void setWallPager();
    }
}
