package io.paketo.demo.repository

import io.paketo.demo.entity.ControlTypeModel
import org.springframework.data.jpa.repository.JpaRepository

interface IJpaControlTypeRepository: JpaRepository<ControlTypeModel, Long>