package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.CadjEntity
import com.bits.bee.bpmc.data.data_source.local.model.CashEntity
import com.bits.bee.bpmc.domain.model.Cadj
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import java.math.BigDecimal

interface CadjRepository {

    suspend fun addCadj(cadjEntity: CadjEntity)

    fun getCadjByReftypeInOutHaventUpload(): Flow<List<Cadj>>

    suspend fun updateCadj(cadj: Cadj)

    fun getCadjLastRow(): Flow<Cadj>

    suspend fun updateCode(code: String, id: Int)

    fun getLastInOutStatus(cashid: Long): Flow<Cadj>

    fun getKasMasukDesc(query: String): Flow<List<Cadj>>

    fun getKasMasukAsc(query: String): Flow<List<Cadj>>

    fun getKasKeluarDesc(query: String): Flow<List<Cadj>>

    fun getKasKeluarAsc(query: String): Flow<List<Cadj>>

    fun getJmlCadjInByDate(startDate: Long, endDate: Long): Flow<List<Cadj>>

    fun getJmlCadjOutByDate(startDate: Long, endDate: Long): Flow<List<Cadj>>

    fun getCashInOut(cashId : Long) : Flow<List<Cadj>>

}