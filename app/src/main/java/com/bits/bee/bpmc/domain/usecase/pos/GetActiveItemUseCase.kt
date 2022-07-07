package com.bits.bee.bpmc.domain.usecase.pos

import androidx.paging.PagingData
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.repository.ItemRepository
import com.bits.bee.bpmc.domain.repository.PriceRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/**
 * Created by aldi on 12/05/22.
 */
class GetActiveItemUseCase @Inject constructor(
    private val itemRepository: ItemRepository,
    private val priceRepository: PriceRepository,
    private val defaultDispatcher: CoroutineDispatcher
) {

    operator fun invoke(itemGrpId : Int, priceLvlId : Int = 1, bp : Bp) : Flow<PagingData<Item>> = itemRepository.getActiveItemList("")

//            emit(Resource.loading())
//            val data = when(itemGrpId > -1){
//                true -> itemRepository.getActiveItemListByItemGrp(itemGrpId)
//                false -> itemRepository.getActiveItemList()
//            }
//            data.collect {
//                for (item in it){
//                    val price = priceRepository.getPriceByPriceLvl(priceLvlId, item.id)
//                    val saleistaxed: Boolean = bp.isTaxedOnSale
//                    val saletaxinc: Boolean = bp.isTaxIncOnSale
//                    val price_lvl: Int = bp.priceLvlId
//                    try {
//                        if (saletaxinc) {
//                            mItem.setPrice(
//                                if (ItemTaxDao
//                                        .getItemTaxItem(mItem.getCodeitem()) != null
//                                ) ItemPriceDao.getItemPriceDao().getPriceByCodeItem(
//                                    mItem.getCodeitem(),
//                                    price_lvl
//                                ) else ItemPriceDao.getItemPriceDao()
//                                    .getPriceByCodeItem(mItem.getCodeitem(), price_lvl)
//                            )
//                            val tax: String =
//                                ItemTaxDao.getItemTaxItem(mItem.getCodeitem())
//                            mItem.setTax(tax ?: "")
//                        } else if (saleistaxed) {
//                            mItem.setPrice(
//                                ItemPriceDao.getItemPriceDao()
//                                    .getPriceByCodeItem(mItem.getCodeitem(), price_lvl)
//                            )
//                            val tax: String =
//                                ItemTaxDao.getItemTaxItem(mItem.getCodeitem())
//                            mItem.setTax(tax ?: "")
//                        } else if (!saleistaxed && !saletaxinc) {
//                            mItem.setPrice(
//                                ItemPriceDao.getItemPriceDao()
//                                    .getPriceByCodeItem(mItem.getCodeitem(), price_lvl)
//                            )
//                            mItem.setTax("")
//                        } else if (saleistaxed && saleistaxed) {
//                            mItem.setPrice(
//                                if (ItemTaxDao
//                                        .getItemTaxItem(mItem.getCodeitem()) != null
//                                ) ItemPriceDao.getItemPriceDao()
//                                    .getPriceByCodeItem(mItem.getCodeitem(), price_lvl)
//                                    .divide(
//                                        BPMConstants.SALETAXINCDIVIDER,
//                                        2,
//                                        RoundingMode.HALF_UP
//                                    ) else ItemPriceDao.getItemPriceDao()
//                                    .getPriceByCodeItem(mItem.getCodeitem(), price_lvl)
//                            )
//                            val tax: String =
//                                ItemTaxDao.getItemTaxItem(mItem.getCodeitem())
//                            mItem.setTax(tax ?: "")
//                        }
//                    } catch (e: SQLException) {
//                        e.printStackTrace()
//                    }
//                    price?.let {
//                        item.price = it.price
//                    }
//                }
//                emit(Resource.success(it))
//            }

//        }.flowOn(defaultDispatcher)
//    }

}