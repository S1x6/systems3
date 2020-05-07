package com.s1x6.system3.controller

import com.s1x6.system3.db.entity.RelationEntity
import com.s1x6.system3.service.RelationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("relation")
class RelationController {
    @Autowired
    private lateinit var relationService: RelationService

    @GetMapping(
            value = ["get"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getAllRelations(): List<RelationEntity> = relationService.getAllRelations()

    @GetMapping(
            value = ["{id}"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getRelation(@PathVariable("id") id: Long): Result =
            relationService.getRelation(id)

    @PostMapping(
            value = [""],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createRelation(@RequestBody relation: RelationEntity): Result =
            relationService.saveRelation(relation)


    @DeleteMapping(
            value = ["{id}"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteRelation(@PathVariable("id") id: Long): Result =
            relationService.deleteRelation(id)
}