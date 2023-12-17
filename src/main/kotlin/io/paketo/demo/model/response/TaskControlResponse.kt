package io.paketo.demo.model.response

import io.paketo.demo.entity.TaskControlModel
import java.time.LocalDate

data class TaskControlResponse(
    val id: Long,
    val controlDate: LocalDate,
    val controlType: ControlTypeResponse,
    val position: String
) {
    companion object {
        fun from(taskControlModel: TaskControlModel, controlType: ControlTypeResponse, position: String) = TaskControlResponse(
            taskControlModel.id,
            taskControlModel.controlDate!!,
            controlType,
            position
        )
    }
}