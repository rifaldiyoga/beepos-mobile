package com.bits.bee.bpmc.domain.usecase.signup

import com.bits.bee.bpmc.domain.mapper.UnitDummyDummyDataMapper
import com.bits.bee.bpmc.domain.model.ItemDummy
import com.bits.bee.bpmc.domain.model.UnitDummy
import com.bits.bee.bpmc.domain.repository.ItemDummyRepository
import com.bits.bee.bpmc.domain.repository.UnitDummyRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * Created by aldi on 01/09/22.
 */
class AddEditProdukUseCase @Inject constructor(
    private val itemDummyRepository: ItemDummyRepository,
    private val unitDummyRepository: UnitDummyRepository,
){

    suspend operator fun invoke(
        itemDummy: ItemDummy,
        unitList: MutableList<UnitDummy>,
        edit: Boolean
    ){
        itemDummy.id?.let {
            unitDummyRepository.deleteByItem(it)
        }
        itemDummyRepository.addItemDummy(itemDummy).first()

        unitList.forEachIndexed { index, unitDummy ->
            val itemDummyLast = itemDummyRepository.getLastId().first()
            unitDummy.id = null
            unitDummy.itemId = itemDummyLast.id!!
            unitDummy.idx = index + 1

            unitDummyRepository.addUpdate(UnitDummyDummyDataMapper.fromDomainToDb(unitDummy), edit)
        }
    }

}