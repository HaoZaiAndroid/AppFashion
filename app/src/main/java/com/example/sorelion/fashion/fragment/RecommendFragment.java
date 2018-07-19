package com.example.sorelion.fashion.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sorelion.fashion.R;
import com.example.sorelion.fashion.base.BaseFragment;
import com.example.sorelion.fashion.databinding.RecommendFragmentBinding;

public class RecommendFragment extends BaseFragment<RecommendFragmentBinding> {

    @Override
    public int setContentLayout() {
        return R.layout.recommend_fragment;
    }
}
