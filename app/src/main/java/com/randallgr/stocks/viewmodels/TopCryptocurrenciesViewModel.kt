package com.randallgr.stocks.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.randallgr.stocks.data.repositories.CryptocurrencyRepository

class TopCryptocurrenciesViewModel(application: Application) : AndroidViewModel(application) {

    private val cryptocurrencyRepository: CryptocurrencyRepository

    init {
        cryptocurrencyRepository = CryptocurrencyRepository.getInstance(application)
    }

    val items = cryptocurrencyRepository.cryptocurrenciesList
}