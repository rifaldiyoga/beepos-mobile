package com.bits.bee.bpmc.domain.usecase.pembayaran

import com.bits.bee.bpmc.domain.model.Pmtd
import com.bits.bee.bpmc.domain.repository.PmtdRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 25/07/22.
 */
class GetActivePmtd @Inject constructor(private val pmtdRepository: PmtdRepository){

    operator fun invoke() : Flow<List<Pmtd>> {
        return pmtdRepository.getActivePmtdList()
    }
}