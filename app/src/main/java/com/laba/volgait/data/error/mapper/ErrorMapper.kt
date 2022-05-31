package com.laba.volgait.data.error.mapper

import android.content.Context
import com.laba.volgait.R
import com.laba.volgait.error.*
import com.laba.volgait.data.error.NETWORK_ERROR
import com.laba.volgait.data.error.NO_INTERNET_CONNECTION

class ErrorMapper constructor(val context: Context) : ErrorMapperSource {
    override fun getErrorString(errorId: Int): String {
        return context.getString(errorId)
    }

    override val errorsMap: Map<Int, String>
        get() = mapOf(
            Pair(NO_INTERNET_CONNECTION, getErrorString(R.string.no_internet)),
            Pair(NETWORK_ERROR, getErrorString(R.string.network_error)),
        ).withDefault { getErrorString(R.string.network_error) }
}
