package com.example.sorelion.fashion.activity;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.sorelion.fashion.R;
import com.example.sorelion.fashion.fragment.BaseFragment;
import com.example.sorelion.fashion.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ArrayList<BaseFragment> getFragmentList() {
        return mFragmentList;
    }

    private ArrayList<BaseFragment> mFragmentList;
    private List<BaseFragment> cacheFragment = new ArrayList<>();
    public BaseFragment preFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        addShowAndHideFragment(mFragmentList.get(0));
        Log.d("yh", "test git");
    }

    private void initFragment() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new HomeFragment());
    }

    public void addShowAndHideFragment(BaseFragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        if (!cacheFragment.contains(fragment)) {
            fragmentTransaction.add(R.id.main_FrameLayout, fragment);
            //保存起来
            cacheFragment.add(fragment);
        } else {
            fragmentTransaction.show(fragment);
        }
        //隐藏上一个Fragment
        if (preFragment != null) {
            fragmentTransaction.hide(preFragment);
        }
        fragmentTransaction.commit();
        preFragment = fragment;
    }

}
