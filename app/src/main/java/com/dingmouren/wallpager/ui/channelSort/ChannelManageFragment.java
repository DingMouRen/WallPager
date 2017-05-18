package com.dingmouren.wallpager.ui.channelSort;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.base.BaseFragment;
import com.dingmouren.wallpager.interfaces.ChannelTouchListener;
import com.dingmouren.wallpager.model.dao.Channel;
import com.dingmouren.wallpager.ui.MainActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import io.realm.Realm;
import io.realm.RealmResults;
import rx.internal.operators.SingleOnSubscribeUsing;

/**
 * Created by dingmouren on 2017/5/16.
 */

public class ChannelManageFragment extends BaseFragment implements ChannelTouchListener{
    private static final String TAG = ChannelManageFragment.class.getName();
    private String[] mChannelsStr = new String[]{"新作","精选","热门","建筑","饮食","自然","物品","人物","科技","星空"};
    private List<String> mChannels = new ArrayList<>();
    @BindView(R.id.recycler) RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)Toolbar mToolbar;

    private ChannelAdapter mChannelAdapter;
    private ChannelItemTouchHelperCallback mChannelItemTouchHelperCallback;
    private ItemTouchHelper mItemTouchHelper;
    private Realm mRealm;

    public static ChannelManageFragment newInstance(){
        return new ChannelManageFragment();
    }

    @Override
    public void init() {
        mChannelAdapter = new ChannelAdapter(this);
        mChannelAdapter.setList(mChannels);
        mChannelItemTouchHelperCallback = new ChannelItemTouchHelperCallback(mChannelAdapter);
        mItemTouchHelper = new ItemTouchHelper(mChannelItemTouchHelperCallback);
    }

    @Override
    public int requestLayout() {
        return R.layout.fragment_channel_manage;
    }

    @Override
    public void initView() {
        initToolbar();
        initRecyclerView();
        mRealm = Realm.getDefaultInstance();

    }

    @Override
    public void initListener() {
        mToolbar.setNavigationOnClickListener(v -> ((MainActivity)getActivity()).toggleDrawer());
    }

    @Override
    public void onResume() {
        super.onResume();
        mChannels.clear();
        RealmResults<Channel> channels = mRealm.where(Channel.class).findAll();
        if (channels != null && channels.size() > 0){
            mChannels.addAll(queryAllChannels());
        }else {
            mChannels = Arrays.asList(mChannelsStr);
        }
        mChannelAdapter.setList(mChannels);
        mChannelAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mRealm.close();//关闭数据库
    }

    private void initToolbar() {
        mToolbar.setTitle(getString(R.string.sort_title));
        mToolbar.setTitleTextColor(Color.WHITE);
        ((MainActivity)getActivity()).setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.img_slide_menu);
    }

    private void initRecyclerView() {
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mChannelAdapter);
    }


    @Override
    public void startDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }

    @Override//完成拖拽的时候重新写入数据库
    public void finishDrag() {
        deleteAllChannels();
        addNewChannels();
    }

    /**
     * 删除所有频道
     */
    private void deleteAllChannels(){
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(Channel.class);
            }
        });
    }

    /**
     * 将重新排序的频道写入数据库
     */
    private void addNewChannels(){
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                List<String> channels = mChannelAdapter.getList();
                Log.e(TAG,"adapter:"+channels.toString());
                if (channels == null || channels.size() == 0) return;
                for (int i = 0; i < channels.size(); i++) {
                    Channel channel = realm.createObject(Channel.class);
                    channel.setName(channels.get(i));
                }
            }
        });
    }

    /**
     * 查询所有频道
     */
    private List<String> queryAllChannels(){
        List<String> channels = new ArrayList<>();
        channels.clear();
        RealmResults<Channel> results = mRealm.where(Channel.class).findAll();
        if (results != null && results.size() > 0){
           for (Channel channel : results){
               channels.add(channel.getName());
           }
        }
        return channels;
    }


}
