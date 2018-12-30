package com.randallgr.stocks.ui


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.randallgr.stocks.R
import com.randallgr.stocks.data.models.CryptoTopListResponse
import com.randallgr.stocks.data.network.API_Client_Instance
import kotlinx.android.synthetic.main.fragment_top_cryptocurrencies.view.*
import retrofit2.Call
import retrofit2.Response


class TopCryptocurrenciesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_top_cryptocurrencies, container, false)

        val api = API_Client_Instance.CryptoCompare_API_INSTANCE

        api.getTopListByVolume().enqueue(object: retrofit2.Callback<CryptoTopListResponse>{
            override fun onFailure(call: Call<CryptoTopListResponse>, t: Throwable) {

                Log.d("hehehe", t.message + "!!!")

            }

            override fun onResponse(call: Call<CryptoTopListResponse>, response: Response<CryptoTopListResponse>) {
                view.tv.text = response.body()?.Data?.get(0)?.RAW?.USD?.PRICE.toString()

                Log.d("hehehe", response.message())
            }
        })

        return view
    }


}
