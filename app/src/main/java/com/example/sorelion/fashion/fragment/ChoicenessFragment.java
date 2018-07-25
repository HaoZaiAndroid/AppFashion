package com.example.sorelion.fashion.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.sorelion.fashion.R;
import com.example.sorelion.fashion.adapter.ChoicenessBannerAdapter;
import com.example.sorelion.fashion.app.ConstantsImageUrl;
import com.example.sorelion.fashion.base.BaseFragment;
import com.example.sorelion.fashion.bean.ChoicenessBannerBean;
import com.example.sorelion.fashion.databinding.ChoicenessFragmentBinding;
import com.example.sorelion.fashion.databinding.FriendFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class ChoicenessFragment extends BaseFragment<ChoicenessFragmentBinding>{
    private RecyclerView bannerView;
    @Override
    public int setContentLayout() {
        return R.layout.choiceness_fragment;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        bannerView = fragmentBindingView.rvBanner;
        bannerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        new LinearSnapHelper().attachToRecyclerView(bannerView);

        ChoicenessBannerAdapter choicenessBannerAdapter = new ChoicenessBannerAdapter();
        List<ChoicenessBannerBean> data = new ArrayList<>();
        for (int i = 0; i < ConstantsImageUrl.TRANSITION_URLS.length; i++) {
            ChoicenessBannerBean bean = new ChoicenessBannerBean();
            bean.setUrl(ConstantsImageUrl.TRANSITION_URLS[i]);
            data.add(bean);
        }
        bannerView.setAdapter(choicenessBannerAdapter);
        choicenessBannerAdapter.addAll(data);
        choicenessBannerAdapter.notifyDataSetChanged();
    }

}
