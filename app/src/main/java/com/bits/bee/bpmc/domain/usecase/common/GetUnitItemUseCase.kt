package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.model.Unit
import com.bits.bee.bpmc.domain.repository.UnitRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 05/08/22.
 */
class GetUnitItemUseCase @Inject constructor(
    private val unitRepository: UnitRepository
){

    operator fun invoke(itemId : Int) : Flow<List<Unit>> {
        return unitRepository.getUnitByItem(itemId)
    }

}