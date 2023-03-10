package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.AddOnD
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/06/22.
 */
interface AddOnDRepository {

    fun getLatestAddOnDList() : Flow<Resource<List<AddOnD>>>

    fun getAddOnDByItemList(itemId : Int) : Flow<List<AddOnD>>

}