package com.example.sorelion.fashion.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.sorelion.fashion.R;
import com.example.sorelion.fashion.activity.MainActivity;

/**
 * Created by pact on 2018/7/16.
 */

public abstract class BaseFragment extends Fragment {
    private View mView;
    protected MainActivity mMainActivityt;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mMainActivityt = ((MainActivity) getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_base, container, false);
            TextView tv_title = mView.findViewById(R.id.tv_title);
            TextView tv_left = mView.findViewById(R.id.tv_left);
            FrameLayout base_FrameLayout = mView.findViewById(R.id.base_FrameLayout);
            View chileView = inflater.inflate(getLayoutRes(), base_FrameLayout, true);
            initView(tv_title, tv_left, chileView);
            tv_left.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mMainActivityt.addShowAndHideFragment(mMainActivityt.getFragmentList().get(0));
                }
            });
        }
        return mView;
    }

    public abstract void initView(TextView tv_title, TextView tv_left, View chileView);

    public abstract int getLayoutRes();

}
