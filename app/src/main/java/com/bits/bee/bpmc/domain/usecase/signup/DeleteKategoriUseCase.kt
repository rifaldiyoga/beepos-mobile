package com.bits.bee.bpmc.domain.usecase.signup

import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import javax.inject.Inject

class DeleteKategoriUseCase @Inject constructor(
    private val itemGroupRepository: ItemGroupRepository
) {
    suspend operator fun invoke(itemGroup: ItemGroup){
        itemGroupRepository.deleteItmgrp(itemGroup)
        if (itemGroup.upId == null){
            itemGroupRepository.deleteChildKategori(itemGroup.id!!)
        }
    }
}