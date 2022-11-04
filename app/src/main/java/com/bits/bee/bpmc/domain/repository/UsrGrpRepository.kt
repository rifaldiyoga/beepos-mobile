package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.UsrGrp
import com.bits.bee.bpmc.domain.model.Wh
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/06/22.
 */
interface UsrGrpRepository {

    fun getLatestUsrGrpList() : Flow<Resource<List<UsrGrp>>>

    fun getByUsrId(id : Int) : Flow<UsrGrp?>

}