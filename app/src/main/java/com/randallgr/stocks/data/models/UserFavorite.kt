package com.randallgr.stocks.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "favorites_table", primaryKeys = ["symbol", "financialType"])
data class UserFavorite(
    @ColumnInfo
    val symbol: String,

    @ColumnInfo
    val financialType: FinancialType
)