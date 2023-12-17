package io.paketo.demo.service

import io.paketo.demo.model.request.UserRequest
import io.paketo.demo.model.response.UserResponse

interface IUserService {

    fun create(userRequest: UserRequest): Long

    fun findById(id: Long): UserResponse

    fun update(id: Long, userRequest: UserRequest): UserResponse?

    fun delete(id: Long)

    fun findAll(): List<UserResponse>

}