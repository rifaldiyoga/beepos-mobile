package com.bits.bee.bpmc.domain.usecase.member

import com.bits.bee.bpmc.domain.model.CityPopuler
import com.bits.bee.bpmc.domain.repository.CityPopulerRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCityPopularUseCase @Inject constructor(
    private val cityPopulerRepo: CityPopulerRepository
) {
    operator fun invoke(): Flow<List<CityPopuler>> {
        return cityPopulerRepo.getCityPopuler()
    }
}