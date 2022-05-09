package com.bits.bee.bpmc.presentation.ui.download

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    private val downloadInteractor: DownloadInteractor,
) : ViewModel() {

    private var page : Int = 1

    private val _state = MutableStateFlow(DownloadState())
    var state = _state.asStateFlow()

    init {
        downloadAll()
    }

    private fun downloadAll() = viewModelScope.launch {
        awaitAll(
            ::downloadItemGroup,
            ::downloadChannel,
            ::downloadPriceLvl,
        )
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
                    _state.update {
                        it.copy(status = "Finish Downloading Item Group")
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


    suspend fun awaitAll(vararg blocks: suspend () -> Unit) = viewModelScope.launch {
        blocks.forEach {
            launch { it() }
        }
    }

}