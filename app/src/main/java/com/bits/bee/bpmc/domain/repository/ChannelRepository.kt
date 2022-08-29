package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.Channel
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/03/22.
 */
interface ChannelRepository {

    fun getChannelList() : Flow<Resource<List<Channel>>>

    fun getActiveChannelList() : Flow<List<Channel>>

}