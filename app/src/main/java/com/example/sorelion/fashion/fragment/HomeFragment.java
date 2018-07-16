package com.example.sorelion.fashion.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sorelion.fashion.R;
import com.example.sorelion.fashion.adapter.RecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by pact on 2018/7/16.
 */

public class HomeFragment extends BaseFragment {
    private static List<String> mlist;

    static {
        mlist = new ArrayList<>();
        mlist.add("自定义控件");
        mlist.add("联网框架");
        mlist.add("视频播放器");
    }

    @BindView(R.id.rv_fragment_home)
    RecyclerView mRvFragmentHome;
    Unbinder unbinder;
    private GridLayoutManager mLinearLayoutManager;
    private RecycleViewAdapter mRecycleViewAdapter;

    @Override
    public void initView(TextView tv_title, TextView tv_left, View chileView) {
        unbinder = ButterKnife.bind(this, chileView);
        tv_title.setText(R.string.home_fragment_title);
        tv_left.setVisibility(View.GONE);
        mLinearLayoutManager = new GridLayoutManager(mMainActivityt, 2);
        mRvFragmentHome.setLayoutManager(mLinearLayoutManager);
        mRecycleViewAdapter = new RecycleViewAdapter(mMainActivityt, mlist, mRvFragmentHome);
        mRvFragmentHome.setAdapter(mRecycleViewAdapter);
        //recyclerView的条目点击事件
        mRecycleViewAdapter.setItemOnClickListener(new RecycleViewAdapter.itemOnClickListener() {
            @Override
            public void clickItem(int position) {
                Toast.makeText(mMainActivityt, "点击了条目", Toast.LENGTH_SHORT).show();
//                mMainActivityt.addShowAndHideFragment(mMainActivityt.getFragmentList().get(position));
            }
        });
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
