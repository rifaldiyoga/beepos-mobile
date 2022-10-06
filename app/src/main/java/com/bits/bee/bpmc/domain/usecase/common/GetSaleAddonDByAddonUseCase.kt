package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.model.SaleAddOnD
import com.bits.bee.bpmc.domain.repository.SaleAddOnDRepository
import com.bits.bee.bpmc.domain.repository.SaleAddOnRepository
import com.bits.bee.bpmc.domain.repository.SaledRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetSaleAddonDByAddonUseCase @Inject constructor(
    private val saleAddOnDRepository: SaleAddOnDRepository,
    private val saleAddOnRepository: SaleAddOnRepository,
    private val saledRepository: SaledRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) {
    operator fun invoke(id: Int): Flow<List<SaleAddOnD>> = flow{
        val saledAddOnDList = saleAddOnDRepository.getSaleAddonDbyAddon(id).first()
        saledAddOnDList.map {
            it.saled = saledRepository.getSaledById(it.saled?.id!!).first()
            it.upSaled = saledRepository.getSaledById(it.upSaled?.id!!).first()
            it.saleAddOn = saleAddOnRepository.getSaleAddonBySale(it.saleAddOn?.id!!).first()
        }
        emit(saledAddOnDList)
    }.flowOn(coroutineDispatcher)
}