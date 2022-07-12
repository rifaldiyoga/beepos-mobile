package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.AddOn
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/06/22.
 */
interface AddOnRepository {

    fun getLatestAddOnList() : Flow<Resource<List<AddOn>>>

}