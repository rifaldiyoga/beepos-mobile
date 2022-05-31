package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.Price

/**
 * Created by aldi on 13/05/22.
 */
interface PriceRepository {

    fun getPriceByPriceLvl(priceLvlId : Int) : Price

}