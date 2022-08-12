package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.Unit
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/06/22.
 */
interface UnitRepository {

    fun getLatestUnitList() : Flow<Resource<List<Unit>>>

    fun getUnitByItem(itemId : Int) : Flow<List<Unit>>

}