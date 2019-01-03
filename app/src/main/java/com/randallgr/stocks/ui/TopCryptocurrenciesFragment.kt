package com.randallgr.stocks.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.randallgr.stocks.R
import com.randallgr.stocks.viewmodels.TopCryptocurrenciesViewModel


class TopCryptocurrenciesFragment : Fragment() {

    private lateinit var topCryptocurrenciesViewModel: TopCryptocurrenciesViewModel
    private lateinit var adapter: FinancialItemListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_top_cryptocurrencies, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.cryptocurrenciesRecyclerView)
        adapter = FinancialItemListAdapter(requireContext())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        subscribe()

        val ref = view.findViewById<SwipeRefreshLayout>(R.id.swipeRefreshLayout)

        ref.setOnRefreshListener{
            topCryptocurrenciesViewModel.updateTopPrices()
            ref.isRefreshing = false
        }

        return view
    }

    private fun subscribe() {

        // find viewModel
        topCryptocurrenciesViewModel = ViewModelProviders.of(requireActivity())
            .get(TopCryptocurrenciesViewModel::class.java)

        // observe live data in viewModel
        topCryptocurrenciesViewModel.topCryptocurrencies.observe(this, Observer { financialItems ->
            financialItems?.let { adapter.setFinancialItems(it) }
        })

    }


}
