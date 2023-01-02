package com.bits.bee.bpmc.domain.usecase.cek_stok

import com.bits.bee.bpmc.domain.model.Stock
import com.bits.bee.bpmc.domain.repository.StockRepository
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveWhUseCase
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class GetItemStockUseCase @Inject constructor(
    private val stockRepository: StockRepository,
    private val getActiveWhUseCase: GetActiveWhUseCase
) {

    suspend operator fun invoke(query : String, sortDesc : Boolean) : Flow<Resource<List<Stock>>> {
        val wh = getActiveWhUseCase().first() ?: throw IllegalArgumentException("No active wh!")
        return stockRepository.getItemStock(wh.id, query, sortDesc)
    }

}