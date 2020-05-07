package com.s1x6.system3.db.entity

import javax.persistence.*

@Entity
@Table(name = "tags")
class TagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
    var key: String? = null
    var value: String? = null
    @Column
    var nodeId: Long? = null
}