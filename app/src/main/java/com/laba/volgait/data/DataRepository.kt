package com.laba.volgait.data

import com.laba.volgait.data.remote.RemoteData
import com.laba.volgait.model.models.Stocks
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

class DataRepository constructor(
        private val remoteRepository: RemoteData, private val ioDispatcher: CoroutineContext
) : DataRepositorySource {

    override suspend fun requestStocks(): Flow<Resource<Stocks>> {
        return flow {
            emit(remoteRepository.requestStocks())
        }.flowOn(ioDispatcher)
    }
}