package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.AddOnD
import com.bits.bee.bpmc.domain.model.SelectionD
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/06/22.
 */
interface SelectionDRepository {

    fun getLatestSelectionDList() : Flow<Resource<List<SelectionD>>>

}