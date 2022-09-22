package com.bits.bee.bpmc.presentation.ui.pos.klaim_promo

import com.bits.bee.bpmc.data.list.ListItemBonusAddon
import com.bits.bee.bpmc.data.list.ListPromoBonus
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Saled
import java.math.BigDecimal

/**
 * Created by aldi on 13/09/22
 */
data class KlaimPromoState(
    var index : Int = 0,
    var maxIndex : Int = -1,
    var listQtyPerPromo : MutableList<BigDecimal> = mutableListOf(),
    var promoBonus: ListPromoBonus.PromoBonus? = null,
    var qtyPromo : BigDecimal = BigDecimal.ZERO,
    var qtyItem : BigDecimal = BigDecimal.ZERO,
    var qtyPerPromo : BigDecimal = BigDecimal.ZERO,
    var itemListBonus : List<Item> = mutableListOf(),
    var saledList : List<Saled> = mutableListOf(),
    var listPromoBonus: ListPromoBonus? = null,
    var isPromoBonus : Boolean = false,
    var totalQtyPromo : BigDecimal = BigDecimal.ZERO,
    var listItemBonusAddon: ListItemBonusAddon = ListItemBonusAddon(),
    var finishBonus : Boolean = false,
    var bp : Bp? = null,
    var priceLvlId : Int = 1
)