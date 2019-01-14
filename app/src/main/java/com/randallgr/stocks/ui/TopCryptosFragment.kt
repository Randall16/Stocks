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
import com.randallgr.stocks.viewmodels.TopCryptosViewModel


class TopCryptosFragment : Fragment() {

    private lateinit var topCryptosViewModel: TopCryptosViewModel
    private lateinit var adapter: FinancialListItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_top_cryptos, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.cryptocurrenciesRecyclerView)
        adapter = FinancialListItemAdapter(requireContext())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        subscribe()

        val ref = view.findViewById<SwipeRefreshLayout>(R.id.swipeRefreshLayout)

        ref.setOnRefreshListener{
            topCryptosViewModel.updateTopPrices()
            ref.isRefreshing = false
        }

        return view
    }

    private fun subscribe() {

        // find viewModel
        topCryptosViewModel = ViewModelProviders.of(requireActivity())
            .get(TopCryptosViewModel::class.java)

        // observe live data in viewModel
        topCryptosViewModel.topCryptocurrencies.observe(this, Observer { financialItems ->
            financialItems?.let { adapter.setFinancialItems(it) }
        })

    }


}
