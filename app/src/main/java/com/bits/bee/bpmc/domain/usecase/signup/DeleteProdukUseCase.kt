package com.bits.bee.bpmc.domain.usecase.signup

import com.bits.bee.bpmc.domain.model.ItemDummy
import com.bits.bee.bpmc.domain.model.UnitDummy
import com.bits.bee.bpmc.domain.repository.ItemDummyRepository
import com.bits.bee.bpmc.domain.repository.UnitDummyRepository
import javax.inject.Inject

class DeleteProdukUseCase @Inject constructor(
    private val itemDummyRepository: ItemDummyRepository,
    private val unitDummyRepository: UnitDummyRepository
) {
    suspend operator fun invoke(itemDummy: ItemDummy, unitList: MutableList<UnitDummy>){
        if (unitList.size > 0){
            unitDummyRepository.deleteByItem(itemDummy.id!!)
        }
        itemDummyRepository.deleteItemDummy(itemDummy)
    }
}