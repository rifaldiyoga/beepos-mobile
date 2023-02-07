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

    operator fun invoke(printerKitchen: PrinterKitchen, data_kitchen: Boolean): Flow<MutableList<Kitchen>> {
        return flow {
            val mListPrinterKitchenD = printerKitchenDRepo.getPrinterKitchen(printerKitchen.id!!).first()

            val kitchenList: MutableList<Kitchen> = mutableListOf()
            for (printerD in mListPrinterKitchenD){
                if (data_kitchen){
                    val kitchen = kitchenRepo.getKitchenId(printerD.kitchenId).first()
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
            emit(kitchenList)
        }.flowOn(defaultDispatcher)
    }

}