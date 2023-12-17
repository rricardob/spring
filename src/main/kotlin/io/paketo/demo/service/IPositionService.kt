package io.paketo.demo.service

import io.paketo.demo.model.request.PositionRequest
import io.paketo.demo.model.response.PositionResponse

interface IPositionService {

    fun create(positionRequest: PositionRequest): Long

    fun findById(id: Long): PositionResponse

    fun update(id: Long, positionRequest: PositionRequest): PositionResponse?

    fun delete(id: Long)

    fun findAll(): List<PositionResponse>

}