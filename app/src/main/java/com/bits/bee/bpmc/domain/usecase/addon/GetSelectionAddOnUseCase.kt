package com.bits.bee.bpmc.domain.usecase.addon

import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.SelectionWithItem
import com.bits.bee.bpmc.domain.repository.ItemRepository
import com.bits.bee.bpmc.domain.repository.SelectionRepository
import com.bits.bee.bpmc.domain.usecase.common.GetPriceItemUseCase
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by aldi on 15/08/22.
 */
class GetSelectionAddOnUseCase @Inject constructor(
    private val selectionRepository: SelectionRepository,
    private val itemRepository: ItemRepository,
    private val getPriceItemUseCase: GetPriceItemUseCase
) {

    suspend operator fun invoke(item: Item, priceLvlId : Int, bp: Bp) : Flow<Resource<List<SelectionWithItem>>>  = flow {
        emit(Resource.loading())
        val selection = selectionRepository.getSelectionByItem(item.id).first()
        val selectionList : MutableList<SelectionWithItem> = mutableListOf()

        for (data in selection){
            val itemList = itemRepository.getItemBySelection(data.id).first()
            itemList.map {
                it.isAddOn = true
                getPriceItemUseCase(it, priceLvlId, bp)
            }
            val selectionWithItem = SelectionWithItem(selection = data, itemList = itemList)
            selectionList.add(selectionWithItem)
        }
        emit(Resource.success(selectionList))
    }

}