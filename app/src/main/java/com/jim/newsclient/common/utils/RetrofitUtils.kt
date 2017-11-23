package com.jim.newsclient.common.utils

import retrofit2.Retrofit

/**
 * Created by Jim on 2017/11/23.
 */
class RetrofitUtils{

    private val retrofit:Retrofit?=null

    private fun getRetrofit(): Retrofit {
        if (retrofit==null){

        }
        return retrofit!!
    }
}