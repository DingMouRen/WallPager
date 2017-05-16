package com.dingmouren.wallpager.interfaces;

import android.support.v7.widget.RecyclerView;

/**
 * Created by dingmouren on 2017/5/16.
 * 在频道排序功能中，用来监听触摸监听，被触摸的目标开始实现拖拽
 */

public interface ChannelTouchListener {
    void startDrag(RecyclerView.ViewHolder viewHolder);
    void finishDrag();
}
