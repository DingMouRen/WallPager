package com.dingmouren.wallpager.interfaces;

/**
 * Created by dingmouren on 2017/5/16.
 * 当频道排序的适配器中的item被拖拽时，adapter做出响应
 */

public interface ChannelAdapterDragListener {
    boolean onItemMove(int fromPosition,int toPosition);
}
