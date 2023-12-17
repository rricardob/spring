package io.paketo.demo.service.impl

import io.paketo.demo.exception.NotFoundException
import io.paketo.demo.model.TaskControl
import io.paketo.demo.repository.IJpaTaskControlRepository
import io.paketo.demo.service.ITaskControlService
import org.springframework.stereotype.Repository

@Repository
class TaskControlServiceImpl(
    val jpaTaskControlRepository: IJpaTaskControlRepository
): ITaskControlService {

    override fun getTaskControlListByDni(dni: Int, year: Int, month: Int, controlType: Int): List<TaskControl> {
        val x =  jpaTaskControlRepository.getTaskControlListByDni(dni.toLong())
        if (!x.isPresent) throw NotFoundException("Employee not found")
        return  x.get().map { TaskControl.from(it) }
    }
}