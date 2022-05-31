package com.laba.volgait.data.remote

import com.laba.volgait.model.models.Stock
import retrofit2.Response
import retrofit2.http.GET

interface FinhubApiService {

    @GET("/stock/symbol?exchange=US")
    suspend fun getStocks(): Response<List<Stock>>
}

