package com.bits.bee.bpmc.domain.repository

import androidx.paging.PagingData
import com.bits.bee.bpmc.data.data_source.local.model.PossesEntity
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import java.math.BigDecimal

/**
 * Created by aldi on 07/06/22.
 */
interface PossesRepository {

    suspend fun getActivePosses() : Flow<Posses?>

    suspend fun getPosses(): Flow<PagingData<Posses>>

    suspend fun addPosses(startBal : BigDecimal, shift : Int, branch: Branch, cashier: Cashier)

    suspend fun updatePosses(posses: Posses)

    fun getPossesById(id: Int): Flow<Resource<Posses>>

    suspend fun getPossesHistory(): Flow<PagingData<Posses>>

    suspend fun getActivePossesList(): Flow<Resource<List<Posses>>>

    fun getFilter(current: Long, end: Long): Flow<Resource<List<Posses>>>

    fun getListPossesHistory(): Flow<Resource<List<Posses>>>

    fun getJmlPossesByDate(startDate: Long, endDate: Long): Flow<Resource<List<Posses>>>

    fun getFilterAsc(current: Long, end: Long): Flow<Resource<List<Posses>>>

    fun getFilterDesc(current: Long, end: Long): Flow<Resource<List<Posses>>>

    fun getPossesHaventUpload(): Flow<List<Posses>>
}