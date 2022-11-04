package com.bits.bee.bpmc.domain.usecase.signup

import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class AddEditKategoriProdukUseCase @Inject constructor(
    private val itemGroupRepository: ItemGroupRepository
) {
    private var up_id = -1

    suspend operator fun invoke(
        namaKategori: String,
        parentKategori: String,
        edit: Boolean,
        olId: Int
    ) {
        val itmgrpss = itemGroupRepository.getItgrpByKategori(parentKategori).first()
        var itmgrp: ItemGroup? = null

        if (parentKategori.isNotEmpty()){
            up_id = itmgrpss.id ?: 1
        }
        if (edit){
            itmgrp = ItemGroup(
                id = olId,
                code = "",
                name = namaKategori,
                level = -1,
                upId = up_id,
                isPos = false
            )
        }else{
            itmgrp = ItemGroup(
                code = "",
                name = namaKategori,
                level = -1,
                upId = up_id,
                isPos = false
            )
        }
        itemGroupRepository.addItemgrp(itmgrp, edit)
    }
}