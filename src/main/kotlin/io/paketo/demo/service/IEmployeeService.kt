package io.paketo.demo.service

import io.paketo.demo.model.request.EmployeeRequest
import io.paketo.demo.model.response.EmployeeResponse

interface IEmployeeService {

    fun findByDni(dni: Int): EmployeeResponse

    fun create(employeeRequest: EmployeeRequest): Long

    fun findById(id: Long): EmployeeResponse

    fun update(id: Long, employeeRequest: EmployeeRequest): EmployeeResponse?

    fun delete(id: Long)

    fun findAll(): List<EmployeeResponse>
}