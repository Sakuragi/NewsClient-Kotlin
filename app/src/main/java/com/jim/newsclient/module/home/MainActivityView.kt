package com.jim.newsclient.module.home

import android.support.v4.app.Fragment

/**
 * Created by Jim on 2017/12/3.
 */
interface MainActivityView{
    fun onFragmentsFetched(fragments:List<Fragment>)
}