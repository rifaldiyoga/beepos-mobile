package com.bits.bee.bpmc.presentation.ui.pos

import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Channel
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.model.Saled

/**
 * Created by aldi on 22/04/22.
 */
data class MainState(
    var bp : Bp? = null,
    var channel : Channel? = null,
    var channelList : List<Channel> = mutableListOf(),
    var sale : Sale = Sale(),
    var saledList : MutableList<Saled> = mutableListOf()
)