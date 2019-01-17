package com.randallgr.stocks.data.database

import android.os.Build.VERSION_CODES.O
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.randallgr.stocks.data.models.CryptoItem

@Dao
interface CryptoDao {

    @Query("SELECT * FROM crypto_table ORDER BY listRanking")
    fun getAllCryptocurrencies(): LiveData<List<CryptoItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(cryptoItem: CryptoItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(cryptoItem: List<CryptoItem>)

    @Query("DELETE FROM crypto_table WHERE symbol NOT IN " +
            " (SELECT symbol FROM favorites_table WHERE financialType = 'Cryptocurrency') ")
    fun deleteNonFavorites()


}