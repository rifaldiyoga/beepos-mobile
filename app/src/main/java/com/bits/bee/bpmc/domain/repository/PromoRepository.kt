package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.Promo
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/06/22.
 */
interface PromoRepository {

    fun getLatestPromo() : Flow<Resource<List<Promo>>>

    fun getActivePromoList() : Flow<List<Promo>>
}