package com.bits.bee.bpmc.presentation.ui.info_bisnis

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bits.bee.bpmc.data.source.local.model.City
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.usecase.CityInteractor
import com.bits.bee.bpmc.utils.Resource
import javax.inject.Inject

class InfoBisnisViewModel @Inject constructor(
    private val cityInteractor: CityInteractor
): ViewModel() {

    private var cityResponse: MediatorLiveData<Resource<List<City>>> = MediatorLiveData()
    fun observeListCity() = cityResponse as LiveData<Resource<List<City>>>

    fun getCityList(){
        val source = cityInteractor.getCityList().asLiveData()
        cityResponse.addSource(source) {
            if (it != null) {
                cityResponse.value = it
                if (it.status !== Resource.Status.LOADING) {
                    cityResponse.removeSource(source)
                }
            } else {
                cityResponse.removeSource(source)
            }
        }
    }

    fun getCityDaoList(): List<City>{
        return cityInteractor.getCityDao()
    }
}