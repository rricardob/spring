package io.paketo.demo.validation

import org.hibernate.exception.ConstraintViolationException
import org.springframework.stereotype.Component
import org.springframework.validation.Validator


@Component
class ValidationUtil(val validator: Validator) {

    fun validate(any: Any) {
        /*val result = validator.validate(any)
        if (result.size != 0) {
            throw ConstraintViolationException(result)
        }*/
    }

}