package com.randallgr.stocks.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.randallgr.stocks.data.models.CryptoItem

@Dao
interface CryptoDao {

    @Query("Select * from crypto_table")
    fun getAllCryptocurrencies(): LiveData<List<CryptoItem>>

    @Insert
    fun insert(cryptoItem: CryptoItem)

    @Query("Delete from crypto_table Where isFavorite = 0")
    fun deleteNonFavorites()


}