package com.laba.volgait.data

import com.laba.volgait.model.models.Stocks
import kotlinx.coroutines.flow.Flow

interface DataRepositorySource {
    suspend fun requestStocks(): Flow<Resource<Stocks>>
}