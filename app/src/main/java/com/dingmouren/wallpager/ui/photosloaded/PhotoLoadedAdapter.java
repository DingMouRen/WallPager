package com.dingmouren.wallpager.ui.photosloaded;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dingmouren.wallpager.MyApplication;
import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.utils.DensityUtils;
import com.dingmouren.wallpager.utils.ScreenUtils;

import org.androidannotations.holder.HasOnActivityResult;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dingmouren on 2017/5/24.
 */

public class PhotoLoadedAdapter extends RecyclerView.Adapter<PhotoLoadedAdapter.ViewHolder> {
    private static final String TAG = PhotoLoadedAdapter.class.getName();
    private List<String> mList;
    public Map<Integer,String> mMapDelete = new HashMap<>();
    public void setList(List<String> list) {
        this.mList = list;
    }


    public List<String> getList() {
        return mList;
    }

    public Map<Integer, String> getMapDelete() {
        return mMapDelete;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo_loaded,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(mList.get(position));
        holder.itemLayout.setOnClickListener(v -> {
            if (holder.checkBox.getVisibility() == View.INVISIBLE){
                holder.checkBox.setChecked(true);
                holder.checkBox.setVisibility(View.VISIBLE);
                mMapDelete.put(position,mList.get(position));
            }else {
                holder.checkBox.setChecked(false);
                holder.checkBox.setVisibility(View.INVISIBLE);
                mMapDelete.remove(position);
            }
        });
    }

    public void deleteSelectedPhotos(){
        if (mMapDelete.size() == 0){
            Toast.makeText(MyApplication.sContext,"请选择要删除的图片",Toast.LENGTH_SHORT).show();
            return;
        }
        for (Map.Entry<Integer,String> entry : mMapDelete.entrySet()){
            File file = new File(entry.getValue());
            if (file.exists()){
                file.delete();
                mList.remove(entry.getValue());
            }

        }
        setList(mList);
        notifyDataSetChanged();
        Toast.makeText(MyApplication.sContext,"图片删除成功",Toast.LENGTH_SHORT).show();
        mMapDelete.clear();
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 :mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        RelativeLayout itemLayout;
        CheckBox checkBox;
        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
            itemLayout = (RelativeLayout) itemView.findViewById(R.id.item_layout);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        }


        public void bindData(String photoPath){
            checkBox.setVisibility(View.INVISIBLE);
            if (photoPath != null && !photoPath.equals("")){
                try {
                    Glide.with(MyApplication.sContext).load(photoPath).crossFade().override(200,200).diskCacheStrategy(DiskCacheStrategy.NONE).into(img);
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e(TAG,e.getMessage());
                }
            }
        }
    }

}
