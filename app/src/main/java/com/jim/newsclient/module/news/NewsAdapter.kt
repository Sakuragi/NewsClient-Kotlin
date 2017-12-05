package com.jim.newsclient.module.news

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jim.newsclient.R
import com.jim.newsclient.base.BaseViewHolder
import com.jim.newsclient.module.news.model.NewsBean

/**
 * Created by Jim on 2017/12/5.
 */
class NewsAdapter(var datas:List<NewsBean>,var context:Context):RecyclerView.Adapter<BaseViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder {
        var v=LayoutInflater.from(context).inflate(R.layout.item_news,parent,false)
        return BaseViewHolder(v,context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder?, position: Int) {
        holder?.setText(R.id.news_title,datas[position].title)
        holder?.setText(R.id.news_time,datas[position].ctime)
        holder?.setImageWithUrl(R.id.news_head,datas[position].picUrl)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

}