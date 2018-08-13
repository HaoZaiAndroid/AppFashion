package com.example.sorelion.fashion.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.sorelion.fashion.R;
import com.example.sorelion.fashion.adapter.RecommendPagerAdapter;
import com.example.sorelion.fashion.base.BaseFragment;
import com.example.sorelion.fashion.databinding.RecommendFragmentBinding;
import com.example.sorelion.fashion.utils.Util;
import com.example.sorelion.fashion.widget.tablayout.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class RecommendFragment extends BaseFragment<RecommendFragmentBinding> {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private List<String> mTitleList = new ArrayList<>();
    private List<Fragment> mFragments = new ArrayList<>();
    private Context context;

    @Override
    public int setContentLayout() {
        return R.layout.recommend_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        context = getContext();
        initID();
        initFragment();

    }

    private void initFragment() {
        mTitleList.add(getString(R.string.recommend_tab_one));
        mTitleList.add(getString(R.string.recommend_tab_two));
        //mTitleList.add(getString(R.string.recommend_tab_three));
        mFragments.add(new ChoicenessFragment());
        mFragments.add(new FriendFragment());
        RecommendPagerAdapter adapter = new RecommendPagerAdapter(getChildFragmentManager(), mTitleList, mFragments);
        viewPager.setAdapter(adapter);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setNeedSwitchAnimation(true);

        tabLayout.setSelectedTabIndicatorWidth(Util.Dp2px(context, 25));
        //tabLayout.setIndicatorWidthWrapContent(true)
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initID() {
        viewPager = fragmentBindingView.vpRecommend;
        tabLayout = fragmentBindingView.titleTab;
    }
}
