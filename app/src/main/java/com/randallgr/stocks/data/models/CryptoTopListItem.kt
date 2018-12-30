/**
 * This class stores the relevant information for each cryptocurrency in the API's response.
 * */
package com.randallgr.stocks.data.models

data class CryptoTopListItem(
    val name: String,
    val symbol: String,
    val imageUrl: String,
    val price: Double,
    val change24Hour: Double,
    val change24HourPercent: Double
)