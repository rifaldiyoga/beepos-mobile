package com.bits.bee.bpmc.domain.usecase.transaksi_penjualan

import androidx.paging.PagingData
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.repository.SaleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 23/06/22.
 */
class GetLatestSaleUseCase @Inject constructor(
    private val saleRepository: SaleRepository
){

    operator fun invoke(query : String, isDraft : Boolean) : Flow<PagingData<Sale>> = saleRepository.getLatestSaleList(query, isDraft)

}