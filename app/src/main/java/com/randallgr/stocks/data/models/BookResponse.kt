package com.randallgr.stocks.data.models

import com.google.gson.annotations.SerializedName

data class BookResponse(
    @SerializedName("asks")
    val asks: List<Any>?,

    @SerializedName("bids")
    val bids: List<Any>?,

    @SerializedName("quote")
    val quote: Quote,

    @SerializedName("systemEvent")
    val systemEvent: Any?
)