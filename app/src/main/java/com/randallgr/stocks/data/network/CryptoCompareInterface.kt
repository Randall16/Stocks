package com.randallgr.stocks.data.network

import com.randallgr.stocks.data.models.CryptoTopListResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface CryptoCompareInterface {

    @GET("top/mktcapfull?limit=20&tsym=USD")
    fun fetchTopListByMarketCap(): Deferred<CryptoTopListResponse>
}