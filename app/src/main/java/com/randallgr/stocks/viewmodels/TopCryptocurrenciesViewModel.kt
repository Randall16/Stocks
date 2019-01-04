package com.randallgr.stocks.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.randallgr.stocks.data.models.CryptoItem
import com.randallgr.stocks.data.models.FinancialListItem
import com.randallgr.stocks.data.repositories.CryptocurrencyRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.android.Main


class TopCryptocurrenciesViewModel(application: Application) : AndroidViewModel(application) {

    // Private
    private val cryptocurrencyRepository: CryptocurrencyRepository
    private val _topCryptocurrencies = MutableLiveData<List<CryptoItem>>()

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)


    // Public
    val topCryptocurrencies: LiveData<List<CryptoItem>> by lazy { _topCryptocurrencies }

    init {
        cryptocurrencyRepository = CryptocurrencyRepository.getInstance(application)
        updateTopPrices()
    }

    fun updateTopPrices() {

        // using coroutine
        uiScope.launch {
            val temp = async {cryptocurrencyRepository.updatePrices()}
            _topCryptocurrencies.postValue( temp.await() )
        }

    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}