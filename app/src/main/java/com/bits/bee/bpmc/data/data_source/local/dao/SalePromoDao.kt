package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.SalePromoEntity

@Dao
interface SalePromoDao: BaseDao<SalePromoEntity> {

    @Query("SELECT * FROM salepromo where sale_id = :id")
    fun getSalePromoBySale(id: Int): List<SalePromoEntity>

    @Query("SELECT a.* FROM salepromo a JOIN promo b ON b.id = a.promo_id WHERE a.sale_id = :saleId AND a.promorole = 'D' AND a.saled_id = :saledId AND (b.promo_cat = 'BONUS' OR b.itemdiscexp = '100%')")
    fun getPromoBySaledBonus(saleId: Int, saledId : Int): List<SalePromoEntity>

}