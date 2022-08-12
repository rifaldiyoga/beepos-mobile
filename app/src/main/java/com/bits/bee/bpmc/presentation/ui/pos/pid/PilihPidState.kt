package com.bits.bee.bpmc.presentation.ui.pos.pid

import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Stock

/**
 * Created by aldi on 04/08/22.
 */
data class PilihPidState(
    var item : Item? = null,
    var stockList : List<Stock> = mutableListOf()
)