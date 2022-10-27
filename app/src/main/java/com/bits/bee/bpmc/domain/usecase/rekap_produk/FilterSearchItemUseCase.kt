package com.bits.bee.bpmc.domain.usecase.rekap_produk

import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.repository.SaledRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class FilterSearchItemUseCase @Inject constructor(
    private val saledRepository: SaledRepository
) {

    operator fun invoke(id: Int, convertStartDate: Long, convertEndDate: Long): Flow<List<Saled>>{
        return saledRepository.getSaledTotal(id, convertStartDate, convertEndDate)
    }
}