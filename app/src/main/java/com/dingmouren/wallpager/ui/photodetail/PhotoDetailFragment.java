package com.dingmouren.wallpager.ui.photodetail;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.api.Api;
import com.dingmouren.wallpager.base.BaseFragment;
import com.dingmouren.wallpager.model.GlideImageLoader;
import com.dingmouren.wallpager.model.bean.PhotoInfo;
import com.dingmouren.wallpager.model.bean.UnsplashResult;
import com.dingmouren.wallpager.utils.DateUtils;

import javax.inject.Inject;

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
    private UnsplashResult mUnsplashResult;
    private GlideImageLoader mGlideImageLoader;
    private PhotoDetailPresenter mPhotoDetailPresenter;
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
    }

    @Override
    public int requestLayout() {
        return R.layout.fragment_photo_detail;
    }


    @Override
    public void initView() {
        mGlideImageLoader.loadAutoImage(mUnsplashResult.getUrls().getRegular(),0,mPhoto);
        mGlideImageLoader.loadImage(mUnsplashResult.getUser().getProfile_image().getLarge(),0,mAuthorHeader);
        mAuthorName.setText(mUnsplashResult.getUser().getName());
        mCreatedTime.setText("拍摄于 "+ mUnsplashResult.getCreated_at());

    }

    @Override
    public void initListener() {
        mImgArrowBack.setOnClickListener(v -> getActivity().onBackPressed());
    }

    @Override
    public void initData() {
        mPhotoDetailPresenter = new PhotoDetailPresenter(mUnsplashResult.getId(),(PhotoInfoContract.View) this);
        mPhotoDetailPresenter.requestData();
    }

    @Override
    public void setData(PhotoInfo photoInfo) {
        Log.e(TAG,photoInfo.toString());
    }

    @Override
    public void setRefresh(boolean refresh) {

    }
}
