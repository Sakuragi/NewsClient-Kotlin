package com.jim.newsclient.common.utils

import android.util.Log
import com.jim.newsclient.BuildConfig
import com.jim.newsclient.base.BaseCommand
import com.jim.newsclient.common.net.MapFiled
import com.jim.newsclient.common.net.NetApi
import com.jim.newsclient.config.Constant
import com.jim.newsclient.module.news.model.BaseBean
import com.jim.newsclient.module.news.model.NewsBean
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.coroutines.experimental.EmptyCoroutineContext.plus

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
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttp)
                    .build()
        }
        return retrofit!!
    }

    fun createMaps(list: List<MapFiled>): Map<String, String> {
        var map = HashMap<String, String>()
        val size = list.size
        (0 until size)
                .map { list[it] }
                .forEach { map.put(it.getKey(), it.getValue()) }
        return map
    }

    fun createListFileds(command: BaseCommand): List<MapFiled> {
        var list = ArrayList<MapFiled>()
        val fields = command.javaClass.declaredFields
        for (filed in fields) {
            val isAccess = filed.isAccessible
            filed.isAccessible = true
            list.add(MapFiled(filed.name, filed.get(command).toString()))
            filed.isAccessible = isAccess
        }
        return list
    }

    fun fetchNews(path:String,cmd: BaseCommand): Observable<BaseBean<List<NewsBean>>> {
        return getRetrofit().create(NetApi::class.java).fetchNews(path,createMaps(createListFileds(cmd)))
    }

    fun fetchWorldNews(cmd: BaseCommand): Observable<BaseBean<List<NewsBean>>> {
        return getRetrofit().create(NetApi::class.java).fetchWorldNews(createMaps(createListFileds(cmd)))
    }

    fun fetchHuaBian(cmd: BaseCommand): Observable<BaseBean<List<NewsBean>>> {
        return getRetrofit().create(NetApi::class.java).fetchHuaBian(createMaps(createListFileds(cmd)))
    }

    fun fetchQiwen(cmd: BaseCommand): Observable<BaseBean<List<NewsBean>>> {
        return getRetrofit().create(NetApi::class.java).fetchQiwen(createMaps(createListFileds(cmd)))
    }

    fun fetchHealth(cmd: BaseCommand): Observable<BaseBean<List<NewsBean>>> {
        return getRetrofit().create(NetApi::class.java).fetchHealth(createMaps(createListFileds(cmd)))
    }

    fun fetchTiYu(cmd: BaseCommand): Observable<BaseBean<List<NewsBean>>> {
        return getRetrofit().create(NetApi::class.java).fetchTiYu(createMaps(createListFileds(cmd)))
    }

    fun fetchKeji(cmd: BaseCommand): Observable<BaseBean<List<NewsBean>>> {
        return getRetrofit().create(NetApi::class.java).fetchKeji(createMaps(createListFileds(cmd)))
    }

    fun fetchTravel(cmd: BaseCommand): Observable<BaseBean<List<NewsBean>>> {
        return getRetrofit().create(NetApi::class.java).fetchTravel(createMaps(createListFileds(cmd)))
    }
}