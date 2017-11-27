package com.jim.newsclient.common.net

import com.jim.newsclient.module.news.BaseBean
import com.jim.newsclient.module.news.NewsBean
import retrofit2.http.GET
import retrofit2.http.QueryMap
import rx.Observable

/**
 * Created by Jim on 2017/11/23.
 */
interface NetApi {
    @GET("world/")
    fun fetchNews(@QueryMap maps: Map<String, String>): Observable<BaseBean<NewsBean>>

    @GET("huabian/")
    fun fetchHuaBian(@QueryMap maps: Map<String, String>): Observable<BaseBean<NewsBean>>

    @GET("qiwen/")
    fun fetchQiwen(@QueryMap maps: Map<String, String>): Observable<BaseBean<NewsBean>>

    @GET("health/")
    fun fetchHealth(@QueryMap maps: Map<String, String>): Observable<BaseBean<NewsBean>>

    @GET("tiyu/")
    fun fetchTiYu(@QueryMap maps: Map<String, String>): Observable<BaseBean<NewsBean>>

    @GET("keji/")
    fun fetchKeji(@QueryMap maps: Map<String, String>): Observable<BaseBean<NewsBean>>

    @GET("travel/")
    fun fetchTravel(@QueryMap maps: Map<String, String>): Observable<BaseBean<NewsBean>>
}