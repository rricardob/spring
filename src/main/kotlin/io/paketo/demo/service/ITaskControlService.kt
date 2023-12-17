package io.paketo.demo.service

import io.paketo.demo.model.TaskControl

interface ITaskControlService {

    fun getTaskControlListByDni(dni: Int, year: Int, month: Int, controlType: Int): List<TaskControl>
}