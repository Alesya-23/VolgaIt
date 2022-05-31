package com.laba.volgait.error

interface ErrorUseCase {
    fun getError(errorCode: Int): Error
}