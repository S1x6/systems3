package com.s1x6.system3.service

import com.s1x6.system3.controller.Result
import com.s1x6.system3.controller.wrapError
import com.s1x6.system3.controller.wrapSuccess
import com.s1x6.system3.db.entity.RelationEntity
import com.s1x6.system3.db.repository.RelationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RelationService {

    @Autowired
    private lateinit var relationRepository: RelationRepository

    fun getAllRelations(): List<RelationEntity> = relationRepository.findAll()
    fun deleteRelation(id: Long): Result {
        relationRepository.deleteById(id)
        return wrapSuccess()
    }

    fun saveRelation(relation: RelationEntity): Result {
        val newNode = relationRepository.save(relation)
        return wrapSuccess(newNode.id!!)
    }

    fun getRelation(id: Long): Result {
        val res = relationRepository.findById(id)
        return if (res.isPresent) {
            wrapSuccess(res.get())
        } else {
            wrapError("Relation с таким id ($id) не существует")
        }
    }
}