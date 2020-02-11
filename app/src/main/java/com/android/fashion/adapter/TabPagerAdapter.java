package com.android.fashion.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabPagerAdapter extends FragmentStatePagerAdapter {
    List<Fragment> fragments = new ArrayList<>();
    public TabPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        fragments.clear();
        fragments.addAll(list);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
