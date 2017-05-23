package com.dingmouren.wallpager.ui.channelSort_unuse;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import com.dingmouren.wallpager.Constant;
import com.dingmouren.wallpager.R;
import com.dingmouren.wallpager.base.BaseFragment;
import com.dingmouren.wallpager.interfaces.ChannelTouchListener;
import com.dingmouren.wallpager.model.dao.Channel;
import com.dingmouren.wallpager.ui.MainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by dingmouren on 2017/5/16.
 */

public class ChannelManageFragment extends BaseFragment implements ChannelTouchListener {
    private static final String TAG = ChannelManageFragment.class.getName();
    @BindView(R.id.recycler)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private ChannelAdapter mChannelAdapter;
    private ChannelItemTouchHelperCallback mChannelItemTouchHelperCallback;
    private ItemTouchHelper mItemTouchHelper;
    private Realm mRealm;

    public static ChannelManageFragment newInstance() {
        return new ChannelManageFragment();
    }

    @Override
    public void init() {
        mRealm = Realm.getDefaultInstance();
        mChannelAdapter = new ChannelAdapter(this);
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
    }

    @Override
    public void initListener() {
        mToolbar.setNavigationOnClickListener(v -> ((MainActivity) getActivity()).toggleDrawer());
    }

    @Override
    public void onResume() {
        super.onResume();
        mChannelAdapter.setList(queryAllChannels());
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
        ((MainActivity) getActivity()).setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.img_slide_menu);
    }

    private void initRecyclerView() {
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mChannelAdapter);
    }


    @Override
    public void startDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }

    @Override//完成拖拽的时候重新写入数据库
    public void finishDrag() {
        updateChannels();
    }


    /**
     * 查询所有频道
     */
    private List<Channel> queryAllChannels() {
        List<Channel> channels = new ArrayList<>();
        channels.clear();
        RealmResults<Channel> results = mRealm.where(Channel.class).findAll().sort("sort_id");

        if (results.size() == 0) {
            channels.addAll(initChannels());

        } else {
            for (Channel channel : results) {
                channels.add(channel);
            }
        }
        return channels;
    }

    /**
     * 更新频道顺序
     */
    private void updateChannels() {
        RealmResults<Channel> results = mRealm.where(Channel.class).findAll();
        List<Channel> channels = mChannelAdapter.getList();
        for (int i = 0; i < channels.size(); i++) {
            for (int j = 0; j < results.size(); j++) {
                if (channels.get(i).getId() == results.get(j).getId()) {
                    mRealm.beginTransaction();
                    results.get(j).setSort_id(i);
                    mRealm.commitTransaction();
                }
            }
        }
    }

    /**
     * 初始化频道
     */
    private List<Channel> initChannels() {
        List<Channel> channels = new ArrayList<>();
        mRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                for (int i = 0; i < Constant.DEFAULT_CHANNELS.length; i++) {
                    Channel channel = realm.createObject(Channel.class);
                    channel.setName(Constant.DEFAULT_CHANNELS[i]);
                    channel.setId(i + 101);
                    channel.setSort_id(i);
                    channels.add(channel);
                }
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.e(TAG, "初始化频道成功");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Log.e(TAG, "初始化频道失败" + error.toString());
            }
        });
        return channels;
    }

}
