package com.bits.bee.bpmc.presentation.dialog.draft_list

import com.bits.bee.bpmc.domain.model.Sale

/**
 * Created by aldi on 24/06/22.
 */
data class DraftListDialogState(
    var saleList : List<Sale> = mutableListOf()
)
