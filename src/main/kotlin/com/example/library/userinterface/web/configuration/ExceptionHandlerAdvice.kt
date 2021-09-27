package com.example.library.userinterface.web.configuration

import com.example.library.userinterface.port.model.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@ControllerAdvice
@RestController
class ExceptionHandlerAdvice {
    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable::class)
    fun error(throwable: Throwable): ErrorResponse {
        return ErrorResponse(throwable)
    }
}