package com.dingmouren.wallpager.interfaces;

/**
 * Created by dingmouren on 2017/5/16.
 * 频道排序中，选中与未选中两种状态的监听
 */

public interface ChannelItemSateListener {
    void onItemSelected();//选中时，修改背景颜色
    void onItemUnselected();//未选中，清除背景颜色
}
