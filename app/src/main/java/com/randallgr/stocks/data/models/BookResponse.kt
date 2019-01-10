/**
 * The IEX API gives a bloated response when pulling Quote pricing. Alls that matters is the Quote JSON object
 * but it is nested inside of JSON object so this BookResponse class is here to hold that outer class. The data we
 * care about can be found in the Quote data class. The properties asks, bids, and systemEvent will likely be null.
 */

package com.randallgr.stocks.data.models

import com.google.gson.annotations.SerializedName


data class BookResponse(
    @SerializedName("asks")
    private val asks: List<Any>?,

    @SerializedName("bids")
    private val bids: List<Any>?,

    @SerializedName("quote")    // This property is the one holding all the relevant data
    val quote: Quote,

    @SerializedName("systemEvent")
    private  val systemEvent: Any?
)

data class Quote(
    val avgTotalVolume: Int,
    val calculationPrice: String,
    val change: Double,
    val changePercent: Double,
    val close: Double,
    val closeTime: Long,
    val companyName: String,
    val delayedPrice: Double,
    val delayedPriceTime: Long,
    val extendedChange: Double,
    val extendedChangePercent: Double,
    val extendedPrice: Double,
    val extendedPriceTime: Long,
    val high: Double,
    val iexAskPrice: Any,
    val iexAskSize: Any,
    val iexBidPrice: Any,
    val iexBidSize: Any,
    val iexLastUpdated: Any,
    val iexMarketPercent: Any,
    val iexRealtimePrice: Any,
    val iexRealtimeSize: Any,
    val iexVolume: Any,
    val latestPrice: Double,
    val latestSource: String,
    val latestTime: String,
    val latestUpdate: Long,
    val latestVolume: Int,
    val low: Double,
    val marketCap: Long,
    val open: Double,
    val openTime: Long,
    val peRatio: Double,
    val previousClose: Double,
    val primaryExchange: String,
    val sector: String,
    val symbol: String,
    val week52High: Double,
    val week52Low: Double,
    val ytdChange: Double
)