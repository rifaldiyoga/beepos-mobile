package com.bits.bee.bpmc.presentation.ui.download

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.mapper.ItemGroupDataMapper
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import com.bits.bee.bpmc.domain.usecase.download.DownloadInteractor
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 29/03/22.
 */
@HiltViewModel
class DownloadViewModel @Inject constructor (
    private val itemGroupRepository: ItemGroupRepository,
    private val downloadInteractor: DownloadInteractor,
) : ViewModel() {

    private var page : Int = 1

    private val _state = MutableStateFlow(DownloadState())
    var state = _state.asStateFlow()

    init {
        downloadAll()
    }

    private fun downloadAll() = viewModelScope.launch {
        downloadItemGroup()
    }

    private fun downloadItemGroup() = viewModelScope.launch {
        downloadInteractor.getLatestItemGroupUseCase(page).collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    _state.update {
                        it.copy(status = "Downloading Item Group")
                    }
                }
                Resource.Status.SUCCESS -> {
                    it.data?.let { data ->
                        itemGroupRepository.insertBulkItemGroup(
                            data.data.data.map { ItemGroupDataMapper.fromDataToResponse(it) }
                        )
                        _state.update {
                            it.copy(status = "Finish Downloading Item Group")
                        }

//                        if (data.totalPage > page){
////                            runBlocking { downloadItemGroup(). }
//                        } else {
                            downloadChannel()
//                        }
                    }
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private fun downloadChannel() = viewModelScope.launch {
        downloadInteractor.getLatestChannelUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    _state.update {
                        it.copy(status = "Downloading Channel")
                    }
                    downloadPriceLvl()
                }
                Resource.Status.SUCCESS -> {
                    _state.update {
                        it.copy(status = "Finish Downloading Channel")
                    }
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private fun downloadBp() = viewModelScope.launch {
        downloadInteractor.getLatestBpUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    downloadItem()
                    _state.update {
                        it.copy(status = "Downloading Bp")
                    }
                }
                Resource.Status.SUCCESS -> {
                    _state.update {
                        it.copy(status = "Finish Downloading Bp")
                    }
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private fun downloadPriceLvl() = viewModelScope.launch {
        downloadInteractor.getLatestPriceLvlUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    _state.update {
                        it.copy(status = "Downloading Price Lvl")
                    }
                }
                Resource.Status.SUCCESS -> {
                    downloadBp()
                    _state.update {
                        it.copy(status = "Finish Downloading Price Lvl")
                    }
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private fun downloadItem() = viewModelScope.launch {
        downloadInteractor.getLatestItemUseCase(page).collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    _state.update {
                        it.copy(status = "Downloading Item")
                    }
                }
                Resource.Status.SUCCESS -> {

                    downloadCity()
                    _state.update {
                        it.copy(status = "Finish Downloading Item")
                    }
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private fun downloadCity() = viewModelScope.launch {
        downloadInteractor.getLatestCityUseCase(page).collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    _state.update {
                        it.copy(status = "Downloading City")
                    }
                }
                Resource.Status.SUCCESS -> {
                    downloadOperator()
                    _state.update {
                        it.copy(status = "Finish Downloading City")
                    }
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    private fun downloadOperator() = viewModelScope.launch {
        downloadInteractor.getLatestOperatorUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    _state.update {
                        it.copy(status = "Finish Downloading Operator")
                    }
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }


    suspend fun awaitAll(vararg blocks: suspend () -> Unit) = viewModelScope.launch {
        blocks.forEach {
            launch { it() }
        }
    }

}