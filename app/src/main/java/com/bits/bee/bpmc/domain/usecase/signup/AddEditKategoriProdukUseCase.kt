package com.bits.bee.bpmc.domain.usecase.signup

import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class AddEditKategoriProdukUseCase @Inject constructor(
    private val itemGroupRepository: ItemGroupRepository
) {

    suspend operator fun invoke(namaKategori: String, parentKategori: String, edit: Boolean, olId: Int) {
        var upId : Int? = null
        val itmgrp: ItemGroup?

        if (parentKategori.isNotEmpty()){
            val itmgrpss = itemGroupRepository.getItgrpByKategori(parentKategori).first()
            upId = itmgrpss.id
        }

        itmgrp = ItemGroup(
            id =  if (edit) olId else null,
            code = "",
            name = namaKategori,
            level = if(upId != null) 2 else 1,
            upId = upId,
            isPos = true
        )

        itemGroupRepository.addItemgrp(itmgrp, edit)
    }
}