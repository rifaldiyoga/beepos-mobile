package com.bits.bee.bpmc.domain.usecase

import com.bits.bee.bpmc.data.data_source.local.model.City
import com.bits.bee.bpmc.domain.repository.CityRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CityInteractor @Inject constructor(private val cityRepository: CityRepository) {

    operator fun invoke(): Flow<Resource<List<City>>> = cityRepository.getLatestCityList()

    fun getCityDao() = cityRepository.getLatestCityList()

}