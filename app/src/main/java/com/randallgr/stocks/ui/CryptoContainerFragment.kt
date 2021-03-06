package com.randallgr.stocks.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager

import com.randallgr.stocks.R
import kotlinx.android.synthetic.main.fragment_crypto_container.view.*


class CryptoContainerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_crypto_container, container, false)

        setupViewPager(view.viewPager)
        view.tabs.setupWithViewPager(view.viewPager)

        return view
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val viewPagerAdapter = ViewPagerAdapter(childFragmentManager)
        viewPagerAdapter.addFragment(TopCryptosFragment(), "Top")
        viewPagerAdapter.addFragment(FavoriteStocksFragment(), "Favorites")
        viewPager.adapter = viewPagerAdapter
    }

}
