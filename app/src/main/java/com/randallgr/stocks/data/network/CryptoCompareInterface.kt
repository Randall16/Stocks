package com.randallgr.stocks.data.network

import com.randallgr.stocks.data.models.CryptoTopListResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET

interface CryptoCompareInterface {

    @GET("top/totalvolfull?limit=20&tsym=USD")
    fun getTopListByVolume(): Deferred<CryptoTopListResponse>
}