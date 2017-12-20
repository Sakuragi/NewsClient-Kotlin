package com.jim.newsclient.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Jim on 2017/12/3.
 */
open class BaseLazyFragment:Fragment(){

    protected var isVisbileToUser:Boolean=false

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater?.inflate(getContentId(),container,false)
        return view
    }


    open fun getContentId():Int{
        return 0
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (userVisibleHint){
            isVisbileToUser=true
            onVisible()
        }else{
            isVisbileToUser=false
            onInvisible()
        }
    }

    open fun onVisible(){
        lazyLoad()
    }

    open fun lazyLoad(){}

    open fun onInvisible(){}
}