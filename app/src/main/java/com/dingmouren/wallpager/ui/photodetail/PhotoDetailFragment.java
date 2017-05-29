package com.dingmouren.wallpager.ui.photodetail;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.dingmouren.wallpager.MyApplication;
import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.base.BaseFragment;
import com.dingmouren.wallpager.event.LoadPhotoEvent;
import com.dingmouren.wallpager.model.bean.PhotoInfo;
import com.dingmouren.wallpager.model.bean.UnsplashResult;
import com.dingmouren.wallpager.service.PhotoLoadService;
import com.dingmouren.wallpager.utils.DateUtils;
import com.dingmouren.wallpager.utils.GlideHelper;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.Date;

import butterknife.BindView;

/**
 * Created by dingmouren on 2017/5/20.
 */

public class PhotoDetailFragment extends BaseFragment implements PhotoInfoContract.View{
    private static final String TAG = PhotoDetailFragment.class.getName();
    private static final String UNSPLASH_RESULT = "unsplash_result";
    @BindView(R.id.container) CoordinatorLayout mContanier;
    @BindView(R.id.img_photo) ImageView mPhoto;
    @BindView(R.id.img_arrow_back) ImageView mImgArrowBack;
    @BindView(R.id.img_author_header) ImageView mAuthorHeader;
    @BindView(R.id.tv_author) TextView mAuthorName;
    @BindView(R.id.tv_time) TextView mCreatedTime;
    @BindView(R.id.tv_load_photo) TextView mTvLoadPhoto;
    @BindView(R.id.tv_share) TextView mTvShare;
    @BindView(R.id.tv_set_phone_page) TextView mTvSetPhotoPage;
    @BindView(R.id.tv_attr_size) TextView mTvPhotoSize;
    @BindView(R.id.tv_attr_exposure) TextView mTvPhotoExposure;//快门
    @BindView(R.id.tv_attr_aperture) TextView mTvPhotoAperture;//光圈
    @BindView(R.id.tv_attr_focal) TextView mTvPhotoFocal;//焦距
    @BindView(R.id.tv_attr_model) TextView mTvPhotoModel;//器材
    @BindView(R.id.tv_attr_iso) TextView mTvPhotoIso;//曝光
    @BindView(R.id.progressbar)  ProgressBar mProgressBar;
    private UnsplashResult mUnsplashResult;
    private PhotoDetailPresenter mPhotoDetailPresenter;
    private MaterialDialog mMaterialDialog;
    public static PhotoDetailFragment newInstance(UnsplashResult unsplashResult){
        PhotoDetailFragment fragment = new PhotoDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(UNSPLASH_RESULT,unsplashResult);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void init() {
        mMaterialDialog = new MaterialDialog.Builder(getActivity()).build();
        mMaterialDialog.setCancelable(true);
        mMaterialDialog.setContent("正在为您的手机设置壁纸\n客官请骚等...");
        if (getArguments() != null){
            mUnsplashResult = (UnsplashResult) getArguments().getSerializable(UNSPLASH_RESULT);
        }
        EventBus.getDefault().register(this);
    }

    @Override
    public int requestLayout() {
        return R.layout.fragment_photo_detail;
    }


    @Override
    public void initView() {
        GlideHelper.loadImgAutoHeight(getContext(),mUnsplashResult.getUrls().getRegular(),0,0,mPhoto);
        GlideHelper.loadImgSample(getContext(),mUnsplashResult.getUser().getProfile_image().getLarge(),0,0,mAuthorHeader);
        mAuthorName.setText(mUnsplashResult.getUser().getName());
        mCreatedTime.setText("拍摄于 "+ mUnsplashResult.getCreated_at().split("T")[0]);
    }

    @Override
    public void initListener() {
        mImgArrowBack.setOnClickListener(v -> getActivity().finish());
        mTvLoadPhoto.setOnClickListener(v -> {
            Toast.makeText(MyApplication.sContext, "图片后台下载中...", Toast.LENGTH_SHORT).show();
            getActivity().startService(PhotoLoadService.newIntent(getContext(),mUnsplashResult.getUrls().getRaw(),mUnsplashResult.getId()));
        });
        mTvSetPhotoPage.setOnClickListener(v -> {//设置为壁纸
           mPhotoDetailPresenter.setWallPager();
        });

        mTvShare.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, "http://a.app.qq.com/o/simple.jsp?pkgname=com.dingmouren.wallpager");
            intent.setType("text/plain");
            startActivity(Intent.createChooser(intent, "分享下载链接到"));
        });
    }

    @Override
    public void initData() {
        mPhotoDetailPresenter = new PhotoDetailPresenter(mUnsplashResult.getId(),(PhotoInfoContract.View) this,mUnsplashResult.getUrls().getRaw());
        mPhotoDetailPresenter.requestData();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        if (mContanier != null){
            mContanier.removeAllViews();
            mContanier = null;
        }
    }

    @Override
    public void setData(PhotoInfo photoInfo) {
       showPhotoAttr(photoInfo);
    }



    @Override
    public void setWallPagerSuccess() {
        Toast.makeText(MyApplication.sContext,"手机壁纸设置成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setWallPagerFail() {
        Toast.makeText(MyApplication.sContext,"手机壁纸设置失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDialog() {
        mMaterialDialog.show();
    }

    @Override
    public void dismissDialog() {
        mMaterialDialog.dismiss();
    }

    /**
     * 显示照片属性
     * @param photoInfo
     */
    @SuppressLint("SetTextI18n")
    private void showPhotoAttr(PhotoInfo photoInfo) {
        mTvPhotoSize.setText("分辨率 : "+photoInfo.getWidth()+" / "+ photoInfo.getHeight());
        mTvPhotoExposure.setText("快门 : "+(photoInfo.getExif().getExposure_time() == null ? "未知":photoInfo.getExif().getExposure_time()));
        mTvPhotoAperture.setText("光圈 : "+(photoInfo.getExif().getAperture() == null ? "未知":photoInfo.getExif().getAperture()));
        mTvPhotoFocal.setText("焦距 : "+ (photoInfo.getExif().getFocal_length() == null ? "未知" : photoInfo.getExif().getFocal_length()));
        mTvPhotoModel.setText("器材 : " + (photoInfo.getExif().getModel() == null ? "未知" :photoInfo.getExif().getModel()) );
        mTvPhotoIso.setText("曝光 : "+(photoInfo.getExif().getIso() == 0 ? "未知":photoInfo.getExif().getIso()));
    }


    @Override
    public void setRefresh(boolean refresh) {

    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void updateLoadProgress(LoadPhotoEvent event) {
        if (event != null && event.getPhotoId().equals("exist")){
            Toast.makeText(MyApplication.sContext, "图片已下载", Toast.LENGTH_SHORT).show();
            return;
        }
        if (event == null || !event.getPhotoId().equals(mUnsplashResult.getId())) return;
        mProgressBar.animate()
                .alpha(1)
                .setDuration(300)
                .start();
        mProgressBar.setProgress(event.getProgress());
        if (event.getProgress() == 100) {
            mProgressBar.animate()
                    .alpha(0)
                    .setDuration(800)
                    .start();
            Toast.makeText(MyApplication.sContext, event.getPhotoId() + ".jpg下载到你的相册里咯", Toast.LENGTH_SHORT).show();
        }
    }
}
