package com.bits.bee.bpmc.domain.usecase.pos

import com.bits.bee.bpmc.data.data_source.local.dao.*
import com.bits.bee.bpmc.domain.mapper.BranchDataMapper
import com.bits.bee.bpmc.domain.mapper.CashierDataMapper
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.repository.SaleRepository
import com.bits.bee.bpmc.domain.repository.SaledRepository
import com.bits.bee.bpmc.utils.TrxNoGeneratorUtils
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

/**
 * Created by aldi on 20/05/22.
 */
class SubmitDraftTransactionUseCase @Inject constructor(
    private val saleRepository: SaleRepository,
    private val saledRepository: SaledRepository,
    private val branchDao: BranchDao,
    private val cashierDao: CashierDao,
    private val userDao: UserDao,
    private val possesDao: PossesDao,
    private val saleDao: SaleDao,
    private val defDispatcher: CoroutineDispatcher
){

    suspend operator fun invoke(sale : Sale, saled : List<Saled>) {
        withContext(defDispatcher){
            val branch = branchDao.getActiveBranch()
            val cashier = cashierDao.getActiveCashier()
            val user = userDao.geActiveUser()
            val posses = possesDao.getActivePosses()


            cashier?.let {
                sale.cashierId = it.id
                sale.cashiername = it.cashierName
            }
            user.let {
                sale.operatorId = it.id
                sale.userName = it.name
            }
            posses?.let {
                sale.possesId = it.possesId!!
                sale.kodePosses = it.trxNo
            }


            sale.trxNo = TrxNoGeneratorUtils.counterNoTrx(1,BranchDataMapper.fromDataToDomain(branch!!), CashierDataMapper.fromDataToDomain(cashier!!))
            sale.trxDate = Date()
            sale.isDraft = true
            val id = saleRepository.addSale(sale)

            saled.map {
                it.saleId = id.toInt()
            }
            saledRepository.addSaled(saled)

        }
    }
}