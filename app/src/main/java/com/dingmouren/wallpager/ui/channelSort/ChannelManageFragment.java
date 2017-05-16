package com.dingmouren.wallpager.ui.channelSort;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.widget.RelativeLayout;

import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.base.BaseFragment;
import com.dingmouren.wallpager.interfaces.ChannelTouchListener;

import java.util.Arrays;

import butterknife.BindView;

/**
 * Created by dingmouren on 2017/5/16.
 */

public class ChannelManageFragment extends BaseFragment implements ChannelTouchListener{
    private static final String TAG = ChannelManageFragment.class.getName();
    private String[] mChannels = new String[]{"新作","精选","热门","建筑","饮食","自然","物品","人物","科技","星空"};
    @BindView(R.id.container)
    RelativeLayout mContainer;
    @BindView(R.id.recycler)
    RecyclerView mRecyclerView;

    private ChannelAdapter mChannelAdapter;
    private ChannelItemTouchHelperCallback mChannelItemTouchHelperCallback;
    private ItemTouchHelper mItemTouchHelper;

    @Override
    public void init() {
        mChannelAdapter = new ChannelAdapter(this);
        mChannelAdapter.setList(Arrays.asList(mChannels));
        mChannelItemTouchHelperCallback = new ChannelItemTouchHelperCallback(mChannelAdapter);
        mItemTouchHelper = new ItemTouchHelper(mChannelItemTouchHelperCallback);
    }

    @Override
    public int requestLayout() {
        return R.layout.fragment_channel_manage;
    }

    @Override
    public void initView() {
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mChannelAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mContainer != null){
            mContainer.removeAllViews();
            mContainer = null;
        }
    }

    @Override
    public void startDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }

    @Override
    public void finishDrag() {
        Log.e(TAG,mChannelAdapter.getList().toString());
    }
}
