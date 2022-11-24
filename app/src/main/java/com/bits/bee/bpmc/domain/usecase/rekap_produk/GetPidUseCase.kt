package com.bits.bee.bpmc.domain.usecase.rekap_produk

import com.bits.bee.bpmc.domain.model.Stock
import com.bits.bee.bpmc.domain.repository.StockRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPidUseCase @Inject constructor(
    private val stockRepository: StockRepository
) {
    operator fun invoke(id: Int): Flow<List<Stock>>{
        return stockRepository.getPidByItem(id)
    }
}