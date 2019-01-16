package com.randallgr.stocks.data.database

import androidx.room.TypeConverter
import com.randallgr.stocks.data.models.FinancialType


class Converters {

    @TypeConverter
    fun fromFinancialTypeString(value: String) = FinancialType.valueOf(value)

    @TypeConverter
    fun toFinancialTypeString(value: FinancialType) = value.toString()
}