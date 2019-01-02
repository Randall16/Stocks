/**
 *  This class is a singleton.
 */
package com.randallgr.stocks.data.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.randallgr.stocks.data.models.CryptoTopListResponse
import com.randallgr.stocks.data.models.FinancialItem
import com.randallgr.stocks.data.network.API_Client_Instance
import retrofit2.Call
import retrofit2.Response

class CryptocurrencyRepository private constructor (application: Application) {

    // Private members
    private val cryptoCompareAPI = API_Client_Instance.CryptoCompare_API_INSTANCE

    private val _cryptocurrenciesList = MutableLiveData<List<FinancialItem>>()

    // Public members/functions
    val cryptocurrenciesList: LiveData<List<FinancialItem>>
        by lazy { _cryptocurrenciesList}


    fun updatePrices() {
       cryptoCompareAPI.getTopListByVolume().enqueue(object: retrofit2.Callback<CryptoTopListResponse>{
           override fun onResponse(call: Call<CryptoTopListResponse>, response: Response<CryptoTopListResponse>) {

               _cryptocurrenciesList.postValue(response.body()?.toList())

           }

           override fun onFailure(call: Call<CryptoTopListResponse>, t: Throwable) {
               // handle error
           }
       })
    }


    // Static methods
    companion object {

        @Volatile
        private var INTSANCE: CryptocurrencyRepository? = null


        // Standard singleton instantiation
        fun getInstance(application: Application): CryptocurrencyRepository {
            return INTSANCE ?: synchronized(this) {
                INTSANCE ?: CryptocurrencyRepository(application).also { INTSANCE = it }
                // The also method ensures that the INSTANCE gets assigned the new creation
            }
        }
    }
}