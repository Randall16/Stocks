/**
 * This file is a bit of a mess. It contains multiple data classes to handle the API response when querying for the top
 * cryptocurrencies by volume. In the outer class we have function to convert this convoluted response into an easy to
 * work with list of ListItems.
 */

package com.randallgr.stocks.data.models

import java.util.*

data class CryptoTopListResponse(
    val Data: List<Data>,
    val HasWarning: Boolean,
    val Message: String,
    val RateLimit: Any?,
    val SponsoredData: List<Any>,
    val Type: Int
) {

    fun toList(): List<CryptoItem> {
        val answer = mutableListOf<CryptoItem>()

        val time = Calendar.getInstance().time
        for(i in Data) {

            // Extract the info we care about
            val name = i.CoinInfo.FullName
            val symbol = i.CoinInfo.Name
            val imageUrl = i.CoinInfo.ImageUrl
            val price = i.RAW.USD.PRICE
            val change24Hour = i.RAW.USD.CHANGE24HOUR
            val change24HourPercent = i.RAW.USD.CHANGEPCT24HOUR
            val marketCap = i.RAW.USD.MKTCAP

            // Create CryptoItem
            val item = CryptoItem(symbol, name, price, change24Hour, change24HourPercent,
                marketCap, imageUrl, time)

            answer.add(item)
        }

        return answer
    }
}

data class Data(
    val CoinInfo: CoinInfo,
    val DISPLAY: DISPLAY,
    val RAW: RAW
)

data class RAW(
    val USD: USD
)

data class USD(
    val CHANGE24HOUR: Double,
    val CHANGEDAY: Double,
    val CHANGEPCT24HOUR: Double,
    val CHANGEPCTDAY: Double,
    val FLAGS: String,
    val FROMSYMBOL: String,
    val HIGH24HOUR: Double,
    val HIGHDAY: Double,
    val HIGHHOUR: Double,
    val LASTMARKET: String,
    val LASTTRADEID: String,
    val LASTUPDATE: Int,
    val LASTVOLUME: Double,
    val LASTVOLUMETO: Double,
    val LOW24HOUR: Double,
    val LOWDAY: Double,
    val LOWHOUR: Double,
    val MARKET: String,
    val MKTCAP: Double,
    val OPEN24HOUR: Double,
    val OPENDAY: Double,
    val OPENHOUR: Double,
    val PRICE: Double,
    val SUPPLY: Double,
    val TOSYMBOL: String,
    val TOTALVOLUME24H: Double,
    val TOTALVOLUME24HTO: Double,
    val TYPE: String,
    val VOLUME24HOUR: Double,
    val VOLUME24HOURTO: Double,
    val VOLUMEDAY: Double,
    val VOLUMEDAYTO: Double,
    val VOLUMEHOUR: Double,
    val VOLUMEHOURTO: Double
)

data class CoinInfo(
    val Algorithm: String,
    val BlockNumber: Double,
    val BlockReward: Double,
    val BlockTime: Double,
    val DocumentType: String,
    val FullName: String,
    val Id: String,
    val ImageUrl: String,
    val Internal: String,
    val Name: String,
    val NetHashesPerSecond: Double,
    val ProofType: String,
    val Type: Int,
    val Url: String
)

data class DISPLAY(
    val USD: USDStrings
)

data class USDStrings(
    val CHANGE24HOUR: String,
    val CHANGEDAY: String,
    val CHANGEPCT24HOUR: String,
    val CHANGEPCTDAY: String,
    val FROMSYMBOL: String,
    val HIGH24HOUR: String,
    val HIGHDAY: String,
    val HIGHHOUR: String,
    val LASTMARKET: String,
    val LASTTRADEID: String,
    val LASTUPDATE: String,
    val LASTVOLUME: String,
    val LASTVOLUMETO: String,
    val LOW24HOUR: String,
    val LOWDAY: String,
    val LOWHOUR: String,
    val MARKET: String,
    val MKTCAP: String,
    val OPEN24HOUR: String,
    val OPENDAY: String,
    val OPENHOUR: String,
    val PRICE: String,
    val SUPPLY: String,
    val TOSYMBOL: String,
    val TOTALVOLUME24H: String,
    val TOTALVOLUME24HTO: String,
    val VOLUME24HOUR: String,
    val VOLUME24HOURTO: String,
    val VOLUMEDAY: String,
    val VOLUMEDAYTO: String,
    val VOLUMEHOUR: String,
    val VOLUMEHOURTO: String
)