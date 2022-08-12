package com.bits.bee.bpmc.domain.usecase.pos

import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Stock
import com.bits.bee.bpmc.domain.repository.StockRepository
import com.bits.bee.bpmc.domain.usecase.common.GetActiveWhUseCase
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by aldi on 04/08/22.
 */
class GetPidByItemUseCase @Inject constructor(
    private val stockRepository: StockRepository,
    private val getActiveWhUseCase: GetActiveWhUseCase
){

    suspend operator fun invoke(item : Item) : Flow<Resource<List<Stock>>> {
        val wh = getActiveWhUseCase().first()
        return stockRepository.getStockByItem(item, wh ?: throw Exception(""))
    }

}