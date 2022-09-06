package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.model.City
import com.bits.bee.bpmc.domain.repository.CityRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 18/05/22.
 */
class GetLatestCityUseCase @Inject constructor(private val cityRepository: CityRepository){

    operator fun invoke(isSignUp: Boolean = false): Flow<Resource<List<City>>> {
        return cityRepository.getLatestCityList(isSignUp)
    }

}