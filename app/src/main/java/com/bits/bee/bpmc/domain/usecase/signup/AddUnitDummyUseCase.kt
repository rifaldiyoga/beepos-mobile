package com.bits.bee.bpmc.domain.usecase.signup

import com.bits.bee.bpmc.domain.model.UnitDummy
import com.bits.bee.bpmc.domain.repository.UnitDummyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AddUnitDummyUseCase @Inject constructor(
    private val unitDummyRepository: UnitDummyRepository
) {

}