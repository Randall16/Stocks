package com.randallgr.stocks.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.randallgr.stocks.data.models.CryptoItem
import com.randallgr.stocks.data.repositories.CryptoRepository
import kotlinx.coroutines.*


class TopCryptosViewModel(application: Application) : AndroidViewModel(application) {

    // Private
    private val cryptoRepository: CryptoRepository = CryptoRepository.getInstance(application)

    private val viewModelJob = Job()
    private val backgroundScope = CoroutineScope(Dispatchers.IO + viewModelJob)


    // Public
    val topCryptocurrencies: LiveData<List<CryptoItem>> = cryptoRepository.getTopListCryptos()

    init {
        updateTopPrices()
    }

    // functions
    fun updateTopPrices() {

        // using coroutine
        backgroundScope.launch {
            val operation = async { cryptoRepository.updatePrices() }.await()
            // dismiss loading here
        }

    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}