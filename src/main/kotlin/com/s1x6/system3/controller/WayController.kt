package com.s1x6.system3.controller

import com.s1x6.system3.db.entity.WayEntity
import com.s1x6.system3.service.WayService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("way")
class WayController {
    @Autowired
    private lateinit var wayService: WayService

    @GetMapping(
            value = ["get"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getAllWays(): List<WayEntity> = wayService.getAllWays()

    @GetMapping(
            value = ["{id}"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getWay(@PathVariable("id") id: Long): Result =
            wayService.getWay(id)

    @PostMapping(
            value = [""],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createWay(@RequestBody way: WayEntity): Result =
            wayService.saveWay(way)


    @DeleteMapping(
            value = ["{id}"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteWay(@PathVariable("id") id: Long): Result =
            wayService.deleteWay(id)
}