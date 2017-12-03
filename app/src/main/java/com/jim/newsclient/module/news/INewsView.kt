package com.jim.newsclient.module.news

/**
 * Created by Jim on 2017/12/3.
 */
interface INewsView{
    fun onNewsFetched(resp:BaseBean<NewsBean>)
    fun onNewsFetchedFailed(throwble:Throwable)
}