package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.domain.model.*
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import com.bits.bee.bpmc.domain.repository.KitchenRepository
import com.bits.bee.bpmc.domain.repository.PrinterKitchenDRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetListKitchenUseCase @Inject constructor(
    private val printerKitchenDRepo: PrinterKitchenDRepository,
    private val kitchenRepo: KitchenRepository,
    private val itemGoupRepo: ItemGroupRepository,
    private val defaultDispatcher: CoroutineDispatcher
) {
    private var  mListPrinterKitchenD: List<PrinterKitchenD>? = null
    var listKitchen = mutableListOf<Kitchen>()
    var kitchen: Kitchen? = null
    var itemgrp: ItemGroup? = null
    var listhashMap : HashMap<Int, MutableList<Kitchen>>
            = HashMap()

    operator fun invoke(mList: List<PrinterKitchen>?, data_kitchen: Boolean): Flow<Resource<HashMap<Int, MutableList<Kitchen>>>> {
        return flow {
            for((index, value) in mList!!.withIndex()){
                var printerKitchen: PrinterKitchen = mList.get(index)

                printerKitchenDRepo.getPrinterKitchen(printerKitchen.id).collect {
                    it.data?.let { data ->
                        mListPrinterKitchenD = data
                    }
                }

                var kitchenList: MutableList<Kitchen> = mutableListOf()
                for (printerD in mListPrinterKitchenD!!){
                    kitchenRepo.getKitchenId(printerD.kitchenId).collect {
                        it.data?.let { data ->
                            kitchen = data
                        }
                    }

                    if (data_kitchen){
                        kitchenList.add(kitchen!!)
                    }else{
                        itemGoupRepo.getId(printerD.kitchenId).collect {
                            it.data?.let { data ->
                                itemgrp = data
                            }
                        }
                        var itmGrp = itemgrp!!
                        val kitchen = Kitchen(
                            id = itmGrp.id,
                            name = itmGrp.name,
                        )
                        kitchenList.add(kitchen)
                    }
                }
                listhashMap.put(index, kitchenList)
//            listMap.put(index, kitchenList)
//                listKitchen.addAll(kitchenList)
                emit(Resource.success(listhashMap))
            }
        }.flowOn(defaultDispatcher)

//        return flow<Resource<MutableList<Kitchen>>> {
//            for((index, value) in mList!!.withIndex()){
//                var printerKitchen: PrinterKitchen = mList.get(index)
//
//                printerKitchenDRepo.getPrinterKitchen(printerKitchen.id).collect {
//                    it.data?.let { data ->
//                        mListPrinterKitchenD = data
//                    }
//                }
//
//                var kitchenList: MutableList<Kitchen> = mutableListOf()
//                for (printerD in mListPrinterKitchenD!!){
//                    kitchenRepo.getKitchenId(printerD.kitchenId).collect {
//                        it.data?.let { data ->
//                            kitchen = data
//                        }
//                    }
//
//                    if (data_kitchen){
//                        kitchenList.add(kitchen!!)
//                    }else{
//                        itemGoupRepo.getId(printerD.kitchenId).collect {
//                            it.data?.let { data ->
//                                itemgrp = data
//                            }
//                        }
//                        var itmGrp = itemgrp!!
//                        val kitchen = Kitchen(
//                            id = itmGrp.id,
//                            name = itmGrp.name,
//                        )
//                        kitchenList.add(kitchen)
//                    }
//                }
//                listhashMap.put(index, kitchenList)
////            listMap.put(index, kitchenList)
////                listKitchen.addAll(kitchenList)
//                emit(Resource.success(listhashMap))
//            }
//        }.flowOn(defaultDispatcher)
    }
}