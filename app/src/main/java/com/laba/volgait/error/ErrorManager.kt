package com.laba.volgait.error

import com.laba.volgait.data.error.mapper.ErrorMapper

class ErrorManager constructor(private val errorMapper: ErrorMapper) : ErrorUseCase {
    override fun getError(errorCode: Int): Error {
        return Error(code = errorCode, description = errorMapper.errorsMap.getValue(errorCode))
    }
}