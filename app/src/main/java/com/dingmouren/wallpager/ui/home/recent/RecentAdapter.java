package com.dingmouren.wallpager.ui.home.recent;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dingmouren.wallpager.MyApplication;
import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.model.GlideImageLoader;
import com.dingmouren.wallpager.model.bean.UnsplashResult;
import com.dingmouren.wallpager.ui.photodetail.PhotoDetailActivity;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dingmouren on 2017/5/2.
 */

public class RecentAdapter extends RecyclerView.Adapter<RecentAdapter.ViewHolder> {
    private static final String TAG = RecentAdapter.class.getName();
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

    public class ViewHolder extends RecyclerView.ViewHolder  {
        CardView container;
        ImageView imgPager;
        RelativeLayout authotInfo;
        CircleImageView authorHeader;
        TextView authorName,authorLocation;
        public ViewHolder(View itemView) {
            super(itemView);
            container = (CardView) itemView.findViewById(R.id.container);
            imgPager = (ImageView) itemView.findViewById(R.id.img_pager);
            authotInfo = (RelativeLayout) itemView.findViewById(R.id.author_info);
            authorHeader = (CircleImageView) itemView.findViewById(R.id.author_header);
            authorName = (TextView) itemView.findViewById(R.id.author_name);
            authorLocation = (TextView) itemView.findViewById(R.id.author_location);
            Log.e(TAG,"下载图片的是否是单例："+mGlideImageLoader.hashCode());
        }

        private void bindData(UnsplashResult bean){
            if (bean != null){
                mGlideImageLoader.loadImage(bean.getUser().getProfile_image().getMedium(),R.drawable.user_icon,authorHeader);
                mGlideImageLoader.loadAutoImage(bean.getUrls().getRegular(),0,imgPager);
                authorName.setText(bean.getUser().getName());
                authorLocation.setText(bean.getUser().getLocation());
            }
            container.setOnClickListener(v -> PhotoDetailActivity.newInstance(container.getContext(),bean ));
        }
    }
}
