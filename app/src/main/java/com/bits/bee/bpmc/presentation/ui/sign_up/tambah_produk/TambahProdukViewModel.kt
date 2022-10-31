package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.ItemDummy
import com.bits.bee.bpmc.domain.model.UnitDummy
import com.bits.bee.bpmc.domain.usecase.signup.AddEditProdukUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Created by aldi on 31/08/22.
 */
@HiltViewModel
class TambahProdukViewModel @Inject constructor(
    private val addEditProdukUseCase : AddEditProdukUseCase,
    private val beePreferenceManager: BeePreferenceManager
): BaseViewModel<TambahProdukState, TambahProdukViewModel.UIEvent>() {

    init {
        state = TambahProdukState()
    }

    val modePreferences = beePreferenceManager.modePreferences

    fun onClickTambahSatuan() = viewModelScope.launch {
        if(state.unitList[0].unit.isNotEmpty()) {
            val unit = UnitDummy(
                id = state.unitList.size
            )
            val unitList = mutableListOf<UnitDummy>()
            state.unitList.forEach {
                unitList.add(it)
            }

            unitList.add(unit)
            updateState(
                state.copy(
                    unitList = unitList
                )
            )
        } else {
            sendMessage("Harap isi Satuan 1 terlebih dahulu!")
        }
    }

    fun onSatuanChange(pos : Int,value : String) = viewModelScope.launch{
        val unit =  state.unitList[pos]
        unit.unit = value

    }
    fun onQtyChange(pos : Int, value : String) = viewModelScope.launch{
        val unit = state.unitList[pos]
        unit.conv = BigDecimal(value)
    }

    fun onDelete (pos : Int) = viewModelScope.launch {
        val unitList = mutableListOf<UnitDummy>()
        state.unitList.forEach {
            unitList.add(it.copy())
        }
        unitList.removeAt(pos)
        updateState(
            state.copy(
                unitList = unitList
            )
        )
    }

    fun deploy() {
        val unitList = mutableListOf<UnitDummy>()
        unitList.addAll(state.unitList.map { it.copy() })


    }

    fun onSubmit() = viewModelScope.launch {
        val itemDummy = ItemDummy(
            id = state.itemDummy?.id,
            name = state.nama,
            itemTypeCode = state.tipeProduk,
            itemGroup = state.kategoriProduk,
            price = state.harga,
            picPath = "",
        )
        addEditProdukUseCase(itemDummy)
        eventChannel.send(UIEvent.FinsihSubmit)
    }

    sealed class UIEvent {
        object FinsihSubmit : UIEvent()
    }
}