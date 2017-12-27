package com.jim.newsclient.module.web

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import android.widget.ProgressBar

import com.jim.newsclient.R
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {


    companion object {
        fun start(context: Context, data: String) {
            val intent = Intent(context, WebActivity::class.java)
            intent.putExtra("url", data)
            context.startActivity(intent)
        }
    }

    override fun onCreate(onSavedInstanceState: Bundle?) {
        super.onCreate(onSavedInstanceState)
        setContentView(R.layout.activity_web_layout)
        val url = intent.getStringExtra("url")
        val webSettings = web_view.settings
        webSettings.javaScriptEnabled = true
        webSettings.setSupportZoom(true)
        webSettings.layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN
        webSettings.setAppCacheEnabled(true)
        web_view.loadUrl(url)
        web_view.setWebViewClient(Client())
    }

    override fun onDestroy() {
        super.onDestroy()
        if (web_view != null) {
            rl_content?.removeView(web_view)
            web_view?.removeAllViews()
            web_view?.destroy()
        }
    }

    private inner class Client : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView, url: String?): Boolean {
            if (url != null) {
                view.loadUrl(url)
            }
            return true
        }

        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
            pb_bar?.visibility = View.GONE
        }
    }
}
