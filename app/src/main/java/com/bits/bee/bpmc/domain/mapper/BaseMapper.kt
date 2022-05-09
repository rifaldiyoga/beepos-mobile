package com.bits.bee.bpmc.domain.mapper

/**
 * Created by aldi on 20/04/22.
 */
abstract class BaseMapper<Data, Domain> {

    abstract fun fromDataToDomain(model : Data) : Domain

    abstract fun fromDomainToData(model : Domain) : Data
}