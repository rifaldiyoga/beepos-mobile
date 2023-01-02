package com.bits.bee.bpmc.presentation.ui.pos

import android.content.Context
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.data.list.ListPromoBonus
import com.bits.bee.bpmc.domain.calc.PromoCalc
import com.bits.bee.bpmc.domain.calc.SaleCalc
import com.bits.bee.bpmc.domain.model.*
import com.bits.bee.bpmc.domain.repository.ChannelRepository
import com.bits.bee.bpmc.domain.repository.CrcRepository
import com.bits.bee.bpmc.domain.repository.PromoRepository
import com.bits.bee.bpmc.domain.repository.SrepRepository
import com.bits.bee.bpmc.domain.trans.SaleTrans
import com.bits.bee.bpmc.domain.usecase.common.*
import com.bits.bee.bpmc.domain.usecase.pos.*
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.TrxNoGeneratorUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.math.BigDecimal
import javax.inject.Inject


/**
 * Created by aldi on 21/04/22.
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getActiveChannelUseCase: GetActiveChannelUseCase,
    private val getActivePossesUseCase: GetActivePossesUseCase,
    private val getActiveCashierUseCase: GetActiveCashierUseCase,
    private val getActiveBranchUseCase: GetActiveBranchUseCase,
    private val getDefaultBpUseCase: GetDefaultBpUseCase,
    private val getDefaultCrcUseCase: GetDefaultCrcUseCase,
    private val getSaledBySaleUseCase: GetSaledBySaleUseCase,
    private val getItemGroupAddOnUseCase: GetItemGroupAddOnUseCase,
    private val addTransactionUseCase: AddTransactionUseCase,
    private val getActiveItemUseCase: GetActiveItemUseCase,
    private val getSalePromoBySaleUseCase: GetSalePromoBySaleUseCase,
    private val getSaleAddOnBySaleUseCase: GetSaleAddOnBySaleUseCase,
    private val getSaleAddonDByAddonUseCase: GetSaleAddonDByAddonUseCase,
    private val getDefaultSalesmanUseCase: GetDefaultSalesmanUseCase,
    private val deleteDetailUseCase: DeleteDetailUseCase,
    private val promoCalc: PromoCalc,
    private val channelRepository: ChannelRepository,
    private val promoRepository: PromoRepository,
    private val crcRepository: CrcRepository,
    private val srepRepository: SrepRepository,
    private val beePreferenceManager: BeePreferenceManager,
    private val getRegUseCase: GetRegUseCase
) : BaseViewModel<MainState, MainViewModel.UIEvent>(){

    private val _posModeState = MutableStateFlow(PosModeState.FnBState)
    @OptIn(FlowPreview::class)
    val posModeState : StateFlow<PosModeState> = _posModeState
        .filterNotNull()
        .flatMapConcat { beePreferenceManager.modePreferences }
        .stateIn(viewModelScope, SharingStarted.Eagerly, PosModeState.FnBState)


    private val _saleTrans: SaleTrans = SaleTrans(promoCalc, SaleCalc(getRegUseCase), promoRepository)
    val saleTrans : SaleTrans
        get() = _saleTrans

    private val _activeItemGroup : MutableStateFlow<Int> = MutableStateFlow(-1)
    val activeItemGroup : MutableStateFlow<Int>
        get() = _activeItemGroup

    private val _activeBp : MutableStateFlow<Bp?> = MutableStateFlow(null)
    val activeBp : MutableStateFlow<Bp?>
        get() = _activeBp

    private val _activeChannel : MutableStateFlow<Channel?> = MutableStateFlow(null)
    val activeChannel : MutableStateFlow<Channel?>
        get() = _activeChannel

    private val _activeSrep : MutableStateFlow<Srep?> = MutableStateFlow(null)
    val activeSrep : MutableStateFlow<Srep?>
        get() = _activeSrep

    val listPromoBonus = promoCalc.listPromoBonus

    val posPreferences = beePreferenceManager.posPreferences

    val orientation : MutableStateFlow<String> = MutableStateFlow(BPMConstants.SCREEN_LANDSCAPE)

    init {
        state = MainState()
        viewModelScope.launch {
            posPreferences.collect {
                orientation.value = it.orientasi
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    val itemList = combine(
        _activeItemGroup,
        _activeBp,
        _activeChannel
    ) { (itemGroup, bp, channel) ->
        ItemParameter(
            itemGroup = itemGroup as Int,
            bp = bp as Bp?,
            channel = channel as Channel?
        )
    }.flatMapLatest {
        getActiveItemUseCase (
            bp = it.bp,
            itemGrpId = it.itemGroup,
            channel = it.channel,
            usePid = posModeState.value is PosModeState.RetailState
        ).cachedIn(viewModelScope)
    }

    fun loadData() = runBlocking {
        combine(
            getDefaultCrcUseCase(),
            getActivePossesUseCase(),
            getActiveBranchUseCase(),
            getActiveCashierUseCase(),
            getActiveChannelUseCase(),
            getDefaultBpUseCase(),
            getItemGroupAddOnUseCase(),
            getDefaultSalesmanUseCase()
        ) { array ->
            val crc = array[0] as Crc?
            val posses = array[1] as Posses?
            val branch = array[2] as Branch
            val cashier = array[3] as Cashier
            val channelList = array[4] as List<Channel>
            val bp = array[5] as Bp
            val itgrpAddOn = array[6] as ItemGroup?
            val srep = array[7] as Srep?

            state.copy(
                crc = crc,
                activePosses = posses,
                activeBranch = branch,
                activeCashier = cashier,
                channelList = channelList,
                channel = if(channelList.isNotEmpty()) channelList[0] else null,
                bp = bp,
                itgrpAddOn = itgrpAddOn,
                srep = srep
            )
        }.collect {
            activeBp.emit(it.bp)
            saleTrans.setBp(it.bp!!)
            activeChannel.emit(it.channel)
            activeSrep.emit(it.srep)
            saleTrans.getMaster().channelId = it.channel?.id ?: -1
            saleTrans.getMaster().srepId = it.srep?.id ?: -1
            saleTrans.setGrpAddOn(it.itgrpAddOn)
            updateState(it)
        }
    }

    fun initPromo() = viewModelScope.launch(exceptionHandler) {
        promoCalc.initPromo(saleTrans)
    }

    suspend fun loadDraft(sale : Sale) {
        val saledList = getSaledBySaleUseCase(sale.id!!).first()
        val saleAddOn = getSaleAddOnBySaleUseCase(sale.id!!).first()
        var saleAddOnDList : List<SaleAddOnD> = mutableListOf()
        saleAddOn?.let {
            saleAddOnDList = getSaleAddonDByAddonUseCase(it.id!!).first()
        }
        val salePromoList = getSalePromoBySaleUseCase(sale.id!!).first()

        saleTrans.loadTrans(sale, saledList.toMutableList(), saleAddOn, saleAddOnDList.toMutableList(), salePromoList.toMutableList())
        sale.bp?.let {
            updateActiveBp(it)
        }
        channelRepository.getChannelById(sale.channelId).first().let {
            it?.let {
                updateActiveChannel(it)
            }
        }
        sale.srepId?.let {
            srepRepository.getSrepById(it).first().let {
                it?.let {
                    updateActiveSrep(it)
                }
            }
        }
        deployData()
    }

    fun onClickDraft() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToDraft)
    }

    fun onClickDiskonNota(tipe : String) = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToDiskonNota(tipe))
    }

    fun onClickSearch() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToSearch)
    }

    fun onClickMember() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestMember)
    }

    fun onClickSalesman() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestSalesman)
    }

    fun onClickChannel() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestChannel)
    }

    fun onClickPromo() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToPromo)
    }

    fun onAddDetail(item : ItemWithUnit, useItemqty: Boolean = false,
                    promoBonus: ListPromoBonus.PromoBonus? = null, isBonus : Boolean = false) = viewModelScope.launch(exceptionHandler) {
        saleTrans.addDetail(
            itemWithUnit = item,
            useItemqty = useItemqty,
            promoBonus = promoBonus,
            isBonus = isBonus
        )
        saleTrans.mergeAddon()
        saleTrans.mergeItemAddon()
        promoCalc.generatePromo()
        deployData()
    }

    fun onAddAddOn(qty : BigDecimal, item: ItemWithUnit?, addOnList : List<ItemWithUnit>) = viewModelScope.launch(exceptionHandler) {
        repeat(qty.toInt()){
            item?.let {
                saleTrans.addDetail(itemWithUnit = item,)
            }
            for(addOn in addOnList){
                saleTrans.addDetail(itemWithUnit = addOn, useItemqty = true)
            }
        }

        saleTrans.mergeAddon()
        saleTrans.mergeItemAddon()
        promoCalc.generatePromo()
        deployData()
    }

    suspend fun onItemAddOn(itemList : List<Item?>, upSaled: Saled?)  {
        for (item in itemList){
            item?.let {
                if(upSaled == null){
                    saleTrans.addDetail(ItemWithUnit(item), useItemqty = true)
                } else {
                    saleTrans.addDetail(ItemWithUnit(item), saledParent = upSaled)
                }
            }
        }

        promoCalc.generatePromo()
        deployData()
    }

    fun onMinusAddOn(saled : Saled) = viewModelScope.launch {
        val qty = saled.qty - BigDecimal.ONE
        var selectedAddOnList = listOf<Item>()
        saleTrans.addOnTrans?.let {
            selectedAddOnList = it.getListDetail().filter { saled == it.upSaled }.map {
                val item = it.saled!!.item!!
                val qtyPer = it.saled!!.qty / saled.qty
                item.qty = qtyPer * qty
                item
            }
        }
        saled.qty = qty
        onEditDetail(saled, selectedAddOnList)
    }

    fun onPlusAddOn(saled: Saled) = viewModelScope.launch {
        val qty = saled.qty + BigDecimal.ONE
        var selectedAddOnList = listOf<Item>()
        saleTrans.addOnTrans?.let {
            selectedAddOnList = it.getListDetail().filter { saled == it.upSaled }.map {
                val item = it.saled!!.item!!
                val qtyPer = it.saled!!.qty / saled.qty
                item.qty = qtyPer * qty
                item
            }
        }
        saled.qty = qty
        onEditDetail(saled, selectedAddOnList)
    }

    fun onMinusClick(item : Item) = viewModelScope.launch {
        val saled = saleTrans.getListDetail().firstOrNull {
            item.id == it.itemId
        }
        saled?.let {
            if(it.qty > BigDecimal.ONE) {
                it.qty = it.qty.subtract(BigDecimal.ONE)
                onEditDetail(it)
            } else {
                onDeleteDetail(saled)
            }
        }
    }

    fun onDeleteDetail(saled: Saled) = viewModelScope.launch(exceptionHandler) {
        if(saled.item?.isVariant == true) {
            saleTrans.addOnTrans?.let {
                val saledRemoveList = mutableListOf<Saled>()
                val saledAddOnList = it.getListDetail().filter { it.upSaled == saled }.map { it.saled }
                saledAddOnList.forEach { saled1 ->
                    saleTrans.getListDetail().forEach { saled ->
                        if(saled1 == saled)
                            saledRemoveList.add(saled)
                    }
                }
                for (saled1 in saledRemoveList){
                    saleTrans.deleteDetail(saled1)
                }
            }
        }
        saleTrans.deleteDetail(saled)
        saleTrans.mergeAddon()
        saleTrans.mergeItemAddon()
        promoCalc.generatePromo()
        deployData()
    }

    fun onEditDetail(saledParent: Saled, selectedAddOnList : List<Item> = mutableListOf()) = viewModelScope.launch(exceptionHandler) {
        saleTrans.addOnTrans?.let { addOnTrans ->
            val saledAddOnList : MutableList<Saled?> = mutableListOf()
            for (saleAddOnD in addOnTrans.getListDetail()){
                if(saleAddOnD.upSaled == saledParent)
                    saledAddOnList.add(saleAddOnD.saled)
            }

            for(saled in saledAddOnList){
                saled?.let { saled ->
                    saleTrans.deleteAddon(saledParent, saled)
                }
            }
            onItemAddOn(selectedAddOnList, saledParent)
        }
        saleTrans.editDetail(saledParent)

        saleTrans.mergeAddon()
        saleTrans.mergeItemAddon()
        promoCalc.generatePromo()
        deployData()
    }

    fun onUpdateDiskonNota(diskon : String) = viewModelScope.launch(exceptionHandler) {
        saleTrans.updateDiskonMaster(diskon)
        deployData()
    }

    private fun updateTrxOrderNo(context : Context)  {
        val trxOrderNum = BeePreferenceManager.getDataFromPreferences(context, context.getString(R.string.trx_ordernum), 0) as Int + 1
        BeePreferenceManager.saveToPreferences(context, context.getString(R.string.trx_ordernum), trxOrderNum)
    }

    fun getTrxNo(context: Context) : String{
        val trxOrderNum = BeePreferenceManager.getDataFromPreferences(context, context.getString(R.string.trx_ordernum), 0) as Int + 1
        val trxNo = TrxNoGeneratorUtils.counterNoTrx(trxOrderNum, state.activeCashier!!)
        saleTrans.getMaster().trxOrderNum = trxOrderNum
        saleTrans.getMaster().trxNo = trxNo
        return trxNo
    }

    fun resetDiscMaster() = viewModelScope.launch {
        saleTrans.resetDiscMaster()
        deployData()
    }

    fun resetState() {
        saleTrans.newTrans()
        resetTransaction()
    }

    private fun resetTransaction() = viewModelScope.launch(exceptionHandler) {
        combine(
            getDefaultCrcUseCase(),
            getActivePossesUseCase(),
            getActiveBranchUseCase(),
            getActiveCashierUseCase(),
            getDefaultBpUseCase(),
        ) { array ->
            val crc = array[0] as Crc?
            val posses = array[1] as Posses?
            val branch = array[2] as Branch
            val cashier = array[3] as Cashier
            val bp = array[4] as Bp

            state.copy(
                crc = crc,
                activePosses = posses,
                activeBranch = branch,
                activeCashier = cashier,
                channel = state.channelList[0],
                bp = bp,
                sale = Sale(),
                saledList = mutableListOf(),
                saleAddOn = SaleAddOn(),
                saleAddOnDList = mutableListOf(),
                salePromoList = mutableListOf(),
            )
        }.collect {
            activeBp.emit(it.bp)
            activeChannel.emit(it.channel)
            saleTrans.setBp(it.bp!!)
            saleTrans.getMaster().channelId = it.channel?.id ?: -1
//            saleTrans.getMaster().channel = it.channel
            updateState(it)
        }
    }

    suspend fun submitSale(
        context: Context,
        termType : String,
        paymentAmt : BigDecimal = BigDecimal.ZERO,
        pmtd : Pmtd? = null,
        trackNo : String = "",
        cardNo : String = "",
        note : String = "",
    ) {
        updateTrxOrderNo(context)

        val sale = saleTrans.getMaster()
        val saledList = saleTrans.getListDetail()
        val saleAddOn = saleTrans.addOnTrans?.getMaster()
        val saleAddOnDList = saleTrans.addOnTrans?.getListDetail() ?: mutableListOf()
        val salePromoList = saleTrans.salePromoList
        sale.termType = termType
        if(sale.isDraft){
            deleteDetailUseCase(sale)
            sale.isDraft = false
        }

        val saleNew = addTransactionUseCase(
            sale = sale,
            saledList = saledList,
            saleAddOn = saleAddOn,
            saleAddOnDList = saleAddOnDList,
            salePromoList = salePromoList,
            paymentAmt = paymentAmt,
            pmtd = pmtd,
            trackNo = trackNo,
            cardNo = cardNo,
            note = note,
            counter = BeePreferenceManager.getDataFromPreferences(context, context.getString(R.string.trx_ordernum), 1) as Int)

        state.sale = saleNew
    }

    fun submitDraft(context: Context) = viewModelScope.launch {
        updateTrxOrderNo(context)

        val sale = saleTrans.getMaster()
        val saledList = saleTrans.getListDetail()
        val saleAddOn = saleTrans.addOnTrans?.getMaster()
        val saleAddOnDList = saleTrans.addOnTrans?.getListDetail() ?: mutableListOf()
        val salePromoList = saleTrans.salePromoList
        sale.isDraft = true

        kotlin.runCatching {
            addTransactionUseCase(
                sale = sale,
                saledList = saledList,
                saleAddOn = saleAddOn,
                saleAddOnDList = saleAddOnDList,
                salePromoList = salePromoList,
                counter = BeePreferenceManager.getDataFromPreferences(context, context.getString(R.string.trx_ordernum), 1) as Int
            )
        }
            .onSuccess {
                sendMessage("Berhasil simpan sebagai draft")
                resetState()
            }
            .onFailure {
                sendMessage(it.message)
            }
    }

    private fun deployData() = viewModelScope.launch {
//        val saledList = mutableListOf<Saled>()
//        .forEach {
//            saledList.add(it.copy())
//        }
        updateState(
            state.copy(
                sale = saleTrans.getMaster().copy(),
                saledList = saleTrans.getListDetail(),
                saleAddOn = saleTrans.addOnTrans?.getMaster() ?: SaleAddOn(),
                saleAddOnDList = saleTrans.addOnTrans?.getListDetail() ?: mutableListOf(),
                salePromoList = saleTrans.salePromoList
            )
        )
    }

    fun updateActiveItemGroup(itemGroup: ItemGroup?) = viewModelScope.launch {
        _activeItemGroup.emit(itemGroup?.id ?: -1)
    }

    fun updateActiveBp(bp : Bp) = viewModelScope.launch {
        _activeBp.emit(bp)
        saleTrans.setBp(bp)
        val id = bp.bpAccList.firstOrNull { it.isDefault }?.crcId ?: throw Exception("BpAcc tidak ditemukan!")
        state.crc = crcRepository.getCrcById(id).first()
        deployData()
    }

    fun updateActiveChannel(channel : Channel) = viewModelScope.launch {
        _activeChannel.emit(channel)
        saleTrans.getMaster().channelId = channel.id
        saleTrans.getMaster().channel = channel.name
        saleTrans.calculate()
        deployData()
    }

    fun updateActiveSrep(srep : Srep) = viewModelScope.launch {
        _activeSrep.emit(srep)
        if(posModeState.value is PosModeState.RetailState)
            saleTrans.getMaster().srepId = srep.id
        deployData()
    }

    sealed class UIEvent {
        object RequestMember : UIEvent()
        object RequestSalesman : UIEvent()
        object RequestChannel: UIEvent()
        object NavigateToDraft : UIEvent()
        data class NavigateToDiskonNota(val tipe : String) : UIEvent()
        object NavigateToPromo : UIEvent()
        object NavigateToSearch : UIEvent()
    }

    data class ItemParameter(
        val bp : Bp?,
        val itemGroup : Int = -1,
        val channel : Channel?,
        val usePid : Boolean = false
    )
}