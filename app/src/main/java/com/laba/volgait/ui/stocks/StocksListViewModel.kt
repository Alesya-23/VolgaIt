package com.laba.volgait.ui.stocks

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.laba.volgait.data.DataRepositorySource
import com.laba.volgait.data.Resource
import com.laba.volgait.model.models.Stocks
import com.laba.volgait.ui.base.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

public class StocksListViewModel
constructor(private val dataRepository: DataRepositorySource) : BaseViewModel() {
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val stocksLiveDataPrivate = MutableLiveData<Resource<Stocks>>()
    val stocksLiveData: LiveData<Resource<Stocks>> get() = stocksLiveDataPrivate

    fun getStocks() {
        viewModelScope.launch {
            stocksLiveDataPrivate.value = Resource.Loading()
            dataRepository.requestStocks().collect {
                stocksLiveDataPrivate.value = it
            }
        }
    }
}
