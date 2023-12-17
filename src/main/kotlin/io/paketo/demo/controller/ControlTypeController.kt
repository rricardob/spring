package io.paketo.demo.controller

import io.paketo.demo.entity.commons.Response
import io.paketo.demo.model.request.ControlTypeRequest
import io.paketo.demo.model.response.ControlTypeResponse
import io.paketo.demo.service.IControlTypeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/api/control-type")
class ControlTypeController(val controlTypeService: IControlTypeService) {

    @GetMapping("/list")
    fun getAllControlType(): ResponseEntity<List<ControlTypeResponse>> {
        return ResponseEntity.ok().body(controlTypeService.findAll())
    }

    @GetMapping("/find-by-id/{id}")
    fun getFindById(@PathVariable("id") id: Long): ResponseEntity<ControlTypeResponse> {
        return ResponseEntity.ok().body(controlTypeService.findById(id))
    }

    @PutMapping("/update-control-type/{id}")
    fun updateControlType(
        @PathVariable("id") id: Long,
        @RequestBody controlTypeRequest: ControlTypeRequest
    ): ResponseEntity<ControlTypeResponse> {
        return ResponseEntity.ok().body(controlTypeService.update(id, controlTypeRequest))
    }

    @PostMapping
    fun createControlType(@RequestBody controlTypeRequest: ControlTypeRequest): ResponseEntity<Response<Long>> {
        val response = controlTypeService.save(controlTypeRequest)
        val responseData: Response<Long> = Response<Long>()
        responseData.code = HttpStatus.CREATED.value()
        responseData.message = "Created"
        responseData.bodyOut = response
        return ResponseEntity.created(URI.create("")).body(responseData)
    }

    @DeleteMapping("delete/{id}")
    fun deleteById(@PathVariable("id") id: Long): ResponseEntity<Void> {
        controlTypeService.delete(id)
        return ResponseEntity.noContent().build();
    }

}