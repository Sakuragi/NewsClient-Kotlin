package com.jim.newsclient.module.home

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * Created by Jim on 2017/11/21.
 */
class HomeVpAdapter(val fm: FragmentManager, val fragments: List<Fragment>) : FragmentStatePagerAdapter(fm) {

    var titles = arrayOf("世界，娱乐，新闻，健康，苹果,热文，科技")

    override fun getCount(): Int = fragments.size

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getPageTitle(position: Int): CharSequence = titles[position]

}
