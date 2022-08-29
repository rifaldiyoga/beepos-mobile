package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.SaleAddOnD
import com.bits.bee.bpmc.domain.model.Saled

/**
 * Created by aldi on 20/05/22.
 */
interface SaleAddOnDRepository {

    suspend fun addSaleAddOnD(saleAddOnDList : List<SaleAddOnD>)

}