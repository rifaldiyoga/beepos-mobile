package com.bits.bee.bpmc.presentation.ui.pos.addon

import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.SelectionWithItem
import com.bits.bee.bpmc.domain.model.VariantWithItem
import java.math.BigDecimal

/**
 * Created by aldi on 15/08/22.
 */
data class AddOnState(
    val item : Item? = null,
    val bp : Bp? = null,
    val priceLvlId : Int = 1,
    val selectionList : List<SelectionWithItem> = mutableListOf(),
    val variantWithItem: VariantWithItem? = null,
    val qty : BigDecimal = BigDecimal.ONE,
    val selectedAddOnList : List<Item> = mutableListOf(),
    var subtotal : BigDecimal = BigDecimal.ZERO
)