package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.PriceLvl
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 10/05/22.
 */
interface PriceLvlRepository {

    fun getLatestPriceLvl() : Flow<Resource<List<PriceLvl>>>

    fun getActivePriceLvl() : Flow<List<PriceLvl>>

}