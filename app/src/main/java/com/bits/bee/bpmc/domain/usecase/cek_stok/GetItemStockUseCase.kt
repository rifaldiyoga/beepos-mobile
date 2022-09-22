package com.bits.bee.bpmc.domain.usecase.cek_stok

import com.bits.bee.bpmc.domain.model.Stock
import com.bits.bee.bpmc.domain.repository.StockRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetItemStockUseCase @Inject constructor(
    private val stockRepository: StockRepository
) {
    operator fun invoke(whid: Int): Flow<Resource<List<Stock>>>{
        return stockRepository.getItemStock(whid)
    }
}