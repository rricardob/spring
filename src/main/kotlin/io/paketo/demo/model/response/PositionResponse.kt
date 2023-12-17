package io.paketo.demo.model.response

data class PositionResponse(
    val code: Long,
    val name: String,
    val active: Boolean?
)
