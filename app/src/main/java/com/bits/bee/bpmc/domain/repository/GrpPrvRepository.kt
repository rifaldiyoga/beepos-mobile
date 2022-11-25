package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.GrpPrv
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/06/22.
 */
interface GrpPrvRepository {

    fun getLatestGrpPrvList() : Flow<Resource<List<GrpPrv>>>

    fun getGrpPrvByGrpId(id : Int) : Flow<List<GrpPrv>>

}