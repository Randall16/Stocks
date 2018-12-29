package com.randallgr.stocks.data.network

import com.randallgr.stocks.data.models.BookResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IEXInterface {

    @GET("{symbol}/book/quote")
    fun getBook(@Path("symbol")symbol: String): Call<BookResponse>
}