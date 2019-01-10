package com.randallgr.stocks.data.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API_Client_Instance {

    private const val CryptoCompare_Base_URL = "https://min-api.cryptocompare.com/data/"
    private const val IEX_BASE_URL = "https://api.iextrading.com/1.0/stock/"

    val CryptoCompare_API_INSTANCE = Retrofit.Builder()
        .baseUrl(CryptoCompare_Base_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(CryptoCompareInterface::class.java)

    val IEX_API_INSTANCE = Retrofit.Builder()
        .baseUrl(IEX_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(IEXInterface::class.java)

}