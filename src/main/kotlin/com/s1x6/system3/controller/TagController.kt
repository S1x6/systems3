package com.s1x6.system3.controller

import com.s1x6.system3.db.entity.TagEntity
import com.s1x6.system3.service.TagService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("tag")
class TagController {
    @Autowired
    private lateinit var tagService: TagService

    @GetMapping(
            value = ["get"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getAllTags(): List<TagEntity> = tagService.getAllTags()

    @GetMapping(
            value = ["{id}"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getTag(@PathVariable("id") id: Long): Result =
            tagService.getTag(id)

    @PostMapping(
            value = [""],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createTag(@RequestBody tag: TagEntity): Result =
            tagService.saveTag(tag)


    @DeleteMapping(
            value = ["{id}"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteTag(@PathVariable("id") id: Long): Result =
            tagService.deleteTag(id)
}