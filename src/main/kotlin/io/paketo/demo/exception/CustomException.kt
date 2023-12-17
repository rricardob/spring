package io.paketo.demo.exception

import org.springframework.http.HttpStatus

open class CustomException(
    message: String, val httpStatus: HttpStatus
) : Exception(message)