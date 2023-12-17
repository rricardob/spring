package io.paketo.demo.controller

import io.paketo.demo.model.response.TaskControlForEmployeeResponse
import io.paketo.demo.model.response.TaskControlResponse
import io.paketo.demo.service.IControlTypeService
import io.paketo.demo.service.IEmployeeService
import io.paketo.demo.service.IPositionService
import io.paketo.demo.service.ITaskControlService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class TaskControlController(
    val taskControlService: ITaskControlService,
    val employeeService: IEmployeeService,
    val controlTypeService: IControlTypeService,
    val positionService: IPositionService
) {

    @GetMapping(
        value = ["/api/task-control-employee-search"],
        produces = ["application/json"]
    )
    fun search(
        @RequestParam("dni") dni: Int,
        @RequestParam(name = "year", required = false, defaultValue = "-1") year: Int,
        @RequestParam(name = "month", required = false, defaultValue = "-1") month: Int,
        @RequestParam(name = "type-control", required = false, defaultValue = "-1") typeControl: Int
    ): ResponseEntity<TaskControlForEmployeeResponse> {
        val result = taskControlService.getTaskControlListByDni(dni, year, month, typeControl)
        val employee = employeeService.findByDni(dni)

        val x = result.map {
            TaskControlResponse(
                it.id,
                it.controlDate,
                controlTypeService.findById(it.controlTypeId),
                positionService.findById(it.positionId.toLong()).name
            )
        }

        val response = TaskControlForEmployeeResponse.from(employee = employee, taskControlList = x)

        return ResponseEntity.ok().body(response)
    }
}