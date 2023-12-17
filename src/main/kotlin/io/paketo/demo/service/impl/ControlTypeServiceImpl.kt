package io.paketo.demo.service.impl


import io.paketo.demo.mapper.ControlTypeMapper
import io.paketo.demo.exception.NotFoundException
import io.paketo.demo.model.request.ControlTypeRequest
import io.paketo.demo.model.response.ControlTypeResponse
import io.paketo.demo.repository.IJpaControlTypeRepository
import io.paketo.demo.service.IControlTypeService
import io.paketo.demo.validation.ValidationUtil
import org.springframework.stereotype.Repository

@Repository
class ControlTypeServiceImpl(
    val jpaControlTypeRepository: IJpaControlTypeRepository,
    val validationUtil: ValidationUtil,
    val controlTypeMapper: ControlTypeMapper
) : IControlTypeService {

    override fun findById(id: Long): ControlTypeResponse {
        val result = jpaControlTypeRepository.findById(id).orElseThrow { NotFoundException("El Tipo de Control con id $id no existe") }
        return  controlTypeMapper.asResponse(result)
    }

    override fun save(controlTypeRequest: ControlTypeRequest): Long {
        val controlTypeModel = controlTypeMapper.asEntity(controlTypeRequest)
        return jpaControlTypeRepository.save(controlTypeModel).id
    }

    override fun update(id: Long, controlTypeRequest: ControlTypeRequest): ControlTypeResponse? {
        val exists = jpaControlTypeRepository.findById(id).orElseThrow { NotFoundException("El Tipo de Control con id $id no existe") }
        if (exists != null){
            exists.type = controlTypeRequest.type
            exists.description = controlTypeRequest.description
            exists.color = controlTypeRequest.color
            return controlTypeMapper.asResponse(jpaControlTypeRepository.save(exists))
        }

        return null

    }

    override fun delete(id: Long) {
        jpaControlTypeRepository.deleteById(id)
    }

    override fun findAll(): List<ControlTypeResponse> {
        return jpaControlTypeRepository.findAll().map { controlTypeMapper.asResponse(it) }
    }


}