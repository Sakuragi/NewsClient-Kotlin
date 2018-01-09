package com.flying.xiaopo.poishuhui_kotlin

import android.content.Context
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jim.newsclient.R

/**
 * @author wupanjie
 */
fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
  Toast.makeText(this, message, duration).show()
}

fun View.snackbar(message: String, duration: Int = Snackbar.LENGTH_SHORT) {
  Snackbar.make(this, message, duration).show()
}

fun View.snackbar(messageRes: Int, duration: Int = Snackbar.LENGTH_SHORT) {
  Snackbar.make(this, messageRes, duration).show()
}

fun Any.log(message: String) {
  Log.e(this.javaClass.simpleName, message)
}


fun WebView.load(html: String) {
  this.loadDataWithBaseURL("http://ishuhui.net/", html, "text/html", "charset=utf-8", null)
}

fun ImageView.loadUrl(url: String) {
  var options = RequestOptions()
          .centerCrop()
          .placeholder(R.drawable.ic_img_defult)
          .error(R.drawable.ic_img_defult)
  Glide.with(this.context).load(url).apply(options).into(this)
}