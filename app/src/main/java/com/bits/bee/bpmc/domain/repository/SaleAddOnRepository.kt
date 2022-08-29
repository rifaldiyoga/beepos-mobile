package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.SaleAddOn

/**
 * Created by aldi on 20/05/22.
 */
interface SaleAddOnRepository {

    suspend fun addSaleAddOn(saleAddOn: SaleAddOn)

}