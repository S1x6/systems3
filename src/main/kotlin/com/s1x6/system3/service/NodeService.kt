package com.s1x6.system3.service

import com.s1x6.system3.controller.Result
import com.s1x6.system3.controller.wrapError
import com.s1x6.system3.controller.wrapSuccess
import com.s1x6.system3.db.entity.NodeEntity
import com.s1x6.system3.db.repository.NodeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class NodeService {

    @Autowired
    private lateinit var nodeRepository: NodeRepository

    fun getAllNodes(page: Int, limit: Int): Result {
        return wrapSuccess(nodeRepository.findAll(PageRequest.of(page, limit)).content)
    }

    fun getNode(id: Long): Result {
        val res = nodeRepository.findById(id)
        return if (res.isPresent) {
            wrapSuccess(res.get())
        } else {
            wrapError("Node с таким id ($id) не существует")
        }
    }

    fun saveNode(node: NodeEntity): Result {
        val newNode = nodeRepository.save(node)
        return wrapSuccess(newNode.id!!)
    }

    fun deleteNode(id: Long): Result {
        nodeRepository.deleteById(id)
        return wrapSuccess()
    }

    fun getNodesInRadius(lat: Double, lon: Double, radius: Long): Result {
        return wrapSuccess(nodeRepository.getNodesInRadius(lat, lon, radius))
    }

}