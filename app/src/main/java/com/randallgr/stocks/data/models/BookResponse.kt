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