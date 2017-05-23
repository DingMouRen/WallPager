package com.dingmouren.wallpager.ui.channelSort_unuse;

import android.graphics.Color;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.interfaces.ChannelAdapterDragListener;
import com.dingmouren.wallpager.interfaces.ChannelItemSateListener;
import com.dingmouren.wallpager.interfaces.ChannelTouchListener;
import com.dingmouren.wallpager.model.dao.Channel;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingmouren on 2017/5/16.
 */

public class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.ViewHolder> implements ChannelAdapterDragListener{
    private static final String TAG = ChannelAdapter.class.getName();
    private List<Channel> mList = new LinkedList<>();//增删快
    private ChannelTouchListener mTouchListener;

    public ChannelAdapter(ChannelTouchListener dragListener) {
        mTouchListener = dragListener;
    }

    public void setList(List<Channel> list) {
        this.mList.clear();
        this.mList.addAll(list);
    }

    public List<Channel> getList() {
        return mList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_channel,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(mList.get(position).getName());
        holder.setTouchListener();//设置触摸监听
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override//拖拽
    public boolean onItemMove(int fromPosition, int toPosition) {
        swap(mList,fromPosition,toPosition);
        notifyItemMoved(fromPosition,toPosition);
        if (mTouchListener != null){
            mTouchListener.finishDrag();
        }
        return true;
    }

    /**
     * 根据手势拖动，重新排列集合
     */
    private void swap(List<Channel> list,int fromPosition,int toPosition){
        Channel temp = list.get(fromPosition);
        list.remove(fromPosition);
        list.add(toPosition,temp);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements ChannelItemSateListener{
        TextView mChannelName;
        public ViewHolder(View itemView) {
            super(itemView);
            mChannelName = (TextView) itemView.findViewById(R.id.channel_name);
        }

        public void bindData(String name){
            mChannelName.setText(name);
        }

        public void setTouchListener(){
            mChannelName.setOnTouchListener(((v, event) -> {
                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN && mTouchListener != null){
                    mTouchListener.startDrag(this);
                }
                return false;
            }));
        }

        @Override
        public void onItemSelected() {
            mChannelName.setBackgroundColor(mChannelName.getResources().getColor(R.color.md_grey_300));
        }

        @Override
        public void onItemUnselected() {
            mChannelName.setBackgroundColor(Color.WHITE);
        }
    }
}
