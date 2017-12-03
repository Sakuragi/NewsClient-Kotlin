package com.jim.newsclient.module.news

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jim.newsclient.R
import com.jim.newsclient.base.BaseLazyFragment

/**
 * Created by Jim on 2017/11/21.
 */
class NewsFragment:BaseLazyFragment(){

    var newsType:Int?=null

    companion object{
        fun newInstance(type:Int):NewsFragment{
            var fragment=NewsFragment()
            var bd=Bundle()
            bd.putInt("type",type)
            fragment.setArguments(bd)
            return fragment
        }
    }

    protected var isViewCreated:Boolean=false

    override fun getContentId(): Int {
        return R.layout.fragment_news
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isViewCreated=true
    }

    override fun lazyLoad() {
        if (!isViewCreated||!isVisbileToUser){
            return
        }
        initDatas()

    }

    fun initDatas(){
        newsType=arguments.getInt("type")
    }

}