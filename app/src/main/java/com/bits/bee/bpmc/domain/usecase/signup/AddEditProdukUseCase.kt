package com.bits.bee.bpmc.domain.usecase.signup

import com.bits.bee.bpmc.domain.model.ItemDummy
import com.bits.bee.bpmc.domain.repository.ItemDummyRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * Created by aldi on 01/09/22.
 */
class AddEditProdukUseCase @Inject constructor(
    private val itemDummyRepository: ItemDummyRepository
){

    suspend operator fun invoke(itemDummy: ItemDummy){
        itemDummyRepository.addItemDummy(itemDummy).first()
    }

}