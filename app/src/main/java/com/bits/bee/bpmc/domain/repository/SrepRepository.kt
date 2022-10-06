package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.Srep
import com.bits.bee.bpmc.domain.model.Wh
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/06/22.
 */
interface SrepRepository {

    fun getSrepList() : Flow<List<Srep>>

    fun getDefaultSrep() : Flow<Srep?>

}