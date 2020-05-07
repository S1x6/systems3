package com.s1x6.system3.db.entity

import javax.persistence.*

@Entity
@Table(name = "nodes")
class NodeEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Long? = null
    var lon: Double? = null
    var lat: Double? = null
    var userName: String? = null
    var uid: Long? = null
    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "nodeId")
    var tags: List<TagEntity> = ArrayList()
}

interface NodeDistanceEntity {
    var id: Long?
    var lon: Double?
    var lat: Double?
    var userName: String?
    var uid: Long?
    var distance: Long?
}