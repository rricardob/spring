package io.paketo.demo.repository

import io.paketo.demo.entity.UserModel
import org.springframework.data.jpa.repository.JpaRepository

interface IJpaUserRepository: JpaRepository<UserModel, Long> {
}