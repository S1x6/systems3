package com.s1x6.system3.db.entity

import javax.persistence.*

@Entity
@Table(name = "ways")
class WayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
    var userName: String? = null
    var uid: Long? = null
    var visible: Boolean? = null
    var version: Long? = null
    var changeset: Long? = null
}