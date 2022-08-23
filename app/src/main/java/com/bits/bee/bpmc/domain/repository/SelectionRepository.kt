package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.AddOnD
import com.bits.bee.bpmc.domain.model.Selection
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/06/22.
 */
interface SelectionRepository {

    fun getLatestSelectionList() : Flow<Resource<List<Selection>>>

    fun getSelectionByItem(itemId : Int) : Flow<List<Selection>>

}