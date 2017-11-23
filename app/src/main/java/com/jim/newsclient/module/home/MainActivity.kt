package com.jim.newsclient.module.home

import android.os.Bundle
import com.jim.newsclient.R
import com.jim.newsclient.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun LayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()

    }

    fun initView() {
        vp.adapter
    }
}
