package com.bits.bee.bpmc.data.list

import com.bits.bee.bpmc.domain.model.Promo
import com.bits.bee.bpmc.domain.model.Saled
import java.math.BigDecimal

class ListPromoBonus : ArrayList<ListPromoBonus.PromoBonus>() {
    override fun add(promoBonus: PromoBonus): Boolean {
        return if (checkPromoExist(promoBonus.getPromo())) {
            false
        } else super.add(promoBonus)
    }

    private fun checkPromoExist(promo: Promo): Boolean {
        val promoBonuses: List<PromoBonus?> = subList(0, size)
        for (promoBonus in promoBonuses) {
            if (promoBonus!!.getPromo() == promo) {
                return true
            }
        }
        return false
    }

    val totalQtyBonus: BigDecimal
        get() {
            val promoBonuses: List<PromoBonus?> = subList(0, size)
            var result = BigDecimal.ZERO
            for (promoBonus in promoBonuses) {
                result = result.add(promoBonus!!.qty)
            }
            return result
        }

    class PromoBonus(promo: Promo, qty: BigDecimal, saled: Saled?) {
        private var promo: Promo
        var qty: BigDecimal
        private var saled: Saled?

        fun getPromo(): Promo {
            return promo
        }

        init {
            this.promo = promo
            this.qty = qty
            this.saled = saled
        }
    }
}