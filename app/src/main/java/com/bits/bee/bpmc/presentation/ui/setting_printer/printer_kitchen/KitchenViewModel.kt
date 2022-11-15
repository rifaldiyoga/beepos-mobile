package com.bits.bee.bpmc.presentation.ui.setting_printer.printer_kitchen

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Kitchen
import com.bits.bee.bpmc.domain.usecase.printer.GetKategoriPrinterKitchenUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 14/11/22
 */
@HiltViewModel
class KitchenViewModel @Inject constructor (
    private val getKategoriPrinterKitchenUseCase: GetKategoriPrinterKitchenUseCase,
    private val beePreferenceManager: BeePreferenceManager
) : BaseViewModel<KitchenState, KitchenViewModel.UIEvent>() {

    init {
        state = KitchenState()
    }

    val sistemPreferences = beePreferenceManager.sistemPreferences

    fun loadData() = viewModelScope.launch {
        updateState(
            state.copy(
                kitchenList = getKategoriPrinterKitchenUseCase(sistemPreferences.first().isCloudDapur).first()
            )
        )
    }

    fun onItemClick(kitchen: Kitchen) = viewModelScope.launch {
        val kitchenList = mutableListOf<Kitchen>()
        kitchenList.addAll(state.kitchenList.map { it.copy() })
        kitchenList.forEach {
            if(it.id == kitchen.id)
                it.isUsed = !it.isUsed
        }
        updateState(
            state.copy(
                kitchenList
            )
        )
    }

    sealed class UIEvent {

    }

}