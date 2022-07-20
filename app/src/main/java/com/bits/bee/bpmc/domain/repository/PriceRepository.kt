package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.ItemSaleTax
import com.bits.bee.bpmc.domain.model.Price
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 13/05/22.
 */
interface PriceRepository {

    fun getLatesPrice() : Flow<Resource<List<Price>>>

    fun getPriceByPriceLvl(priceLvlId : Int, itemId : Int) : Flow<Price?>

}