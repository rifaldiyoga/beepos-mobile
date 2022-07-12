package com.bits.bee.bpmc.domain.mapper

/**
 * Created by aldi on 20/04/22.
 */
abstract class BaseMapper<Db, Domain, Network> {

    abstract fun fromDbToDomain(model : Db) : Domain

    abstract fun fromDomainToDb(model : Domain) : Db
    
    abstract fun fromNetworkToData(model : Network) : Db

}