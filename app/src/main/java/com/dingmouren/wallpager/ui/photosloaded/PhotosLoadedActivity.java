package com.dingmouren.wallpager.ui.photosloaded;

import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.dingmouren.wallpager.MyApplication;
import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.base.BaseActivity;
import com.dingmouren.wallpager.service.PhotoLoadService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.DeflaterOutputStream;

import butterknife.BindView;

/**
 * Created by dingmouren on 2017/5/23.
 */

public class PhotosLoadedActivity extends BaseActivity {
    private static final String TAG = PhotosLoadedActivity.class.getName();
    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.recycler)  RecyclerView mRecyclerView;
    @BindView(R.id.fab)  FloatingActionButton mFab;
    @BindView(R.id.empty_photo_loaded) RelativeLayout mEmptyView;
    private PhotoLoadedAdapter mPhotoLoadedAdapter;



    @Override
    public int requestLayout() {
        return R.layout.activity_photos_loaded;
    }

    @Override
    public void initView() {
        mToolbar.setTitle("已下载");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public void initListener() {
        mToolbar.setNavigationOnClickListener(v -> onBackPressed());
        mFab.setOnClickListener(v ->deleteSelectedPhotos() );
    }

    @Override
    public void initData() {
        mPhotoLoadedAdapter = new PhotoLoadedAdapter();
        if (getPhotosPath() == null || getPhotosPath().size() == 0){
            mEmptyView.setVisibility(View.VISIBLE);
        }else {
            mEmptyView.setVisibility(View.INVISIBLE);
            mPhotoLoadedAdapter.setList(getPhotosPath());
        }

        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mPhotoLoadedAdapter);
    }

    /**
     * 获取下载过的图片的路径
     * @return
     */
    private List<String> getPhotosPath(){
        List<String> list = new ArrayList<>();
        list.clear();
        File fileDir = new File(Environment.getExternalStorageDirectory(),"WallPager");
        if (!fileDir.exists()) {
            Toast.makeText(MyApplication.sContext,"还没有下载过图片哦",Toast.LENGTH_SHORT).show();
            return null;
        }
        File[] files = fileDir.listFiles();
        for(File file : files){
            list.add(file.getAbsolutePath());
        }
        Log.e(TAG,list.toString());
        return list;
    }

    /**
     * 删除选中的图片
     */
    private void deleteSelectedPhotos(){
        mPhotoLoadedAdapter.deleteSelectedPhotos();
        if (mPhotoLoadedAdapter.getItemCount() == 0){
            mEmptyView.setVisibility(View.VISIBLE);
        }else {
            mEmptyView.setVisibility(View.INVISIBLE);
        }
    }

}
