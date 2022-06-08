package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.model.City
import com.bits.bee.bpmc.domain.repository.CityRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by aldi on 18/05/22.
 */
class GetLatestCityUseCase @Inject constructor(private val cityRepository: CityRepository){

    operator fun invoke(page : Int): Flow<Resource<List<City>>> {
        return cityRepository.getLatestCityList()

    }

}