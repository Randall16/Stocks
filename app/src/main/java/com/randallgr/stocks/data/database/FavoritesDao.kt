package com.randallgr.stocks.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.randallgr.stocks.data.models.UserFavorite


@Dao
interface FavoritesDao {

    @Insert
    fun addFavorite(userFavorite: UserFavorite)

    @Delete
    fun deleteFavorite(userFavorite: UserFavorite)

    @Query("SELECT symbol FROM favorites_table WHERE financialType = 'Cryptocurrency' ")
    fun getFavoriteCryptos(): LiveData<List<String>>



}