package com.jim.newsclient.module.news

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jim.newsclient.R
import com.jim.newsclient.base.BaseViewHolder
import com.jim.newsclient.module.news.model.NewsBean

/**
 * Created by Jim on 2017/12/5.
 */
class NewsAdapter(var datas:ArrayList<NewsBean>,var context:Context):RecyclerView.Adapter<BaseViewHolder>(){

    private var footers:HashMap<Int,View>
    private var headers:HashMap<Int,View>
    val baseItemFooter=10001
    val baseItemHeader=20001;

    init {
        footers= HashMap()
        headers= HashMap()
    }

    fun addDatas(datas: List<NewsBean>){
        this.datas.addAll(datas)
        notifyItemRangeChanged(this.datas.size-datas.size,datas.size)
        Log.d("NewsAdapter","size: "+this.datas.size)
    }

    fun addHeaders(view:View){
        headers?.put(baseItemFooter+headers.size,view)
    }

    fun addFooters(view: View){
        footers?.put(baseItemFooter+footers.size,view)
    }

    fun clearData(){
        datas?.clear()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder {
        var v=LayoutInflater.from(context).inflate(R.layout.item_news,parent,false)
        return BaseViewHolder(v,context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        Log.d("NewsAdapter","datas: "+datas[position].title+" "+datas[position].ctime+" "+datas[position].picUrl)
        holder.setText(R.id.news_title,datas[position].title)
        holder.setText(R.id.news_time,datas[position].ctime)
        holder?.setImageWithUrl(R.id.news_head_img,datas[position].picUrl)
    }

    override fun getItemCount(): Int {
        return datas.size+headers!!.size+footers!!.size
    }

    private fun isHeaderView(position:Int):Boolean{
        return position<headers!!.size
    }

    private fun isFooterView(position:Int):Boolean{
        return position>=headers!!.size+datas.size
    }
//
//    override fun getItemViewType(position: Int): Int {
//        if (isFooterView(position)){
//            return footers.
//        }else if (isHeaderView(position)){
//            return
//        }
//    }

}