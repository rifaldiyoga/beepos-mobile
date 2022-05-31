package com.bits.bee.bpmc.presentation.ui.info_bisnis

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bits.bee.bpmc.data.data_source.local.model.CityEntity
import com.bits.bee.bpmc.domain.model.City
import com.bits.bee.bpmc.domain.usecase.CityInteractor
import com.bits.bee.bpmc.utils.Resource
import javax.inject.Inject

class InfoBisnisViewModel @Inject constructor(
    private val cityInteractor: CityInteractor
) : ViewModel() {

    private var cityEntityResponse: MediatorLiveData<Resource<List<City>>> = MediatorLiveData()
    fun observeListCity() = cityEntityResponse as LiveData<Resource<List<City>>>

    fun getCityList(){
        val source = cityInteractor().asLiveData()
        cityEntityResponse.addSource(source) {
            if (it != null) {
                cityEntityResponse.value = it
                if (it.status !== Resource.Status.LOADING) {
                    cityEntityResponse.removeSource(source)
                }
            } else {
                cityEntityResponse.removeSource(source)
            }
        }
    }
}