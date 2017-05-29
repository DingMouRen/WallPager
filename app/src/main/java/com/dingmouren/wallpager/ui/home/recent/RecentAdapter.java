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

import com.bumptech.glide.Glide;
import com.dingmouren.wallpager.MyApplication;
import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.model.bean.UnsplashResult;
import com.dingmouren.wallpager.ui.MainActivity;
import com.dingmouren.wallpager.ui.photodetail.PhotoDetailActivity;
import com.dingmouren.wallpager.utils.GlideHelper;

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
        public ViewHolder(View itemView) {
            super(itemView);
            container = (CardView) itemView.findViewById(R.id.container);
            imgPager = (ImageView) itemView.findViewById(R.id.img_pager);
            authotInfo = (RelativeLayout) itemView.findViewById(R.id.author_info);
            authorHeader = (CircleImageView) itemView.findViewById(R.id.author_header);
            authorName = (TextView) itemView.findViewById(R.id.author_name);
            authorLocation = (TextView) itemView.findViewById(R.id.author_location);
            initListener();
        }


        private void initListener() {
            ViewTreeObserver viewTreeObserver = container.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    if (imgPager.getMeasuredHeight() > 300){
                        authotInfo.setVisibility(View.VISIBLE);
                    }
                }
            });
        }

        private void bindData(UnsplashResult bean){
            if (imgPager.getMeasuredHeight() <300){
                authotInfo.setVisibility(View.INVISIBLE);
            }else {
                authotInfo.setVisibility(View.VISIBLE);
            }
            if (imgPager.getDrawable() != null){
                imgPager.setImageBitmap(null);
                imgPager.refreshDrawableState();
            }

            if (bean != null){
                GlideHelper.loadImgSample(mActivity,bean.getUser().getProfile_image().getMedium(), R.drawable.user_icon,0, authorHeader);
                GlideHelper.loadImgAutoHeight(mActivity,bean.getUrls().getRegular(),R.drawable.imgtest,0, imgPager);
                imgPager.setTag(bean.getUrls().getRegular());
                authorName.setText(bean.getUser().getName());
                authorLocation.setText(bean.getUser().getLocation());
            }
            container.setOnClickListener(v -> PhotoDetailActivity.newInstance(mActivity,bean,v ));
        }

    }
}
