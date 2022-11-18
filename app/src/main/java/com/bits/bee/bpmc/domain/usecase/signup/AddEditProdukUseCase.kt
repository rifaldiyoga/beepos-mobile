package com.bits.bee.bpmc.domain.usecase.signup

import com.bits.bee.bpmc.domain.mapper.UnitDummyDummyDataMapper
import com.bits.bee.bpmc.domain.model.ItemDummy
import com.bits.bee.bpmc.domain.model.UnitDummy
import com.bits.bee.bpmc.domain.repository.BrandRepository
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
    private val brandRepository: BrandRepository,
    private val unitDummyRepository: UnitDummyRepository
){

    var grpId = -1
    var brndId = -1

    suspend operator fun invoke(
        itemDummy: ItemDummy,
        kategoriProduk: String,
        merkProduk: String,
        unitList: MutableList<UnitDummy>,
        edit: Boolean,
        itemId: Int
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

        if (unitList.isNotEmpty()){
            for ((index, value) in unitList.withIndex()){
                val itemDummy = itemDummyRepository.getLastId().first()
                val unitDummy = unitList.get(index)
                unitDummy.id = null
                unitDummy.itemId = if (edit) itemId else itemDummy.id ?: 1
                unitDummy.idx = index+1

                unitDummyRepository.addUpdate(UnitDummyDummyDataMapper.fromDomainToDb(unitDummy), edit)

            }
        }

    }

}