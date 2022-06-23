package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.domain.model.Kitchen
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import com.bits.bee.bpmc.domain.repository.KitchenRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetKategoriPrinterKitchenUseCase @Inject constructor(
    private val kitchenRepo: KitchenRepository,
    private val itemGrpRepo: ItemGroupRepository,
    private val defaultDispatcher: CoroutineDispatcher
) {
    private var mutListKitchen = mutableListOf<Kitchen>()
    private var itmGrpList: List<ItemGroup>? = null

    operator fun invoke(data_kitchen: Boolean) : Flow<Resource<MutableList<Kitchen>>> {
        return flow {
            if (data_kitchen){
                kitchenRepo.readKitchen().collect {
                    it.data?.let { data ->
                        mutListKitchen = data
                    }
                }
            }else{
                itemGrpRepo.getItemgrpKitchen().collect {
                    it.data?.let { data ->
                        itmGrpList = data
                    }
                }
                for (itemgrp in itmGrpList!!){
                    var kitchen = Kitchen(id = itemgrp.id, name = itemgrp.name)
                    mutListKitchen.add(kitchen)
                }
            }
            emit(Resource.success(mutListKitchen))
        }.flowOn(defaultDispatcher)

//        return mutListKitchen
    }
}