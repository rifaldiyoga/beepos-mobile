package com.bits.bee.bpmc.domain.usecase.member

import com.bits.bee.bpmc.domain.repository.CityRepository
import javax.inject.Inject

class GetCodeByCityUseCase @Inject constructor(
    private val cityRepository: CityRepository
) {
}