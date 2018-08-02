package com.example.sorelion.fashion.request;

import com.example.sorelion.fashion.bean.BannerBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IBanner {
    //http://www.wanandroid.com/banner/json
    @GET("banner/json")
    Observable<BannerBean> getBanner();
}
