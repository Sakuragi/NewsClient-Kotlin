package com.jim.newsclient.module.news

import com.jim.newsclient.module.news.model.BaseBean
import com.jim.newsclient.module.news.model.NewsBean

/**
 * Created by Jim on 2017/12/3.
 */
interface INewsView{
    fun onNewsFetched(resp: BaseBean<NewsBean>)
    fun onNewsFetchedFailed(throwble:Throwable)
}