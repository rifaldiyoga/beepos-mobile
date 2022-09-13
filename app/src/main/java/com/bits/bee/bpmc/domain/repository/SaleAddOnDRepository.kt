package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.SaleAddOnD
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 20/05/22.
 */
interface SaleAddOnDRepository {

    suspend fun addSaleAddOnD(saleAddOnDList : List<SaleAddOnD>)

    fun getSaleAddonDbyAddon(id: Int): Flow<Resource<List<SaleAddOnD>>>

}