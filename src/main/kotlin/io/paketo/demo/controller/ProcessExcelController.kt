package io.paketo.demo.controller

import io.paketo.demo.entity.commons.Response
import io.paketo.demo.service.IProcessExcel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
class ProcessExcelController(val processService: IProcessExcel) {

    /*@GetMapping(
        value = ["/api/process-control-type"],
        produces = ["application/json"]
    )
    fun createProduct(): ResponseEntity<Void> {
        val productResponse = processService.readExcel(InputStream.nullInputStream())
        return ResponseEntity.ok().build()
    }*/

    @PostMapping(value = ["/api/load-data"])
    fun loadExcelData(
        /*@Valid*/ @ModelAttribute file: MultipartFile): ResponseEntity<Response<String>?> {

        val productResponse = processService.readExcel(file.inputStream)

        return ResponseEntity.ok().build();
    }


}