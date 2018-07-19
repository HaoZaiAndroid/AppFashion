package com.example.sorelion.fashion.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.sorelion.fashion.R;

public abstract class BaseFragment<SV extends ViewDataBinding> extends Fragment {
    // 布局view
    public SV fragmentBindingView;
    // 内容布局
    protected RelativeLayout mContainer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View ll =  inflater.inflate(R.layout.base_fragment, container,false);
        fragmentBindingView = DataBindingUtil.inflate(inflater,setContentLayout() ,null , false);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        fragmentBindingView.getRoot().setLayoutParams(params);
        mContainer = (RelativeLayout) ll.findViewById(R.id.container);
        mContainer.addView(fragmentBindingView.getRoot());
        return ll;
    }

    /**
     * 布局
     */
    public abstract int setContentLayout();
}
