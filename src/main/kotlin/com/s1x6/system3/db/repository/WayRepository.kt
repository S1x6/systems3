package com.s1x6.system3.db.repository

import com.s1x6.system3.db.entity.WayEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WayRepository : JpaRepository<WayEntity, Long> {
}