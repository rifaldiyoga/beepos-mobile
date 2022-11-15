package com.bits.bee.bpmc.domain.usecase.signup

import com.bits.bee.bpmc.domain.model.ItemDummy
import com.bits.bee.bpmc.domain.repository.BrandRepository
import com.bits.bee.bpmc.domain.repository.ItemDummyRepository
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * Created by aldi on 01/09/22.
 */
class AddEditProdukUseCase @Inject constructor(
    private val itemDummyRepository: ItemDummyRepository,
    private val itemGroupRepository: ItemGroupRepository,
    private val brandRepository: BrandRepository
){

    var grpId = -1
    var brndId = -1

    suspend operator fun invoke(
        itemDummy: ItemDummy,
        kategoriProduk: String,
        merkProduk: String
    ){
        if (kategoriProduk.isNotEmpty()){
            val itemgrps = itemGroupRepository.getItgrpByKategori(kategoriProduk).first()
            grpId = itemgrps.id ?: -1
        }
        if (merkProduk.isNotEmpty()){
            val brands = brandRepository.getBrandByName(merkProduk).first()
            brndId = brands.id ?: -1
        }
        itemDummy.itemGroupId = grpId
        itemDummy.brandId = brndId
        itemDummyRepository.addItemDummy(itemDummy).first()
    }

}