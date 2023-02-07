package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.EdcSurc
import com.bits.bee.bpmc.domain.model.EdcSurcAndCcType
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/06/22.
 */
interface EdcSurcRepository {

    fun getLatestEdcSurc() : Flow<Resource<List<EdcSurc>>>

    fun getEdcSurcActive(edcId : Int, type : String) : Flow<List<EdcSurcAndCcType>>

}