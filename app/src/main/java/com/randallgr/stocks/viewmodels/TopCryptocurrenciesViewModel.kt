package com.randallgr.stocks.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.randallgr.stocks.data.repositories.CryptocurrencyRepository

class TopCryptocurrenciesViewModel(application: Application) : AndroidViewModel(application) {

    private val cryptocurrencyRepository: CryptocurrencyRepository

    init {
        cryptocurrencyRepository = CryptocurrencyRepository.getInstance(application)
        cryptocurrencyRepository.updatePrices()
        Log.d("inViewModel", "running")
    }

    // Public methods/fields
    val items = cryptocurrencyRepository.cryptocurrenciesList

    fun updatePrices() {
        cryptocurrencyRepository.updatePrices()
    }
}