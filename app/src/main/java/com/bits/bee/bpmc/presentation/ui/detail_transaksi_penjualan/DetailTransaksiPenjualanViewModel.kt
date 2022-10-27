package com.bits.bee.bpmc.presentation.ui.detail_transaksi_penjualan

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.SaleAddOnD
import com.bits.bee.bpmc.domain.repository.CrcRepository
import com.bits.bee.bpmc.domain.usecase.common.GetSaleAddOnBySaleUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetSaleAddonDByAddonUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetSaledBySaleUseCase
import com.bits.bee.bpmc.domain.usecase.transaksi_penjualan.VoidTransactionUseCase
import com.bits.bee.bpmc.domain.usecase.upload_manual.GetSalecrcvBySaleUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 23/06/22.
 */
@HiltViewModel
class DetailTransaksiPenjualanViewModel @Inject constructor(
    private val getSaledBySaleUseCase: GetSaledBySaleUseCase,
    private val getSaleAddOnBySaleUseCase: GetSaleAddOnBySaleUseCase,
    private val getSaleAddonDByAddonUseCase: GetSaleAddonDByAddonUseCase,
    private val getSalecrcvBySaleUseCase: GetSalecrcvBySaleUseCase,
    private val voidTransactionUseCase: VoidTransactionUseCase,
    private val crcRepository: CrcRepository
): BaseViewModel<DetailTransaksiPenjualanState, DetailTransaksiPenjualanViewModel.UIEvent>(){

    init {
        state = DetailTransaksiPenjualanState()
    }

    fun onClickVoid() = viewModelScope.launch {
        voidTransactionUseCase(state.sale!!)
        eventChannel.send(UIEvent.SuccessVoid)
    }

    fun getSaledList() = viewModelScope.launch {
        state.sale?.let {
            var saledList = getSaledBySaleUseCase(it.id!!).first()
            val saleAddOn = getSaleAddOnBySaleUseCase(it.id!!).first()
            val saleCrcvList = getSalecrcvBySaleUseCase(it.id!!).first()
            var saleAddOnDList : List<SaleAddOnD> = mutableListOf()
            val crc = if(it.crcId != null) crcRepository.getCrcById(it.crcId!!).first() else null
            saleAddOn?.let {
                saleAddOnDList = getSaleAddonDByAddonUseCase(saleAddOn.id!!).first()
                saledList = saledList.filter { !saleAddOnDList.map { it.saled?.id ?: -1 }.contains(it.id) }
            }
            updateState(
                state.copy(
                    saledList = saledList,
                    saleAddOnDList = saleAddOnDList,
                    crc = crc,
                    saleCrcvList = saleCrcvList
                )
            )

        }
    }

    sealed class UIEvent {
        object SuccessVoid : UIEvent()
    }

}