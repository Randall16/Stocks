package com.randallgr.stocks.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "crypto_table")
data class CryptoItem(@PrimaryKey
                      @ColumnInfo
                      override val symbol: String,

                      @ColumnInfo
                      override val name: String,

                      @ColumnInfo
                      override val latestPrice: Double,

                      @ColumnInfo
                      override val change24Hour: Double,

                      @ColumnInfo
                      override val change24HourPercent: Double,

                      @ColumnInfo
                      override val imageURL: String?)
    : FinancialListItem {

    @Ignore // NEED TO ADD TYPE CONVERTER TO HANDLE SAVING ENUM
    override val financialType: FinancialType = FinancialType.Cryptocurrency

    @ColumnInfo
    var isTopListResponse: Boolean = false

    @ColumnInfo
    var isFavorite: Boolean = false
}