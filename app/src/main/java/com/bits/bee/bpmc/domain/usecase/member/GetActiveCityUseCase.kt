package com.bits.bee.bpmc.domain.usecase.member

import com.bits.bee.bpmc.domain.model.City
import com.bits.bee.bpmc.domain.repository.CityRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 18/05/22.
 */
class GetActiveCityUseCase @Inject constructor(private val cityRepository: CityRepository){

    operator fun invoke() : Flow<List<City>>{
        return cityRepository.getActiveCityList()
    }

}