package com.dingmouren.wallpager.ui.photodetail;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.dingmouren.wallpager.Constant;
import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.base.BaseFragment;
import com.dingmouren.wallpager.event.LoadPhotoEvent;
import com.dingmouren.wallpager.model.GlideImageLoader;
import com.dingmouren.wallpager.model.bean.PhotoInfo;
import com.dingmouren.wallpager.model.bean.UnsplashResult;
import com.dingmouren.wallpager.service.PhotoLoadService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;

/**
 * Created by dingmouren on 2017/5/20.
 */

public class PhotoDetailFragment extends BaseFragment implements PhotoInfoContract.View{
    private static final String TAG = PhotoDetailFragment.class.getName();
    private static final String UNSPLASH_RESULT = "unsplash_result";

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
    private UnsplashResult mUnsplashResult;
    private GlideImageLoader mGlideImageLoader;
    private PhotoDetailPresenter mPhotoDetailPresenter;
    private LoadPhotoNotification mLoadPhotoNotification;
    public static PhotoDetailFragment newInstance(UnsplashResult unsplashResult){
        PhotoDetailFragment fragment = new PhotoDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(UNSPLASH_RESULT,unsplashResult);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void init() {
        mGlideImageLoader = new GlideImageLoader();
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
        mGlideImageLoader.loadAutoImage(mUnsplashResult.getUrls().getRegular(),0,mPhoto);
        mGlideImageLoader.loadImage(mUnsplashResult.getUser().getProfile_image().getSmall(),0,mAuthorHeader);
        mAuthorName.setText(mUnsplashResult.getUser().getName());
        mCreatedTime.setText("拍摄于 "+ mUnsplashResult.getCreated_at());
    }

    @Override
    public void initListener() {
        mImgArrowBack.setOnClickListener(v -> getActivity().onBackPressed());
        mTvLoadPhoto.setOnClickListener(v -> {
            getActivity().startService(PhotoLoadService.newIntent(getContext(),mUnsplashResult.getUrls().getRaw(),mUnsplashResult.getId()));
        });
    }

    @Override
    public void initData() {
        mPhotoDetailPresenter = new PhotoDetailPresenter(mUnsplashResult.getId(),(PhotoInfoContract.View) this);
        mPhotoDetailPresenter.requestData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void setData(PhotoInfo photoInfo) {
       showPhotoAttr(photoInfo);
    }

    /**
     * 显示照片属性
     * @param photoInfo
     */
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

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void updateLoadProgress(LoadPhotoEvent event){

        if (event == null) return;
        if (mLoadPhotoNotification == null){
            mLoadPhotoNotification = new LoadPhotoNotification();
            Snackbar.make(mPhoto,R.string.load_photo_start,Snackbar.LENGTH_SHORT).show();
        }
        int progress = event.getProgress();
        if (progress >= 99){
            mLoadPhotoNotification.clearNotification();
            Snackbar.make(mPhoto,R.string.load_photo_complete,Snackbar.LENGTH_SHORT).show();
        }else {
            mLoadPhotoNotification.updateProgress(event.getProgress());
        }

    }

}
