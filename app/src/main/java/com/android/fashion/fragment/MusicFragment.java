package com.android.fashion.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.fashion.R;
import com.android.fashion.base.BaseFragment;
import com.android.fashion.databinding.MusicFragmentBinding;

public class MusicFragment extends BaseFragment<MusicFragmentBinding>{

    private RecyclerView recyclerView;

    @Override
    public int setContentLayout() {
        return R.layout.music_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        recyclerView = fragmentBindingView.rvMusic;
    }
}
