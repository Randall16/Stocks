package com.randallgr.stocks.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.randallgr.stocks.data.database.Converters
import org.jetbrains.annotations.NotNull
import java.util.Date

@Entity(tableName = "crypto_table")
data class CryptoItem(
    @PrimaryKey
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
    override val marketCap: Double?,

    @ColumnInfo
    override val imageURL: String?,

    @ColumnInfo
    override val timeLastRefreshed: Date

) : FinancialListItem {

    @Ignore
    override val financialType: FinancialType = FinancialType.Cryptocurrency


}