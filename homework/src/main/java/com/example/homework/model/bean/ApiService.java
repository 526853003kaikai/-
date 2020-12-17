package com.example.homework.model.bean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    public static final String URL = "https://www.wanandroid.com/";
    public static final String BURL = "http://c.m.163.com/nc/";


    @GET("project/tree/json")
    Observable<TabBean> getTab();

    @GET("project/list/{page}/json")
    Observable<RyBean> getRyData(@Path("page")int page, @Query("cid")int cid);

    @GET("video/list/V9LG4E6VR/n/0-10.html")
    Observable<MpBean> getMp();
}
