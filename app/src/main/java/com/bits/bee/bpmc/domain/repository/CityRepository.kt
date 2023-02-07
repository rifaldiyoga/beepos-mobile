package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.City
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/03/22.
 */
interface CityRepository {

    fun getLatestCityList(isSignUp : Boolean = false) : Flow<Resource<List<City>>>

    fun getActiveCityList() : Flow<List<City>>

    fun searchCityList(query : String) : Flow<List<City>>

    fun getCodeByName(str: String): Flow<Resource<City>>

}