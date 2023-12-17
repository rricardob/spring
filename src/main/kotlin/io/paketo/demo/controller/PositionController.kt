package io.paketo.demo.controller

import io.paketo.demo.entity.commons.Response
import io.paketo.demo.model.request.PositionRequest
import io.paketo.demo.model.response.PositionResponse
import io.paketo.demo.service.IPositionService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/api/position")
class PositionController(val positionService: IPositionService) {

    @GetMapping("/list-positions")
    fun getAllPositions(): ResponseEntity<List<PositionResponse>>{
        return ResponseEntity.ok().body(positionService.findAll())
    }

    @GetMapping("/find-position-by-id/{id}")
    fun getFindById(@PathVariable("id") id: Long): ResponseEntity<PositionResponse>{
        return ResponseEntity.ok().body(positionService.findById(id))
    }

    @PutMapping("/update-position/{id}")
    fun updatePosition(@PathVariable("id") id: Long,
                       @RequestBody positionRequest: PositionRequest
    ): ResponseEntity<PositionResponse>{
        return ResponseEntity.ok().body(positionService.update(id, positionRequest))
    }

    @PostMapping
    fun createPosition(@RequestBody positionRequest: PositionRequest): ResponseEntity<Response<Long>>{
        val response = positionService.create(positionRequest)
        val responseData: Response<Long> = Response<Long>()
        responseData.code = HttpStatus.CREATED.value()
        responseData.message = "Created"
        responseData.bodyOut = response
        return ResponseEntity.created(URI.create("")).body(responseData)
    }

    @DeleteMapping("delete-position/{id}")
    fun deleteById(@PathVariable("id") id: Long): ResponseEntity<Void>{
        positionService.delete(id)
        return ResponseEntity.noContent().build();
    }
}