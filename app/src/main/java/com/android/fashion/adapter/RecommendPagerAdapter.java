package com.android.fashion.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecommendPagerAdapter extends FragmentStatePagerAdapter {
    private List<String> mTitleList = new ArrayList<>();
    private List<Fragment> mFragments = new ArrayList<>();
    public RecommendPagerAdapter(FragmentManager fm, List<String> titleList, List<Fragment> fragmentList) {
        super(fm);
        mTitleList.clear();
        mTitleList.addAll(titleList);
        mFragments.clear();
        mFragments.addAll(fragmentList);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitleList != null) {
            return mTitleList.get(position);
        } else {
            return "";
        }
    }
}
