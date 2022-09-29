package com.bits.bee.bpmc.presentation.ui.pos

import com.bits.bee.bpmc.domain.model.*

/**
 * Created by aldi on 22/04/22.
 */
data class MainState(
    var bp : Bp? = null,
    var channel : Channel? = null,
    var channelList : List<Channel> = mutableListOf(),
    var sale : Sale = Sale(),
    var saledList : MutableList<Saled> = mutableListOf(),
    var saleAddOn : SaleAddOn = SaleAddOn(),
    var saleAddOnDList : MutableList<SaleAddOnD> = mutableListOf(),
    var salePromoList : MutableList<SalePromo> = mutableListOf(),
    var activeCashier : Cashier? = null,
    var activeBranch : Branch? = null,
    var activePosses : Posses? = null,
    var crc: Crc? = null,
    var itgrpAddOn : ItemGroup? = null
)