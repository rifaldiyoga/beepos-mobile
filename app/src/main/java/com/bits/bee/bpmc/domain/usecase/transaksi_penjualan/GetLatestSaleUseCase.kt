package com.bits.bee.bpmc.domain.usecase.transaksi_penjualan

import androidx.paging.PagingData
import androidx.paging.map
import com.bits.bee.bpmc.domain.model.Channel
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.repository.ChannelRepository
import com.bits.bee.bpmc.domain.repository.SaleRepository
import com.bits.bee.bpmc.domain.repository.SrepRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by aldi on 23/06/22.
 */
class GetLatestSaleUseCase @Inject constructor(
    private val saleRepository: SaleRepository,
    private val channelRepository: ChannelRepository,
    private val srepRepository: SrepRepository
){

    operator fun invoke(query : String, isDraft : Boolean, channelList: List<Channel>, startDate : Long, endDate : Long) : Flow<PagingData<Sale>> =
        saleRepository.getLatestSaleList(query, isDraft, channelList.map { it.id }, startDate, endDate).map { data ->
            data.map { sale ->
                val channel = channelRepository.getChannelById(sale.channelId).first()
                sale.channel = channel?.name ?: ""

                sale.srepId?.let {
                    val srep = srepRepository.getSrepById(it).first()
                    sale.salesman = srep?.name ?: ""
                }
                sale
            }
        }

}