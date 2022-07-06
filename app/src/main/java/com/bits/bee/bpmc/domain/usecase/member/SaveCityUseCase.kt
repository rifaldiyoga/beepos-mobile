package com.bits.bee.bpmc.domain.usecase.member

import com.bits.bee.bpmc.domain.mapper.CityPopulerDataMapper
import com.bits.bee.bpmc.domain.model.CityPopuler
import com.bits.bee.bpmc.domain.repository.CityPopulerRepository
import javax.inject.Inject

class SaveCityUseCase @Inject constructor(
    private val cityPopulerRespository: CityPopulerRepository
) {
    suspend operator fun invoke(city: CityPopuler) {
        cityPopulerRespository.addCity(CityPopulerDataMapper.fromDomainToData(city))
    }
}