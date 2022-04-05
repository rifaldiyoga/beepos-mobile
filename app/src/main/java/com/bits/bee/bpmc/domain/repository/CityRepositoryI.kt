package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.source.local.model.City
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/03/22.
 */
interface CityRepositoryI {

    fun getCityList() : Flow<Resource<List<City>>>

}