package com.s1x6.system3.db.repository

import com.s1x6.system3.db.entity.NodeEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface NodeRepository : PagingAndSortingRepository<NodeEntity, Long> {

    //    @Query(value = "SELECT n, FUNCTION('earth_distance', FUNCTION('ll_to_earth', ?1, ?2), FUNCTION('ll_to_earth', lat, lon)) as distance FROM nodes n WHERE FUNCTION('earth_box', FUNCTION('ll_to_earth', ?1 ,?2), ?3) @> FUNCTION('ll_to_earth', ?1, ?2) ORDER by distance;", nativeQuery = true)
    @Query("SELECT * " +
            "FROM nodes " +
            "WHERE earth_box(ll_to_earth(?1,?2), ?3) " +
            "@> " +
            "ll_to_earth(lat, lon) ORDER by earth_distance(ll_to_earth(?1,?2), ll_to_earth(lat, lon));",
            nativeQuery = true
    )
    fun getNodesInRadius(lat: Double, lon: Double, radius: Long): List<NodeEntity>
}