package com.bits.bee.bpmc.presentation.ui.pos

import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Channel

/**
 * Created by aldi on 22/04/22.
 */
data class MainState(
    var bp : Bp? = null,
    var channel : Channel? = null,
    var channelList : List<Channel> = mutableListOf()
)