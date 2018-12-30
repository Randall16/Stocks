package com.randallgr.stocks.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.randallgr.stocks.R
import kotlinx.android.synthetic.main.fragment_stocks_container.view.*


class StocksContainerFragment : Fragment() {

    //private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_stocks_container, container, false)


        //viewPagerAdapter = activity!!.findViewById<ViewPagerAdapter>(R.id.viewpager)


        setupViewPager(view.viewPager)

        view.tabs.setupWithViewPager(view.viewPager)

        return view
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val mAdapter = ViewPagerAdapter(this.childFragmentManager)
        mAdapter.addFragment(TopCryptocurrenciesFragment(), "Frag1")
        mAdapter.addFragment(FavoriteStocksFragment(), "Frag2")
        viewPager.adapter = mAdapter
    }
}
