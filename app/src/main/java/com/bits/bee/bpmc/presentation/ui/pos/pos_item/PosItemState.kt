package com.bits.bee.bpmc.presentation.ui.pos.pos_item

import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.ItemGroup

/**
 * Created by aldi on 12/05/22.
 */
data class PosItemState (
    var itemGroup: ItemGroup? = null,
    var itemList : List<Item> = mutableListOf(),
    var priceLvlId : Int = 1
)