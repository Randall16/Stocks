package com.randallgr.stocks.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API_Client_Instance {

    private const val IEX_BASE_URL = "https://api.iextrading.com/1.0/stock/"

    val IEX_API_INSTANCE = Retrofit.Builder()
        .baseUrl(IEX_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(IEXInterface::class.java)

}