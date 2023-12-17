package io.paketo.demo.model

import io.paketo.demo.entity.TaskControlModel
import java.time.LocalDate

data class TaskControl(
    val id: Long,
    val dni: Long,
    val controlDate: LocalDate,
    val controlTypeId: Long,
    val positionId: Int
){
    companion object{
        fun from(taskControlModel: TaskControlModel) = TaskControl (
            taskControlModel.id,
            taskControlModel.employeeDni,
            taskControlModel.controlDate!!,
            taskControlModel.controlTypeId,
            taskControlModel.positionId.toInt()
        )
    }
}
