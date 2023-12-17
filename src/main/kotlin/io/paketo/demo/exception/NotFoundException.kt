package io.paketo.demo.exception

import org.springframework.http.HttpStatus

class NotFoundException(message: String) :
    CustomException(message, HttpStatus.CONFLICT)