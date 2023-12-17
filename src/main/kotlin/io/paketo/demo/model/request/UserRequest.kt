package io.paketo.demo.model.request

import io.paketo.demo.enums.Rol

data class UserRequest(
    val user: String,
    val pass: String,
    val status: Boolean,
    val rol: Rol
)