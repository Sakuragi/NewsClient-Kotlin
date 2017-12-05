package com.jim.newsclient.module.news

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.view.View
import com.jim.newsclient.R
import com.jim.newsclient.base.BaseLazyFragment
import com.jim.newsclient.module.news.model.BaseBean
import com.jim.newsclient.module.news.model.NewsBean

/**
 * Created by Jim on 2017/11/21.
 */
class NewsFragment:BaseLazyFragment(),INewsView,SwipeRefreshLayout.OnRefreshListener{

    var newsType:Int?=null
    var mPresenter:NewsPresenter? = null
    var page:Int?=null
    var num:Int=10
    var adapter:NewsAdapter?=null

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
        initViews()
        fetchDatas()
    }

    fun fetchDatas(){
        mPresenter?.fetchNew(newsType!!,page!!,num)
    }

    fun initViews(){

    }

    fun initDatas(){
        newsType=arguments.getInt("type")
        mPresenter= NewsPresenter(this)
        page=0
    }

    override fun onNewsFetched(resp: BaseBean<NewsBean>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onNewsFetchedFailed(throwble: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRefresh() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}