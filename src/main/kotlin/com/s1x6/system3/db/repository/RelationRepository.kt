package com.s1x6.system3.db.repository

import com.s1x6.system3.db.entity.RelationEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RelationRepository : JpaRepository<RelationEntity, Long> {
}