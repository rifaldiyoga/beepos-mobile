package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Stock
import com.bits.bee.bpmc.domain.model.Wh
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/06/22.
 */
interface StockRepository {

    fun getStockByItem(item: Item,
                       wh: Wh
    ) : Flow<Resource<List<Stock>>>

    fun getItemStock(wh_id: Int): Flow<Resource<List<Stock>>>

    fun getPidByItem(id: Int): Flow<List<Stock>>

}