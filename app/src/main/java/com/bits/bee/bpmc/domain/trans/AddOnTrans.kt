package com.bits.bee.bpmc.domain.trans

import com.bits.bee.bpmc.domain.model.SaleAddOn
import com.bits.bee.bpmc.domain.model.SaleAddOnD
import com.bits.bee.bpmc.domain.model.Saled


/**
 * Created by aldi on 23/08/22.
 */
class AddOnTrans : BaseTrans<SaleAddOn, SaleAddOnD>() {

    override fun newTrans() {
        mTblMaster = SaleAddOn()
    }

    override fun saveTrans() {
    }

    override fun voidTrans() {
    }

    override fun loadTrans(var1: SaleAddOn) {

    }

    fun isExistUpSaled(saled: Saled): Boolean = getListDetail().firstOrNull{ it.upSaled == saled } != null

}