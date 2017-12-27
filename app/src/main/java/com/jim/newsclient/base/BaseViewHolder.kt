package com.jim.newsclient.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.util.SparseArray
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jim.newsclient.R

/**
 * Created by Jim on 2017/12/5.
 */
class BaseViewHolder(itemView: View, val context: Context) : RecyclerView.ViewHolder(itemView) {
    var mViews: SparseArray<View>? = null

    init {
        mViews = SparseArray()
    }


    private fun <T> getView(viewId: Int): T {
        var v = mViews?.get(viewId)
        if (v == null) {
            v = itemView.findViewById(viewId)
            mViews?.put(viewId, v)
        }
        Log.d("BaseViewHolder","run next")
        return v as T
    }

    fun setText(viewId: Int, value: CharSequence) {
        var v = getView<TextView>(viewId)
        v?.text = value
    }

    fun setText(viewId: Int, value: String) {
        var v = getView<TextView>(viewId)
        v?.text = value
    }

    fun setImageWithUrl(viewId: Int, url: String) {
        if (url==null){
            return
        }
        var v = getView<ImageView>(viewId)
        if (v==null){
            return
        }
        var options = RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_img_defult)
                .error(R.drawable.ic_img_defult)
        Glide.with(context).load(url).apply(options).into(v)
    }

    fun setImagSource(viewId: Int, sourceId: Int) {
        var v = getView<ImageView>(viewId)
        var options = RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_img_defult)
                .error(R.drawable.ic_img_defult)
        Glide.with(context).load(sourceId).apply(options).into(v)
    }

    fun setOnClickListener(viewId:Int,listener:View.OnClickListener){
        var v = getView<View>(viewId)
        v?.setOnClickListener(listener)
    }

}