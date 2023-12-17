package io.paketo.demo.mapper

import io.paketo.demo.entity.UserModel
import io.paketo.demo.model.request.UserRequest
import io.paketo.demo.model.response.UserResponse
import org.springframework.stereotype.Component

@Component
class UserMapper {
    fun asEntity(request: UserRequest): UserModel {
        return UserModel(user = request.user, pass = request.pass, status = request.status, rol = request.rol)
    }

    fun asResponse(entity: UserModel): UserResponse {
        return UserResponse(
            id = entity.id,
            user = entity.user,
            pass = entity.pass,
            status = entity.status,
            rol = entity.rol
        )
    }
}