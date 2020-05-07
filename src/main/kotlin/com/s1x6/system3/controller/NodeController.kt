package com.s1x6.system3.controller

import com.s1x6.system3.db.entity.NodeEntity
import com.s1x6.system3.service.NodeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("node")
class NodeController {

    @Autowired
    private lateinit var nodeService: NodeService

    @GetMapping(
            value = ["radius"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getNodesInRadius(
            @RequestParam("lon") lon: Double,
            @RequestParam("lat") lat: Double,
            @RequestParam("radius") radius: Long
    ): Result = nodeService.getNodesInRadius(lat, lon, radius)

    @GetMapping(
            value = [""],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getAllNodes(@RequestParam("page") page: Int?, @RequestParam("limit") limit: Int?): Result {
        return nodeService.getAllNodes(page ?: 0, limit ?: 50)
    }

    @GetMapping(
            value = ["{id}"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getNode(@PathVariable("id") id: Long): Result =
            nodeService.getNode(id)

    @PostMapping(
            value = [""],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createNode(@RequestBody node: NodeEntity): Result =
            nodeService.saveNode(node)


    @DeleteMapping(
            value = ["{id}"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteNode(@PathVariable("id") id: Long): Result =
            nodeService.deleteNode(id)
}