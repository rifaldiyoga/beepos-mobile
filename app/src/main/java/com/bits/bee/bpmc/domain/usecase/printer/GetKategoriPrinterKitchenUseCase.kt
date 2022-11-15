package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.domain.model.Kitchen
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import com.bits.bee.bpmc.domain.repository.KitchenRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetKategoriPrinterKitchenUseCase @Inject constructor(
    private val kitchenRepo: KitchenRepository,
    private val itemGrpRepo: ItemGroupRepository,
    private val defaultDispatcher: CoroutineDispatcher
) {

    operator fun invoke(data_kitchen: Boolean) : Flow<MutableList<Kitchen>> {
        return flow {
            if (data_kitchen){
                emit(kitchenRepo.readKitchen().first())
            }else{
                val data = itemGrpRepo.getActiveItemGroupList().first()
                    .filter { it.id != 1 || it.id != -1 }
                    .map { Kitchen(id = it.id!!, name = it.name) }
                    .toMutableList()

                emit(data)
            }
        }.flowOn(defaultDispatcher)

    }
}