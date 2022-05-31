package com.laba.volgait.utils

import android.net.NetworkInfo

interface NetworkConnectivity {
    fun getNetworkInfo(): NetworkInfo?
    fun isConnected(): Boolean
}