package com.android.fashion.request;

import com.android.fashion.bean.BannerBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IBanner {
    //http://www.wanandroid.com/banner/json
    @GET("banner/json")
    Observable<BannerBean> getBanner();
}
