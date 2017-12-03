package com.jim.newsclient.module.home

import android.support.v4.app.Fragment
import com.jim.newsclient.module.news.NewsFragment

/**
 * Created by Jim on 2017/11/23.
 */
class MainAcivityPresenter(private val view:MainActivityView){

    fun fetchFragments(num:Int){
        var fragments=ArrayList<Fragment>()
        var i=num
        while (i>0){
            fragments.add(i,NewsFragment.newInstance(i-1))
            i--
        }
        view?.onFragmentsFetched(fragments)
    }


}