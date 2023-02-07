package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.UnitDummyEntity
import com.bits.bee.bpmc.domain.model.UnitDummy
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/06/22.
 */
interface UnitDummyRepository {
    suspend fun addUpdate(unitDummyEntity: UnitDummyEntity, edit: Boolean)

    fun getUnitByItemId(id: Int): Flow<List<UnitDummy>>

    suspend fun deleteByItem(id: Int)
}