package com.jim.newsclient.module.news

/**
 * Created by Jim on 2017/11/27.
 */
data class BaseBean<T>(val code: Int, val msg: String,var data:T)

data class NewsBean(val ctime:String,var title:String,var description:String,var picUrl:String,var url:String)