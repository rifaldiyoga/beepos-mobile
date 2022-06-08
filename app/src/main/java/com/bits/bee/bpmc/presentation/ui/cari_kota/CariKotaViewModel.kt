package com.bits.bee.bpmc.presentation.ui.cari_kota

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.member.GetActiveCityUseCase
import com.bits.bee.bpmc.domain.usecase.member.SearchActiveCityUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 13/05/22.
 */
@HiltViewModel
class CariKotaViewModel @Inject constructor(
    private val getActiveCityUseCase: GetActiveCityUseCase,
    private val searchActiveCityUseCase: SearchActiveCityUseCase
) : BaseViewModel<CariKotaState, CariKotaViewModel.UIEvent>() {

    init {
        state = CariKotaState()
    }

    val cityList = getActiveCityUseCase()

    fun searchCity() = viewModelScope.launch {
        searchActiveCityUseCase(state.cari).collect { list ->
            _state.update {
                state.copy(
                    cityListCari = list
                )
            }
        }
    }

    fun onSearch(query : String) = viewModelScope.launch {
        updateState(state.copy(cari = query))
    }

    sealed class UIEvent {

    }

}