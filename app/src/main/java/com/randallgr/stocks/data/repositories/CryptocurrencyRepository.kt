/**
 *  This class is a singleton.
 */
package com.randallgr.stocks.data.repositories

import android.app.Application
import com.randallgr.stocks.data.database.AppDatabase
import com.randallgr.stocks.data.models.CryptoItem
import com.randallgr.stocks.data.network.API_Client_Instance
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class CryptocurrencyRepository private constructor (application: Application) {

    // Private members
    private val cryptoCompareAPI = API_Client_Instance.CryptoCompare_API_INSTANCE
    private val cryptoDao = AppDatabase.getInstance(application).cryptoDao()

    suspend fun updatePrices() {
        val responseList = cryptoCompareAPI.fetchTopListByMarketCap().await().toList()


        // Add each element in responseList to the database
        for(i in responseList)
            cryptoDao.insert(i)
    }

    fun getTopListCryptos() = cryptoDao.getAllCryptocurrencies()



    // Static methods
    companion object {

        @Volatile
        private var INTSANCE: CryptocurrencyRepository? = null


        // Standard thread safe singleton instantiation
        fun getInstance(application: Application): CryptocurrencyRepository {
            return INTSANCE ?: synchronized(this) {
                INTSANCE ?: CryptocurrencyRepository(application).also { INTSANCE = it }
                // The also method ensures that the INSTANCE gets assigned the new creation
            }
        }
    }
}