package com.bits.bee.bpmc.presentation.ui.pos.draft

import com.bits.bee.bpmc.domain.model.Sale

/**
 * Created by aldi on 27/06/22.
 */
data class DraftState (
    var saleList : List<Sale> = mutableListOf()
)