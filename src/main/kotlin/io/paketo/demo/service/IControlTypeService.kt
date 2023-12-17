package io.paketo.demo.service

import io.paketo.demo.model.request.ControlTypeRequest
import io.paketo.demo.model.response.ControlTypeResponse

interface IControlTypeService {

    fun findById(id: Long): ControlTypeResponse

    fun save(controlTypeRequest: ControlTypeRequest): Long

    fun update(id: Long, controlTypeRequest: ControlTypeRequest): ControlTypeResponse?

    fun delete(id: Long)

    fun findAll(): List<ControlTypeResponse>
}