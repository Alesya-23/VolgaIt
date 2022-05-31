package com.laba.volgait.data.remote

import com.laba.volgait.data.Resource
import com.laba.volgait.model.models.Stocks
import io.finnhub.api.models.StockSymbol
import com.laba.volgait.data.error.NETWORK_ERROR
import com.laba.volgait.data.error.NO_INTERNET_CONNECTION
import com.laba.volgait.utils.NetworkConnectivity
import retrofit2.Response
import java.io.IOException

class RemoteData constructor(
    private val serviceGenerator: ServiceGenerator,
    private val networkConnectivity: NetworkConnectivity
) : RemoteDataSource {

    override suspend fun requestStocks(): Resource<Stocks> {
        val stockService = serviceGenerator.createService(FinhubApiService::class.java)
        val response = processCall(stockService::getStocks)
        return Resource.Success(data = Stocks(response as ArrayList<StockSymbol>))
    }

    private suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {
        if (!networkConnectivity.isConnected()) {
            return NO_INTERNET_CONNECTION
        }
        return try {
            val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful) {
                response.body()
            } else {
                responseCode
            }
        } catch (e: IOException) {
            NETWORK_ERROR
        }
    }
}