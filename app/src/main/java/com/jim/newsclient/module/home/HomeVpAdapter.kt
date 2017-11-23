package com.jim.newsclient.module.home

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * Created by Jim on 2017/11/21.
 */
class HomeVpAdapter(val fm:FragmentManager,val fragments:List<Fragment>):FragmentStatePagerAdapter(fm){

    var titles= arrayOf("")

    override fun getCount(): Int {
        return fragments?.size
    }

    override fun getItem(position: Int): Fragment {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPageTitle(position: Int): CharSequence {
        return super.getPageTitle(position)
    }

}
