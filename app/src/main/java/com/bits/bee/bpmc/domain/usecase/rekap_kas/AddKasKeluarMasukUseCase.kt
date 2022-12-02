package com.bits.bee.bpmc.domain.usecase.rekap_kas

import com.bits.bee.bpmc.domain.mapper.CadjDataMapper
import com.bits.bee.bpmc.domain.model.*
import com.bits.bee.bpmc.domain.repository.CadjRepository
import com.bits.bee.bpmc.domain.usecase.common.AddCashAUseCase
import com.bits.bee.bpmc.domain.usecase.common.UpdateTotalPossesUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveUserUseCase
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils
import com.bits.bee.bpmc.utils.TrxNoGeneratorUtils
import kotlinx.coroutines.flow.first
import java.math.BigDecimal
import java.util.*
import javax.inject.Inject

class AddKasKeluarMasukUseCase @Inject constructor(
    private val cadjRepository: CadjRepository,
    private val updateTotalPossesUseCase: UpdateTotalPossesUseCase,
    private val addCashAUseCase: AddCashAUseCase,
    private val getActiveUserUseCase: GetActiveUserUseCase
) {
    suspend operator fun invoke(
        cashierId: Int?,
        note: String,
        reftype: String,
        balance: BigDecimal,
        mPosses: Posses?,
        status: String,
        autogen: Boolean,
        activeCashier: Cashier?,
    ) {
        var amountNew: BigDecimal = BigDecimal.ZERO
        if (status == "i"){
            amountNew = balance
        }else if (status == "o"){
            amountNew = balance.negate()
        }

        val user = getActiveUserUseCase().first()
        val lastCadjId = cadjRepository.getCadjLastRow().first().id ?: 0

        val newCadj = Cadj(
            cashAId = mPosses?.possesId ?: throw IllegalArgumentException("No posses active!"),
            cashierId = cashierId!!,
            operatorId = user?.id ?: throw IllegalArgumentException("No user active!"),
            status = status,
            note = note,
            refType = reftype,
            autoGen = autogen,
            amount = amountNew,
            refNo = mPosses.trxNo,
            kodeCadj = TrxNoGeneratorUtils.counterNoTrxCadj((lastCadjId + 1).toLong(), activeCashier!!),
            trxDate = DateFormatUtils.formatDateToLong(BPMConstants.DATE_FORMAT_RESPONSE, Date()),
            isUploaded = false,
        )

        cadjRepository.addCadj(CadjDataMapper.fromDomainToDb(newCadj))
        updateTotalPossesUseCase(amountNew)
        addCashAUseCase((lastCadjId + 1).toLong(), BPMConstants.BPM_DEFAULT_TYPE_CADJ, mPosses.possesId!!, user.id, activeCashier.id, amountNew)

    }
}