package com.laba.volgait.model.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Stock(
        @SerializedName("currency")
        @Expose
        val currency: String,
        @SerializedName("description")
        @Expose
        val description: String,
        @SerializedName("displaySymbol")
        @Expose
        val displaySymbol: String,
        @SerializedName("figi")
        @Expose
        val figi: String,
        @SerializedName("mic")
        @Expose
        val mic: String,
        @SerializedName("symbol")
        @Expose
        val symbol: String,
        @SerializedName("type")
        @Expose
        val type: String
)