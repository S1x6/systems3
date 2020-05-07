package com.s1x6.system3.service

import com.s1x6.system3.controller.Result
import com.s1x6.system3.controller.wrapError
import com.s1x6.system3.controller.wrapSuccess
import com.s1x6.system3.db.entity.WayEntity
import com.s1x6.system3.db.repository.WayRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class WayService {

    @Autowired
    private lateinit var wayRepository: WayRepository

    fun getAllWays(): List<WayEntity> = wayRepository.findAll()
    fun getWay(id: Long): Result {
        val res = wayRepository.findById(id)
        return if (res.isPresent) {
            wrapSuccess(res.get())
        } else {
            wrapError("Way с таким id ($id) не существует")
        }
    }

    fun saveWay(way: WayEntity): Result {
        val newWay = wayRepository.save(way)
        return wrapSuccess(newWay.id!!)
    }

    fun deleteWay(id: Long): Result {
        wayRepository.deleteById(id)
        return wrapSuccess()
    }
}