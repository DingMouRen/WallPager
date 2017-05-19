package com.dingmouren.wallpager.ui.home.recent;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.dingmouren.wallpager.MyApplication;
import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.model.GlideImageLoader;
import com.dingmouren.wallpager.model.bean.UnsplashResult;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dingmouren on 2017/5/2.
 */

public class RecentAdapter extends RecyclerView.Adapter<RecentAdapter.ViewHolder> {

    private List<UnsplashResult> mList = new LinkedList<>();
    private GlideImageLoader mGlideImageLoader;

    @Inject
    public RecentAdapter(GlideImageLoader glideImageLoader) {
        this.mGlideImageLoader = glideImageLoader;
    }

    public void setList(List<UnsplashResult> list){
        mList.addAll(0,list);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(MyApplication.sContext).inflate(R.layout.item_home,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(mList.get(position));

    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPager;
        RelativeLayout authotInfo;
        CircleImageView authorHeader;
        TextView authorName,authorLocation;
        public ViewHolder(View itemView) {
            super(itemView);
            imgPager = (ImageView) itemView.findViewById(R.id.img_pager);
            authotInfo = (RelativeLayout) itemView.findViewById(R.id.author_info);
            authorHeader = (CircleImageView) itemView.findViewById(R.id.author_header);
            authorName = (TextView) itemView.findViewById(R.id.author_name);
            authorLocation = (TextView) itemView.findViewById(R.id.author_location);
        }

        private void bindData(UnsplashResult bean){
            if (bean != null){
                mGlideImageLoader.loadImage(bean.getUser().getProfile_image().getMedium(),R.drawable.user_icon,authorHeader);
                mGlideImageLoader.loadAutoImage(bean.getUrls().getRegular(),R.mipmap.photo_hodler,imgPager);
                authorName.setText(bean.getUser().getName());
                authorLocation.setText(bean.getUser().getLocation());
            }
        }
    }
}
