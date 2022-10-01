package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.CadjEntity
import com.bits.bee.bpmc.data.data_source.local.model.CashEntity
import com.bits.bee.bpmc.domain.model.Cadj
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CadjRepository {

    suspend fun addCadj(cadjEntity: CadjEntity)

    fun getCadjByReftypeInOutHaventUpload(): Flow<List<Cadj>>

    suspend fun updateCadj(cadj: Cadj)

    fun getCadjLastRow(): Flow<Cadj>

    suspend fun updateCode(code: String, id: Int)

    fun getLastInOutStatus(cashid: Long): Flow<Cadj>

    fun getKasMasuk(): Flow<List<Cadj>>

    fun getKasKeluar(): Flow<List<Cadj>>


}