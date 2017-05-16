package com.dingmouren.wallpager.ui.channelSort;

import android.graphics.Color;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.dingmouren.wallpager.MyApplication;
import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.interfaces.ChannelAdapterDragListener;
import com.dingmouren.wallpager.interfaces.ChannelItemSateListener;
import com.dingmouren.wallpager.interfaces.ChannelTouchListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dingmouren on 2017/5/16.
 */

public class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.ViewHolder> implements ChannelAdapterDragListener{
    private List<String> mList = new ArrayList<>();
    private ChannelTouchListener mTouchListener;

    public ChannelAdapter(ChannelTouchListener dragListener) {
        mTouchListener = dragListener;
    }

    public void setList(List<String> list) {
        mList = list;
    }

    public List<String> getList() {
        return mList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_channel,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(mList.get(position));
        holder.setTouchListener();//设置触摸监听
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override//拖拽
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mList,fromPosition,toPosition);//在集合中，交换item位置
        notifyItemMoved(fromPosition,toPosition);
        if (mTouchListener != null){
            mTouchListener.finishDrag();
        }
        return true;
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
