package com.bits.bee.bpmc.domain.usecase.pembayaran

import com.bits.bee.bpmc.domain.model.EdcSurcAndCcType
import com.bits.bee.bpmc.domain.repository.EdcSurcRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 18/07/22.
 */
class GetActiveEdcSurc @Inject constructor(
    private val edcRepository: EdcSurcRepository
){

    operator fun invoke(edcId : Int, type: String) : Flow<List<EdcSurcAndCcType>> {
        return edcRepository.getEdcSurcActive(edcId, type)
    }
}