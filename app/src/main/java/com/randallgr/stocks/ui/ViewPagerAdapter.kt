/**
 * This adapter class is what allowed for the fragments to be scrollable. Each of the
 * container fragments will have one these adapters to manage its children fragments.
 */

package com.randallgr.stocks.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
    private val fragments = ArrayList<Fragment>()
    private val titles = ArrayList<String>()

    override fun getItem(position: Int): Fragment = fragments.get(position)

    override fun getCount(): Int = fragments.size

    override fun getPageTitle(position: Int): CharSequence? = titles.get(position)

    fun addFragment(fragment: Fragment, title: String) {
        fragments.add(fragment)
        titles.add(title)
    }

}