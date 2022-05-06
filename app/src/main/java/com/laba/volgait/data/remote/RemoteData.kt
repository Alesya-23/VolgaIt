package com.laba.volgait.data.remote

import com.laba.volgait.data.Resource
import com.laba.volgait.model.models.Stock
import com.laba.volgait.model.models.Stocks

class RemoteData {

    suspend fun requestStocks(): Resource<Stocks> {
        val response = processCall()
        return Resource.Success(data = Stocks(response as ArrayList<Stock>))
    }

    private suspend fun processCall() {
    }
}