package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.Reg
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/06/22.
 */
interface RegRepository {

    fun getLatestRegList() : Flow<Resource<List<Reg>>>

    fun getRegPossesActualEndcash(): Flow<Reg>
}