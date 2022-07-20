package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.Tax
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/03/22.
 */
interface TaxRepository {

    fun getLatestTaxList() : Flow<Resource<List<Tax>>>

}