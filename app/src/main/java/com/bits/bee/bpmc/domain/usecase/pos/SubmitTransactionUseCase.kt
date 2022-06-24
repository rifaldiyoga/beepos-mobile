package com.bits.bee.bpmc.domain.usecase.pos

import com.bits.bee.bpmc.data.data_source.local.dao.SaleDao
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.repository.*
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

/**
 * Created by aldi on 20/05/22.
 */
class SubmitTransactionUseCase @Inject constructor(
    private val saleRepository: SaleRepository,
    private val saledRepository: SaledRepository,
    private val possesRepository: PossesRepository,
    private val cashierRepository: CashierRepository,
    private val operatorRepository: OperatorRepository,
    private val saleDao: SaleDao
){

    suspend operator fun invoke(sale : Sale, saled : List<Saled>) {
        possesRepository.getActivePosses().collect {
            it?.let {
                sale.possesId = it.possesId!!
            }
        }
        cashierRepository.getActiveCashier().collect {
            it?.let {
                sale.cashierId = it.id
                sale.cashiername = it.cashierName
            }
        }
        operatorRepository.getActiveOperator().collect {
            it?.let {
                sale.operatorId = it.id
                sale.oprName = it.operator
            }
        }

        val id = saleRepository.addSale(sale)


        saled.map {
            it.saleId = id.toInt()
        }
        saledRepository.addSaled(saled)
    }
}