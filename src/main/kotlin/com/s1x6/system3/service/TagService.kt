package com.s1x6.system3.service

import com.s1x6.system3.controller.Result
import com.s1x6.system3.controller.wrapError
import com.s1x6.system3.controller.wrapSuccess
import com.s1x6.system3.db.entity.TagEntity
import com.s1x6.system3.db.repository.TagRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TagService {

    @Autowired
    private lateinit var tagRepository: TagRepository

    fun getAllTags(): List<TagEntity> = tagRepository.findAll()
    fun getTag(id: Long): Result {
        val res = tagRepository.findById(id)
        return if (res.isPresent) {
            wrapSuccess(res.get())
        } else {
            wrapError("Tag с таким id ($id) не существует")
        }
    }

    fun saveTag(tag: TagEntity): Result {
        val newTag = tagRepository.save(tag)
        return wrapSuccess(newTag.id!!)
    }

    fun deleteTag(id: Long): Result {
        tagRepository.deleteById(id)
        return wrapSuccess()
    }
}