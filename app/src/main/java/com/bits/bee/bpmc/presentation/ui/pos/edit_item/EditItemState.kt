package com.bits.bee.bpmc.presentation.ui.pos.edit_item

import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.model.Stock
import com.bits.bee.bpmc.domain.model.Unit
import com.bits.bee.bpmc.presentation.ui.pos.PosModeState
import java.math.BigDecimal

/**
 * Created by aldi on 25/05/22.
 */
data class EditItemState (
    var saled: Saled? = null,
    var item : Item? = null,
    var qty : BigDecimal = BigDecimal.ZERO,
    var listPrice : BigDecimal = BigDecimal.ZERO,
    var diskon : String = "",
    var discAmt : BigDecimal = BigDecimal.ZERO,
    var note : String = "",
    var unitList : List<Unit> = mutableListOf(),
    var unit : Unit? = null,
    var pid : Stock? = null,
    var modePos : PosModeState = PosModeState.FnBState,
    var addOnList : List<Item> = mutableListOf(),
    var diskonMsg : String = "",
    var isEditPrice : Boolean = true,
    var isEditDisc : Boolean = true
)