package com.randallgr.stocks.data.database

import androidx.room.TypeConverter
import com.randallgr.stocks.data.models.FinancialType
import java.util.Date


class Converters {

    @TypeConverter
    fun StringToFinancialType(value: String) = FinancialType.valueOf(value)

    @TypeConverter
    fun FinancialTypeToString(financialType: FinancialType) = financialType.name

    @TypeConverter
    fun LongToDate(value: Long?) = value?.let { Date(it) }

    @TypeConverter
    fun DateToLong(date: Date?) = date?.time?.toLong()
}