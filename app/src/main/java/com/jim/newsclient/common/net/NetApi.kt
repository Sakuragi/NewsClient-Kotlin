package com.jim.newsclient.common.net

import com.jim.newsclient.module.news.model.BaseBean
import com.jim.newsclient.module.news.model.NewsBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

/**
 * Created by Jim on 2017/11/23.
 */
interface NetApi {

    @GET("{path}")
    fun fetchNews(@Path("path") path:String, @QueryMap maps: Map<String, String>): Observable<BaseBean<List<NewsBean>>>

    @GET("world/")
    fun fetchWorldNews(@QueryMap maps: Map<String, String>): Observable<BaseBean<List<NewsBean>>>

    @GET("huabian/")
    fun fetchHuaBian(@QueryMap maps: Map<String, String>): Observable<BaseBean<List<NewsBean>>>

    @GET("qiwen/")
    fun fetchQiwen(@QueryMap maps: Map<String, String>): Observable<BaseBean<List<NewsBean>>>

    @GET("health/")
    fun fetchHealth(@QueryMap maps: Map<String, String>): Observable<BaseBean<List<NewsBean>>>

    @GET("tiyu/")
    fun fetchTiYu(@QueryMap maps: Map<String, String>): Observable<BaseBean<List<NewsBean>>>

    @GET("keji/")
    fun fetchKeji(@QueryMap maps: Map<String, String>): Observable<BaseBean<List<NewsBean>>>

    @GET("travel/")
    fun fetchTravel(@QueryMap maps: Map<String, String>): Observable<BaseBean<List<NewsBean>>>
}