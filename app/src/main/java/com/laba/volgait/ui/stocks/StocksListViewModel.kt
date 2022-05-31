package com.laba.volgait.ui.stocks

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.laba.volgait.data.DataRepositorySource
import com.laba.volgait.data.Resource
import com.laba.volgait.model.models.Stocks
import com.laba.volgait.ui.base.BaseViewModel
import com.laba.volgait.utils.SingleEvent
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

public class StocksListViewModel
constructor(private val dataRepository: DataRepositorySource) : BaseViewModel() {
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val stocksLiveDataPrivate = MutableLiveData<Resource<Stocks>>()
    val stocksLiveData: LiveData<Resource<Stocks>> get() = stocksLiveDataPrivate

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val showToastPrivate = MutableLiveData<SingleEvent<Any>>()
    val showToast: LiveData<SingleEvent<Any>> get() = showToastPrivate


    fun getStocks() {
        viewModelScope.launch {
            stocksLiveDataPrivate.value = Resource.Loading()
            dataRepository.requestStocks().collect {
                stocksLiveDataPrivate.value = it
            }
        }
    }

    fun showToastMessage(errorCode: Int) {
        val error = errorManager.getError(errorCode)
        showToastPrivate.value = SingleEvent(error.description)
    }

}
