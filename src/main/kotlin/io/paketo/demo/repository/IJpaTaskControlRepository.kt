package io.paketo.demo.repository

import io.paketo.demo.entity.TaskControlModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface IJpaTaskControlRepository: JpaRepository<TaskControlModel, Long> {

    @Query("select tc from TaskControlModel tc \n" +
            "join EmployeeModel e on tc.employeeDni = e.dni \n" +
            "where e.dni = :dni ")
    fun getTaskControlListByDni(dni: Long): Optional<List<TaskControlModel>>

}