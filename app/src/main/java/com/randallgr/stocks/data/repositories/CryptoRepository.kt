/**
 *  This class is a singleton.
 */
package com.randallgr.stocks.data.repositories

import android.app.Application
import android.util.Log
import androidx.annotation.WorkerThread
import com.randallgr.stocks.data.database.AppDatabase
import com.randallgr.stocks.data.network.API_Client_Instance

class CryptoRepository private constructor (application: Application) {

    // Private members
    private val cryptoCompareAPI = API_Client_Instance.CryptoCompare_API_INSTANCE
    private val cryptoDao = AppDatabase.getInstance(application).cryptoDao()

    @WorkerThread
    suspend fun updatePrices() {
        val responseList = cryptoCompareAPI.fetchTopListByMarketCap().await().toList()

        cryptoDao.insert(responseList)
    }

    fun getTopListCryptos() = cryptoDao.getAllCryptocurrencies()


    // Static methods
    companion object {

        @Volatile
        private var INTSANCE: CryptoRepository? = null


        // Standard thread safe singleton instantiation
        fun getInstance(application: Application): CryptoRepository {
            return INTSANCE ?: synchronized(this) {
                INTSANCE ?: CryptoRepository(application).also { INTSANCE = it }
                // The also method ensures that the INSTANCE gets assigned the new creation
            }
        }
    }
}