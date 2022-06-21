package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.PriceDao
import com.bits.bee.bpmc.domain.mapper.PriceDataMapper
import com.bits.bee.bpmc.domain.model.Price
import com.bits.bee.bpmc.domain.repository.PriceRepository
import javax.inject.Inject

/**
 * Created by aldi on 13/05/22.
 */
class PriceRepositoryImpl @Inject constructor(
    private val priceDao: PriceDao
) : PriceRepository {

    override fun getPriceByPriceLvl(priceLvlId: Int, itemId : Int): Price? {
        val price = priceDao.getPriceByPriceLvlItem(priceLvlId, itemId)
        price?.let {
            return PriceDataMapper.fromDataToDomain(price)
        }
        return null
    }

}