package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.SaleAddOn
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 20/05/22.
 */
interface SaleAddOnRepository {

    suspend fun addSaleAddOn(saleAddOn: SaleAddOn) : Long

    fun getSaleAddonById(id: Int): Flow<SaleAddOn?>

    fun getSaleAddonBySale(id: Int): Flow<SaleAddOn?>
}