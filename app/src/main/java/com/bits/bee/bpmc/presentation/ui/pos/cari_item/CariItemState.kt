package com.bits.bee.bpmc.presentation.ui.pos.cari_item

import androidx.paging.PagingData
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Channel
import com.bits.bee.bpmc.domain.model.Item

/**
 * Created by aldi on 22/07/22.
 */
data class CariItemState (
    var query : String = "",
    var itemList : PagingData<Item>? = null,
    var bp : Bp? = null,
    var channel : Channel? = null,
    var usePid : Boolean = false
)