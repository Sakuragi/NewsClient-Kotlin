package com.jim.newsclient.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity

/**
 * Created by Jim on 2017/11/21.
 */
abstract class BaseActivity:AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(LayoutId())
    }

    @LayoutRes open abstract fun LayoutId():Int

}