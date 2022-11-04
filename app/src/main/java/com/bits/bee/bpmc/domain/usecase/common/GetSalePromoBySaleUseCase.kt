package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.model.SalePromo
import com.bits.bee.bpmc.domain.repository.BpRepository
import com.bits.bee.bpmc.domain.repository.PromoRepository
import com.bits.bee.bpmc.domain.repository.SalePromoRepository
import com.bits.bee.bpmc.domain.repository.SaledRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GetSalePromoBySaleUseCase @Inject constructor(
    private val salePromoRepository: SalePromoRepository,
    private val promoRepository: PromoRepository,
    private val saledRepository: SaledRepository,
    private val bpRepository: BpRepository,
    private val dispatcher: CoroutineDispatcher
) {
    operator fun invoke(id: Int): Flow<List<SalePromo>> = flow{
        val salePromoList = salePromoRepository.getSalePromoBySale(id).first()
        salePromoList.map { salePromo ->
            salePromo.promo = promoRepository.getPromoById(salePromo.promo!!.id).first()
            salePromo.saled = saledRepository.getSaledById(salePromo.sale!!.id!!).first()
            salePromo.bp = salePromo.bp?.let { bpRepository.getBpById(salePromo.bp!!.id!!).first() }
        }
        emit(salePromoList)
    }.flowOn(dispatcher)
}