/**
 *  This class is a singleton.
 */
package com.randallgr.stocks.data.repositories

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.randallgr.stocks.data.models.CryptoTopListResponse
import com.randallgr.stocks.data.models.FinancialItem
import com.randallgr.stocks.data.network.API_Client_Instance
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.coroutineScope
import retrofit2.Call
import retrofit2.Response

class CryptocurrencyRepository private constructor (application: Application) {

    // Private members
    private val cryptoCompareAPI = API_Client_Instance.CryptoCompare_API_INSTANCE

    suspend fun updatePrices(): List<FinancialItem> {

        return cryptoCompareAPI.getTopListByVolume().await().toList()

    }


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