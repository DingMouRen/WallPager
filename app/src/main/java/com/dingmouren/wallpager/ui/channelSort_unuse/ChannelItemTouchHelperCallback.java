package com.dingmouren.wallpager.ui.channelSort_unuse;

import android.graphics.Canvas;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.dingmouren.wallpager.interfaces.ChannelAdapterDragListener;
import com.dingmouren.wallpager.interfaces.ChannelItemSateListener;

/**
 * Created by dingmouren on 2017/5/16.
 */

public class ChannelItemTouchHelperCallback extends ItemTouchHelper.Callback{
    private ChannelAdapterDragListener mAdapterDragListener;

    public ChannelItemTouchHelperCallback(ChannelAdapterDragListener adapterDragListener) {
        mAdapterDragListener = adapterDragListener;
    }

    @Override//用来设置拖动方向或者侧滑方向
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager){
            final int dragFlag = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;//设置列表拖拽方向为上下
            final int swipeFlag = 0;
            return makeMovementFlags(dragFlag,swipeFlag);
        }else {
            return makeMovementFlags(0,0);//其他不支持
        }
    }

    @Override//拖动item时回调此方法
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
       if (viewHolder.getItemViewType() != target.getItemViewType()) return false;//两个不同的viewhodle，不允许拖拽
        mAdapterDragListener.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return true;
    }

    @Override//item侧滑时回调此方法，这里没有侧滑动作
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }

    @Override//当item的状态发生改变时回调此方法
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        //当前状态不是空闲装填，说明正在被拖拽，在这里调用改变item背景颜色的方法
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE && viewHolder instanceof ChannelItemSateListener){
            ChannelItemSateListener itemSateListener = (ChannelItemSateListener) viewHolder;
            itemSateListener.onItemSelected();//在这里调用修改选中item的背景颜色
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override//拖拽完成后回调此方法，用来清除item上的一些状态
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        if (viewHolder instanceof ChannelItemSateListener){
            ChannelItemSateListener itemSateListener = (ChannelItemSateListener) viewHolder;
            itemSateListener.onItemUnselected();//还原item的背景颜色
        }
    }

    @Override//这个方法可以判断当前动作是拖拽还是侧滑，可以实现一些特定效果
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }
}
