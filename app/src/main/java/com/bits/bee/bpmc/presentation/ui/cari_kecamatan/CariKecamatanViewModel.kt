package com.bits.bee.bpmc.presentation.ui.cari_kecamatan

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.member.GetListDistrictByCodeUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CariKecamatanViewModel @Inject constructor(
    private val getListDistrictByCodeUseCase: GetListDistrictByCodeUseCase,
//    private val getDistrictByCode
): BaseViewModel<CariKecamatanState, CariKecamatanViewModel.UIEvent>() {

    init {
        state = CariKecamatanState()
    }

    fun getDistrictByCode() = viewModelScope.launch{
        getListDistrictByCodeUseCase.invoke(state.cityPopuler!!.nama_city).collect {
            it.data?.let {
                updateState(
                    state.copy(
                        listDistrict = it
                    )
                )
            }
        }


    }

    sealed class UIEvent {

    }
}