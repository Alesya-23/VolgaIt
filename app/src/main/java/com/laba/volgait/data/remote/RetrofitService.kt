package com.laba.volgait.data.remote

import com.laba.volgait.model.models.Stock
import com.laba.volgait.model.models.Stocks
import io.finnhub.api.apis.DefaultApi
import io.finnhub.api.infrastructure.Response
import io.finnhub.api.models.TickData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import io.finnhub.api.infrastructure.ApiClient

interface RetrofitService {

    val apiClient: DefaultApi
    val ApiClient.apiKey["token"] = "c8f19a2ad3ibvc83srs0"

    @GET("/stock/tick")
    suspend fun getAllMovies() : List<TickData>

    companion object {
        var retrofitService: RetrofitService? = null

        fun getInstance() : RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://finnhub.io/c8f19a2ad3ibvc83srs0/v1")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }

    }

    fun technicalIndicator() {
        println(
            apiClient.technicalIndicator(
                symbol = "AAPL",
                resolution = "D",
                from = 1583098857L,
                to = 1584308457L,
                indicator = "sma",
                indicatorFields = mapOf<String, Any>("timeperiod" to 3)
            )
        )
    }

    fun stockSymbols() {
        println(apiClient.stockSymbols("US", "", "", ""))
    }
}
