package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.repository.SaledRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 24/06/22.
 */
class GetSaledBySaleUseCase @Inject constructor(
    private val saledRepository: SaledRepository
) {

    operator fun invoke(saleId : Int) : Flow<List<Saled>> {
        return saledRepository.getSaledList(saleId)
    }

}