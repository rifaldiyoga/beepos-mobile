package com.bits.bee.bpmc.domain.usecase.signup

import com.bits.bee.bpmc.domain.mapper.UnitDummyDummyDataMapper
import com.bits.bee.bpmc.domain.model.ItemDummy
import com.bits.bee.bpmc.domain.model.UnitDummy
import com.bits.bee.bpmc.domain.repository.ItemDummyRepository
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import com.bits.bee.bpmc.domain.repository.UnitDummyRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * Created by aldi on 01/09/22.
 */
class AddEditProdukUseCase @Inject constructor(
    private val itemDummyRepository: ItemDummyRepository,
    private val itemGroupRepository: ItemGroupRepository,
    private val unitDummyRepository: UnitDummyRepository,
){

    var grpId = -1

    suspend operator fun invoke(
        itemDummy: ItemDummy,
        kategoriProduk: String,
        unitList: MutableList<UnitDummy>,
        edit: Boolean
    ){
        if (kategoriProduk.isNotEmpty()){
            val itemgrps = itemGroupRepository.getItgrpByKategori(kategoriProduk).first()
            grpId = itemgrps.id ?: -1
        }
        itemDummy.itemGroupId = grpId
        itemDummyRepository.addItemDummy(itemDummy).first()

        if (unitList.isNotEmpty()){
            for ((index, _) in unitList.withIndex()){
                val itemDummy = itemDummyRepository.getLastId().first()
                val unitDummy = unitList.get(index)
                unitDummy.id = null
                unitDummy.itemId = itemDummy.id!!
                unitDummy.idx = index+1

                unitDummyRepository.addUpdate(UnitDummyDummyDataMapper.fromDomainToDb(unitDummy), edit)
            }
        }

    }

}