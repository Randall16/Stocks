/**
 * Each API returns data differently but this class acts as a bridge betweent them. It holds the information we care
 * about and that will displayed to the user.
 */
package com.randallgr.stocks.data.models

data class FinancialItem(
    val name: String,
    val symbol: String,
    val latestPrice: Double,
    val change24Hour: Double,
    val change24HourPercent: Double,
    var imageURL: String? = null
) {

}