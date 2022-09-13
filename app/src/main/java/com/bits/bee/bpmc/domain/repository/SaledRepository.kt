package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.RankItem
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 20/05/22.
 */
interface SaledRepository {

    suspend fun addSaled(saledList : List<Saled>)

    fun getSaledList(saleId : Int) : Flow<List<Saled>>

    fun getRankItem(possesId: Int): Flow<List<RankItem>>

    fun getSaledDeletedItem(): Flow<List<Saled>>

}