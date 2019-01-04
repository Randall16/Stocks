package com.randallgr.stocks.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.randallgr.stocks.data.models.CryptoItem


@Database(entities = [CryptoItem::class], version = 1 )
abstract class AppDatabase : RoomDatabase() {

    abstract fun cryptoDao(): CryptoDao
    // add stocks Dao here

    // Singleton instantiation
    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {

            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "Stocks_database"
            ).build()
            INSTANCE = instance

            return instance
        }
    }
}