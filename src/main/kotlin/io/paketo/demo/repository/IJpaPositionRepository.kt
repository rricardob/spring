package io.paketo.demo.repository

import io.paketo.demo.entity.PositionModel
import org.springframework.data.jpa.repository.JpaRepository

interface IJpaPositionRepository: JpaRepository<PositionModel, Long> {
}