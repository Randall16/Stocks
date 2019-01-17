/**
 * Each API returns data differently but this interface acts as a bridge betweent them. It holds the information we care
 * about and that will displayed to the user. By abstracting out the similarities between a stock and cryptocurrency
 * I will be able to reuse a lot of UI components when displaying them.
 */

package com.randallgr.stocks.data.models

import org.jetbrains.annotations.NotNull
import java.util.Date

interface FinancialListItem {

    val symbol: String
    val name: String
    val latestPrice: Double
    val change24Hour: Double
    val change24HourPercent: Double
    val imageURL: String?
    val financialType: FinancialType
    val marketCap: Double?
    val timeLastRefreshed: Date
}