package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.UnitDummyDao
import com.bits.bee.bpmc.domain.repository.UnitDummyRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class UnitDummyRepositoryImpl @Inject constructor(
    private val unitDummyDao: UnitDummyDao,
    private val ioDispatcher: CoroutineDispatcher
) : UnitDummyRepository{

}