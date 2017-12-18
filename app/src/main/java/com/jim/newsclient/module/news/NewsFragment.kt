package com.jim.newsclient.module.news

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.jim.newsclient.R
import com.jim.newsclient.base.BaseLazyFragment
import com.jim.newsclient.module.news.model.BaseBean
import com.jim.newsclient.module.news.model.NewsBean
import kotlinx.android.synthetic.main.fragment_news.*

/**
 * Created by Jim on 2017/11/21.
 */
class NewsFragment:BaseLazyFragment(),INewsView,SwipeRefreshLayout.OnRefreshListener{

    var newsType:Int?=null
    var mPresenter:NewsPresenter? = null
    var page:Int?=null
    var num:Int=10
    var adapter:NewsAdapter?=null
    var datas=ArrayList<NewsBean>()

    companion object{
        fun newInstance(type:Int):NewsFragment{
            var fragment=NewsFragment()
            var bd=Bundle()
            bd.putInt("type",type)
            fragment.setArguments(bd)
            return fragment
        }
    }

    protected var isPrepared:Boolean=false

    override fun getContentId(): Int {
        return R.layout.fragment_news
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isPrepared=true
    }

    override fun lazyLoad() {
        if (!isPrepared||!isVisbileToUser){
            return
        }
        initDatas()
        initViews()
        onRefresh()
        isPrepared=false
    }

    fun fetchDatas(){
        mPresenter?.fetchNews(newsType!!,page!!,num)
    }

    fun initViews(){
        news_rcv.layoutManager=LinearLayoutManager(activity)
        news_rcv.adapter=adapter
        swl.setOnRefreshListener(this)
    }

    fun initDatas(){
        newsType=arguments.getInt("type")
        mPresenter= NewsPresenter(this)
        adapter= NewsAdapter(datas,activity)
        page=0
    }

    override fun onNewsFetched(resp: BaseBean<List<NewsBean>>) {
        swl.isRefreshing=false
        Log.d("tag","get resp: "+resp.toString())
        if (resp.code==200){
            Log.d("tag","news fetched")
            adapter?.addDatas(resp.newslist)
        }
    }

    override fun onNewsFetchedFailed(throwble: Throwable) {
        swl.isRefreshing=false
        Log.d("tag","get resp error: "+throwble.toString())

    }

    override fun onRefresh() {
        swl.isRefreshing=true
        page=0;
        mPresenter?.fetchNews(newsType!!,page!!,num)
    }
}