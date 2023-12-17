package io.paketo.demo.mapper

import io.paketo.demo.entity.PositionModel
import io.paketo.demo.model.request.PositionRequest
import io.paketo.demo.model.response.PositionResponse
import org.springframework.stereotype.Component

@Component
class PositionMapper {
    fun asEntity(request: PositionRequest): PositionModel {
        return PositionModel(name = request.name, active = request.active)
    }

    fun asResponse(entity: PositionModel): PositionResponse {
        return PositionResponse(
            code = entity.code,
            name = entity.name,
            active = entity.active
        )
    }
}