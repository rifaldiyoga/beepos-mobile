package com.bits.bee.bpmc.domain.usecase.signup

import com.bits.bee.bpmc.domain.model.ItemDummy
import com.bits.bee.bpmc.domain.repository.ItemDummyRepository
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * Created by aldi on 01/09/22.
 */
class AddEditProdukUseCase @Inject constructor(
    private val itemDummyRepository: ItemDummyRepository,
    private val itemGroupRepository: ItemGroupRepository
){

    suspend operator fun invoke(itemDummy: ItemDummy, kategoriProduk: String){
       val itemgrps = itemGroupRepository.getItgrpByKategori(kategoriProduk).first()
        itemDummy.itemGroupId = itemgrps.id ?: 1
        itemDummyRepository.addItemDummy(itemDummy).first()
    }

}