package com.randallgr.stocks.ui


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get

import com.randallgr.stocks.R
import com.randallgr.stocks.data.models.CryptoTopListResponse
import com.randallgr.stocks.data.network.API_Client_Instance
import com.randallgr.stocks.viewmodels.TopCryptocurrenciesViewModel
import kotlinx.android.synthetic.main.fragment_top_cryptocurrencies.view.*
import retrofit2.Call
import retrofit2.Response


class TopCryptocurrenciesFragment : Fragment() {

    private lateinit var topCryptocurrenciesViewModel: TopCryptocurrenciesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_top_cryptocurrencies, container, false)

        subscribe()



        return view
    }

    private fun subscribe() {

        // find viewModel
        topCryptocurrenciesViewModel = ViewModelProviders.of(this)
            .get(TopCryptocurrenciesViewModel::class.java)


    }


}
