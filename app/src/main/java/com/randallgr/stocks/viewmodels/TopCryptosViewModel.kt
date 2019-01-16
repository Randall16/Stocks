package com.randallgr.stocks.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.randallgr.stocks.data.models.CryptoItem
import com.randallgr.stocks.data.repositories.CryptocurrencyRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.android.Main


class TopCryptosViewModel(application: Application) : AndroidViewModel(application) {

    // Private
    private val cryptocurrencyRepository: CryptocurrencyRepository = CryptocurrencyRepository.getInstance(application)

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)


    // Public
    val topCryptocurrencies: LiveData<List<CryptoItem>> = cryptocurrencyRepository.getTopListCryptos()

    init {
        updateTopPrices()
    }

    // functions
    fun updateTopPrices() {

        // using coroutine
        uiScope.launch {
            val operation = async { cryptocurrencyRepository.updatePrices() }.await()
            // dismiss loading here
        }

    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}