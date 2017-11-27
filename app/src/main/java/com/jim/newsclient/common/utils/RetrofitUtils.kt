package com.jim.newsclient.common.utils

import android.util.Log
import com.jim.newsclient.BuildConfig
import com.jim.newsclient.common.net.MapFiled
import com.jim.newsclient.common.net.NetApi
import com.jim.newsclient.config.Constant
import com.jim.newsclient.module.news.BaseBean
import com.jim.newsclient.module.news.NewsBean
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by Jim on 2017/11/23.
 */
object RetrofitUtils {

    private var retrofit: Retrofit? = null

    private val okHttp: OkHttpClient
        get() {     //自定义getOkHttp（）方法
            var builder = OkHttpClient.Builder()
            if (BuildConfig.DEBUG) {
                builder.connectTimeout(5, TimeUnit.SECONDS)
                        .readTimeout(5, TimeUnit.SECONDS)
                        .writeTimeout(5, TimeUnit.SECONDS)
                builder.addInterceptor { chain ->
                    Log.d("retro", "request: " + chain.request())
                    chain.proceed(chain.request())
                }
            } else {
                builder.connectTimeout(15, TimeUnit.SECONDS)
                        .readTimeout(15, TimeUnit.SECONDS)
                        .writeTimeout(15, TimeUnit.SECONDS)
            }
            return builder.build()
        }

    private fun getRetrofit(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl(Constant.baseUrl)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttp)
                    .build()
        }
        return retrofit!!
    }

    fun createMaps(list: List<MapFiled>):Map<String,String>{
        var map=HashMap<String,String>()
        val size=list.size
        (0 until size)
                .map { list[it] }
                .forEach { map.put(it.getKey(),it.getValue()) }
        return map
    }

    fun fetchNews(list: List<MapFiled>):Observable<BaseBean<NewsBean>> {
        return getRetrofit().create(NetApi::class.java).fetchNews(createMaps(list))
    }
}