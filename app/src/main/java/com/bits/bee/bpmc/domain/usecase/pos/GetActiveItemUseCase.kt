package com.bits.bee.bpmc.domain.usecase.pos

import com.bits.bee.bpmc.data.data_source.local.dao.PriceDao
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.repository.ItemRepository
import com.bits.bee.bpmc.domain.repository.PriceRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by aldi on 12/05/22.
 */
class GetActiveItemUseCase @Inject constructor(
    private val itemRepository: ItemRepository,
    private val priceRepository: PriceRepository,
    private val defaultDispatcher: CoroutineDispatcher
) {

    operator fun invoke(itemGrpId : Int, priceLvlId : Int = 1) : Flow<Resource<List<Item>>> {
        return flow {
            emit(Resource.loading())
            var data = when(itemGrpId > -1){
                true -> itemRepository.getActiveItemListByItemGrp(itemGrpId)
                false -> itemRepository.getActiveItemList()
            }
            data.collect {
                for (item in it){
                    item.price = priceRepository.getPriceByPriceLvl(priceLvlId).price
                }
                emit(Resource.success(it))
            }

        }.flowOn(defaultDispatcher)
    }

}