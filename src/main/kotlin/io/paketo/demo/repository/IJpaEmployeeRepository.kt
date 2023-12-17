package io.paketo.demo.repository

import io.paketo.demo.entity.EmployeeModel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface IJpaEmployeeRepository: JpaRepository<EmployeeModel, Long> {

    fun findByDni(dni: Long): Optional<EmployeeModel>
}