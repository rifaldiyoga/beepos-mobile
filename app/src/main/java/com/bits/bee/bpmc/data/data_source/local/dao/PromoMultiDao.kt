package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.PromoMultiEntity

/**
 * Created by aldi on 07/06/22.
 */
@Dao
interface PromoMultiDao : BaseDao<PromoMultiEntity>{

    @Query("SELECT * FROM promomulti")
    fun getPromoMultiList() : List<PromoMultiEntity>

    @Query("SELECT * FROM promomulti WHERE promo_id = :promoId")
    fun getPromoMultiByPromo(promoId : Int) : List<PromoMultiEntity>

    @Query("SELECT * FROM promomulti WHERE promo_id = :promoId AND isreq = 1")
    fun getSyaratPromoMultiByPromo(promoId: Int) : List<PromoMultiEntity>

    @Query("SELECT * FROM promomulti WHERE promo_id = :promoId AND isdeal = 1")
    fun getOfferPromoMultiByPromo(promoId: Int) : List<PromoMultiEntity>

    @Query("SELECT * FROM promomulti WHERE promo_id = :promoId AND value = :branchId AND type = 'BRANCH'")
    fun getBranchPromoMultiByPromo(promoId: Int, branchId : Int) : List<PromoMultiEntity>

}