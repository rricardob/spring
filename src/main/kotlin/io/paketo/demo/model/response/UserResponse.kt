package io.paketo.demo.model.response

import io.paketo.demo.enums.Rol

data class UserResponse(
    var id: Long,
    var user: String,
    var pass: String,
    var status: Boolean,
    var rol: Rol
)