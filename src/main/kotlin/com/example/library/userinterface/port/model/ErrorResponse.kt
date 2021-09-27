package com.example.library.userinterface.port.model

class ErrorResponse(throwable: Throwable) {
    val error: String? = throwable::class.simpleName
    val message: String? = throwable.message
}