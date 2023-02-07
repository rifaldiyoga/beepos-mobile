package com.bits.bee.bpmc.presentation.ui.pos.pos

import com.bits.bee.bpmc.domain.model.ItemGroup

/**
 * Created by aldi on 28/04/22.
 */
data class PosState(
    var itemGroupList : List<ItemGroup> = mutableListOf()
)