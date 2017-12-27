package com.jim.newsclient.module.home

import android.os.Bundle
import android.support.v4.app.Fragment
import com.jim.newsclient.R
import com.jim.newsclient.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),MainActivityView {

    var adapter:HomeVpAdapter?=null
    var fragments:List<Fragment>?=null
    var presenter:MainAcivityPresenter?=null

    override fun LayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDatas()
        initView()
    }

    fun initDatas(){
        presenter= MainAcivityPresenter(this)
        fragments=ArrayList<Fragment>()
        presenter?.fetchFragments(7)
    }

    fun initView() {
        adapter= HomeVpAdapter(supportFragmentManager,fragments!!)
        vp.adapter=adapter
        vp.offscreenPageLimit=5
        tablayout.setupWithViewPager(vp)
    }

    override fun onFragmentsFetched(fragmentlist: List<Fragment>) {
        fragments=fragmentlist
    }
}
