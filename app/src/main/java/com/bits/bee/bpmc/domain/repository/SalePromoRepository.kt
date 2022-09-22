package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.SalePromo
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

interface SalePromoRepository {

    suspend fun addSalePromo(salePromoList : List<SalePromo>)

    fun getSalePromoBySale(id: Int):Flow<Resource<List<SalePromo>>>

}