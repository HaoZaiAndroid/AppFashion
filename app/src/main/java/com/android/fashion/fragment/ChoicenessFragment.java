package com.android.fashion.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.fashion.R;
import com.android.fashion.adapter.ChoicenessBannerAdapter;
import com.android.fashion.base.BaseFragment;
import com.android.fashion.bean.BannerBean;
import com.android.fashion.databinding.ChoicenessFragmentBinding;
import com.android.fashion.request.IBanner;
import com.android.fashion.utils.Util;
import com.android.fashion.widget.bannerLayoutManger.CenterSnapHelper;
import com.android.fashion.widget.bannerLayoutManger.ScaleLayoutManager;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChoicenessFragment extends BaseFragment<ChoicenessFragmentBinding>{
    private RecyclerView bannerView;
    private Disposable bannerDisposable;
    private ChoicenessBannerAdapter choicenessBannerAdapter;

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
        Context context = bannerView.getContext();
        getBannerData();

        ScaleLayoutManager scaleLayoutManager = new ScaleLayoutManager(context, Util.Dp2px(context, 10));
        bannerView.setLayoutManager(scaleLayoutManager);
        new CenterSnapHelper().attachToRecyclerView(bannerView);
        choicenessBannerAdapter = new ChoicenessBannerAdapter();
        bannerView.setAdapter(choicenessBannerAdapter);
    }

    private void getBannerData() {
        //http://www.wanandroid.com/banner/json
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.wanandroid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        IBanner iBanner = retrofit.create(IBanner.class);
        final Observable<BannerBean> banner = iBanner.getBanner();
        banner.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        bannerDisposable = d;
                    }
                    @Override
                    public void onNext(BannerBean bannerBean) {
                        List<BannerBean.DataBean> data = bannerBean.getData();
                        choicenessBannerAdapter.addAll(data);
                        choicenessBannerAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (bannerDisposable != null) {
            bannerDisposable.dispose();
        }
    }
}
