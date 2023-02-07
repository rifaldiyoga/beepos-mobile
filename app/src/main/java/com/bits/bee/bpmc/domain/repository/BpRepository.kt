package com.bits.bee.bpmc.domain.repository

import androidx.paging.PagingData
import com.bits.bee.bpmc.data.data_source.remote.post.BpPost
import com.bits.bee.bpmc.data.data_source.remote.response.BpReturn
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 17/03/22.
 */

interface BpRepository {

    fun getLastesBpList() : Flow<Resource<List<Bp>>>

    fun getDefaultBp() : Flow<Resource<Bp>>

    fun getBpById(id : Int) : Flow<Bp?>

    fun getActiveBpPagedList(query: String, isFavorit : Boolean) : Flow<PagingData<Bp>>

    fun getlastId(): Flow<Resource<Bp>>

    fun searchBp(query: String): Flow<Resource<List<Bp>>>

    suspend fun addUpdateBp(bpEntity: Bp) : Long

    fun getBpByDate(startDate: Long, endDate: Long): Flow<List<Bp>>

    fun getBpHaventUploaded(): Flow<List<Bp>>

    fun uploadBpClient(bpPost: BpPost): Flow<Resource<BpReturn>>

    fun getBpByCode(code: String): Flow<Bp?>

    suspend fun updateBp(bpEntity: Bp)

    suspend fun deleteBp(bpEntity: Bp)

    suspend fun resetSelectedBp()

}