package com.bits.bee.bpmc.domain.usecase.transaksi_penjualan

import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.repository.SaleRepository
import javax.inject.Inject

/**
 * Created by aldi on 11/08/22.
 */
class VoidTransactionUseCase @Inject constructor(
    private val saleRepository: SaleRepository
){

    suspend operator fun invoke(sale : Sale) {
        sale.isVoid = true
        saleRepository.updateSale(sale)
    }

}