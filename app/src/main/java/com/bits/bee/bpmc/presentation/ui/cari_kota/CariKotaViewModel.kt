package com.bits.bee.bpmc.presentation.ui.cari_kota

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.City
import com.bits.bee.bpmc.domain.model.CityPopuler
import com.bits.bee.bpmc.domain.usecase.member.*
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 13/05/22.
 */
@HiltViewModel
class CariKotaViewModel @Inject constructor(
    private val getActiveCityUseCase: GetActiveCityUseCase,
    private val searchActiveCityUseCase: SearchActiveCityUseCase,
    private val saveCityUseCase: SaveCityUseCase,
    private val searchActiveRegencyUseCase: SearchActiveRegencyUseCase,
    private val getCityPopulerUseCase: GetCityPopularUseCase
) : BaseViewModel<CariKotaState, CariKotaViewModel.UIEvent>() {

    init {
        state = CariKotaState()
    }

//    val cityList = getActiveCityUseCase()

    val cityPopuler = getCityPopulerUseCase()

    fun searchCity() = viewModelScope.launch {
//        searchActiveCityUseCase(state.cari).collect { list ->
//            _state.update {
//                state.copy(
//                    cityListCari = list
//                )
//            }
//        }

        searchActiveCityUseCase(state.cari).collect { list ->
           updateState(
               state.copy(
                   cityListCari = list
               )
           )
        }

//        val nameList : List<String> = state.regencyListCari.map { it.name }
//        updateState(
//            state.copy(
//                nameList = nameList
//            )
//        )
    }

    fun onSearch(query : String) = viewModelScope.launch {
        updateState(state.copy(cari = query))
    }

    fun onGetList(cityListCari: List<City>) = viewModelScope.launch {
        val nameList:List<String> = cityListCari.map { it.name }
        updateState(
            state.copy(
                nameList = nameList
            )
        )
    }

//    fun saveCity(city: CityPopuler) = viewModelScope.launch {
//        saveCityUseCase.invoke(city)
//    }

    fun saveValidate() = viewModelScope.launch {
        var cityPopuler = CityPopuler(
            nama_city = state.cari
        )
        saveCityUseCase.invoke(cityPopuler)
        eventChannel.send(UIEvent.SuccesSaveCity)
    }

    sealed class UIEvent {
        object SuccesSaveCity: UIEvent()
    }

}