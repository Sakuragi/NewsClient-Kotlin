package com.jim.newsclient.module.news

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.jim.newsclient.R
import com.jim.newsclient.base.BaseLazyFragment
import com.jim.newsclient.module.news.model.BaseBean
import com.jim.newsclient.module.news.model.NewsBean
import kotlinx.android.synthetic.main.fragment_news.*
import android.animation.AnimatorListenerAdapter
import android.support.v4.view.animation.FastOutLinearInInterpolator
import android.support.v4.view.ViewCompat.animate
import android.R.attr.scaleX
import android.R.attr.scaleY
import android.support.v4.view.ViewCompat.canScrollVertically
import android.support.v7.widget.RecyclerView



/**
 * Created by Jim on 2017/11/21.
 */
class NewsFragment:BaseLazyFragment(),INewsView,SwipeRefreshLayout.OnRefreshListener{

    var newsType:Int=0
    var mPresenter:NewsPresenter? = null
    var page:Int=0
    var num:Int=10
    var adapter:NewsAdapter?=null
    var datas=ArrayList<NewsBean>()
    var isRefresh:Boolean=false

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
        lazyLoad()
    }

    override fun lazyLoad() {
        Log.d("tag","ispre: "+isPrepared+" isvis: "+isVisbileToUser)
        if (!isPrepared or !isVisbileToUser){
            return
        }
        Log.d("tag","lazyload")
        initDatas()
        initViews()
        mPresenter?.fetchNews(newsType!!,page!!,num)
        isPrepared=false
    }

    var totalItemCount:Int=0
    var lastVisibleItem:Int=0
    var visibleItemCount:Int=0
    var firstVisibleItem:Int=0
    fun initViews(){
        news_rcv.layoutManager=LinearLayoutManager(activity)
        news_rcv.adapter=adapter
        news_rcv.itemAnimator.addDuration=0
        var mScrollListener = object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (RecyclerView.SCROLL_STATE_IDLE == newState) {
                    if (!isRefresh && totalItemCount <= lastVisibleItem + 1 && totalItemCount > visibleItemCount && visibleItemCount > 0) {
                        this@NewsFragment.page++
                        mPresenter?.fetchNews(newsType!!,page!!,num)
                    }
                }
            }

            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                    val layoutManager = recyclerView?.layoutManager as LinearLayoutManager
                    totalItemCount = layoutManager.getItemCount()
                    firstVisibleItem = layoutManager.findFirstVisibleItemPosition()
                    lastVisibleItem = layoutManager.findLastVisibleItemPosition()
                    visibleItemCount = layoutManager.getChildCount()
            }

        }
        news_rcv.addOnScrollListener(mScrollListener)
        adapter?.addFooters(LayoutInflater.from(activity).inflate(R.layout.item_footer,news_rcv,false))
        swl.setOnRefreshListener(this)
    }

    fun initDatas(){
        newsType=arguments.getInt("type")
        mPresenter= NewsPresenter(this)
        adapter= NewsAdapter(datas,activity)
        page=0
    }

    override fun onNewsFetched(resp: BaseBean<List<NewsBean>>) {
        swl?.isRefreshing=false
        Log.d("TAG","get resp: "+resp.toString())
        if (resp.code==200){
            Log.d("TAG","news fetched")
            if (page==0){
                Log.d("TAG","clear data")
                adapter?.clearData()
            }
            adapter?.addDatas(resp.newslist)
        }
    }

    override fun onNewsFetchedFailed(throwble: Throwable) {
        swl?.isRefreshing=false
        Log.d("TAG","get resp error: "+throwble.toString())

    }

    override fun onRefresh() {
        swl?.isRefreshing=true
        page=0;
        mPresenter?.fetchNews(newsType!!,page!!,num)
    }
}