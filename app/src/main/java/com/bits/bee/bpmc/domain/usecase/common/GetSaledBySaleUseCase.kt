package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.repository.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by aldi on 24/06/22.
 */
class GetSaledBySaleUseCase @Inject constructor(
    private val saledRepository: SaledRepository,
    private val itemRepository: ItemRepository,
    private val unitRepository: UnitRepository,
    private val crcRepository: CrcRepository,
    private val selectionDRepository: SelectionDRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) {

    operator fun invoke(saleId : Int) : Flow<List<Saled>> = flow {
        val saledList = saledRepository.getSaledList(saleId).first()
        saledList.map {
            it.crcSymbol = crcRepository.getCrcById(it.crcId!!).first()?.symbol ?: ""
            it.item = itemRepository.getItemById(it.itemId).first()
            if(selectionDRepository.getSelectionByItem(it.itemId).first() != null) {
                it.item = it.item?.copy(isAddOn = true)
                it.isAddOn = true
            }
            if(it.unitId != null)
                it.unit = unitRepository.getUnitById(it.unitId!!).first()?.unit ?: ""
        }
        emit(saledList)
    }.flowOn(coroutineDispatcher)

}