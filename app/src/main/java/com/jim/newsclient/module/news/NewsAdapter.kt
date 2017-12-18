package com.jim.newsclient.module.news

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jim.newsclient.R
import com.jim.newsclient.base.BaseViewHolder
import com.jim.newsclient.module.news.model.NewsBean

/**
 * Created by Jim on 2017/12/5.
 */
class NewsAdapter(var datas:ArrayList<NewsBean>,var context:Context):RecyclerView.Adapter<BaseViewHolder>(){

    fun addDatas(datas: List<NewsBean>){
        this.datas.addAll(datas)
//        notifyItemRangeChanged(this.datas.size-datas.size-1,datas.size)
        Log.d("NewsAdapter","size: "+this.datas.size)
        notifyDataSetChanged();
    }

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