package com.dingmouren.wallpager.ui.home.recent;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dingmouren.wallpager.MyApplication;
import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.model.GlideImageLoader;
import com.dingmouren.wallpager.model.bean.UnsplashResult;
import com.dingmouren.wallpager.ui.MainActivity;
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
    private Activity mActivity;

    public RecentAdapter(Activity activity) {
        this.mActivity = activity;
    }

    public void setList(List<UnsplashResult> list){
        mList.addAll(list);
    }

    public int getListOldSize() {
        return mList.size();
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

    public class ViewHolder extends RecyclerView.ViewHolder   {
        CardView container;
        ImageView imgPager;
        RelativeLayout authotInfo;
        CircleImageView authorHeader;
        TextView authorName,authorLocation;
        RelativeLayout rela_author_info;
        public ViewHolder(View itemView) {
            super(itemView);
            container = (CardView) itemView.findViewById(R.id.container);
            imgPager = (ImageView) itemView.findViewById(R.id.img_pager);
            authotInfo = (RelativeLayout) itemView.findViewById(R.id.author_info);
            authorHeader = (CircleImageView) itemView.findViewById(R.id.author_header);
            authorName = (TextView) itemView.findViewById(R.id.author_name);
            authorLocation = (TextView) itemView.findViewById(R.id.author_location);
            rela_author_info = (RelativeLayout) itemView.findViewById(R.id.rela_author_info);
            initView();
            initListener();
        }

        private void initView() {
            rela_author_info.setVisibility(View.INVISIBLE);
        }

        private void initListener() {
            ViewTreeObserver viewTreeObserver = container.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    if (imgPager.getMeasuredHeight() > 0){
                        rela_author_info.setVisibility(View.VISIBLE);
                    }
                }
            });
        }

        private void bindData(UnsplashResult bean){
            imgPager.refreshDrawableState();//清空之前的图片缓存
            if (bean != null){
                GlideImageLoader.loadImage(bean.getUser().getProfile_image().getMedium(),R.drawable.user_icon,authorHeader);
                GlideImageLoader.loadAutoImage(bean.getUrls().getRegular(),0,imgPager);
                authorName.setText(bean.getUser().getName());
                authorLocation.setText(bean.getUser().getLocation());
            }
            container.setOnClickListener(v -> PhotoDetailActivity.newInstance(mActivity,bean,v ));
        }

    }
}
