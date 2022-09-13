package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.PromoMulti
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/06/22.
 */
interface PromoMultiRepository {

    fun getLatestPromoMulti() : Flow<Resource<List<PromoMulti>>>

    fun getPromoMultiByPromo(promoId : Int) : Flow<List<PromoMulti>>

    fun getSyaratPromoMultiByPromo(promoId: Int) : Flow<List<PromoMulti>>

    fun getOfferPromoMultiByPromo(promoId: Int) : Flow<List<PromoMulti>>

    fun getBranchPromoMultiByPromo(promoId: Int, branchId : Int) : Flow<List<PromoMulti>>
}