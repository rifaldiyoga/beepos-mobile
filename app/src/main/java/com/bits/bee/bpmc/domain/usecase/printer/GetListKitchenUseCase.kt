package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.domain.model.Kitchen
import com.bits.bee.bpmc.domain.model.PrinterKitchen
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import com.bits.bee.bpmc.domain.repository.KitchenRepository
import com.bits.bee.bpmc.domain.repository.PrinterKitchenDRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetListKitchenUseCase @Inject constructor(
    private val printerKitchenDRepo: PrinterKitchenDRepository,
    private val kitchenRepo: KitchenRepository,
    private val itemGoupRepo: ItemGroupRepository,
    private val defaultDispatcher: CoroutineDispatcher
) {

    var kitchen: Kitchen? = null
    var itemgrp: ItemGroup? = null
    var listhashMap : HashMap<Int, MutableList<Kitchen>> = HashMap()

    operator fun invoke(mList: List<PrinterKitchen>, data_kitchen: Boolean): Flow<HashMap<Int, MutableList<Kitchen>>> {
        return flow {
            for((index, printerKitchen) in mList.withIndex()){
                val mListPrinterKitchenD = printerKitchenDRepo.getPrinterKitchen(printerKitchen.id!!).first()

                val kitchenList: MutableList<Kitchen> = mutableListOf()
                for (printerD in mListPrinterKitchenD){
                    val kitchen = kitchenRepo.getKitchenId(printerD.kitchenId).first()

                    if (data_kitchen){
                        kitchenList.add(kitchen)
                    }else{
                        val itemGrp = itemGoupRepo.getById(printerD.kitchenId).first()

                        val kitchenNew = Kitchen(
                            id = itemGrp.id!!,
                            name = itemGrp.name,
                        )
                        kitchenList.add(kitchenNew)
                    }
                }
                listhashMap.put(index, kitchenList)
                emit(listhashMap)
            }
        }.flowOn(defaultDispatcher)
    }
}