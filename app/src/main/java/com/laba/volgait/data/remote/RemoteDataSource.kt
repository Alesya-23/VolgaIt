package com.laba.volgait.data.remote

import com.laba.volgait.data.Resource
import com.laba.volgait.model.models.Stocks

internal interface RemoteDataSource {
    suspend fun requestStocks(): Resource<Stocks>
}