package com.bits.bee.bpmc.presentation.ui.pos

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.pos.GetActiveChannelUseCase
import com.bits.bee.bpmc.domain.usecase.pos.GetDefaultBpUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 21/04/22.
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    getActiveChannelUseCase: GetActiveChannelUseCase,
    getDefaultBpUseCase: GetDefaultBpUseCase,
) : BaseViewModel<MainState, MainViewModel.UIEvent>(){

    init {
        state = MainState()

        viewModelScope.launch {
            channelList.collect {
                when(it.status){
                    Resource.Status.LOADING -> {

                    }
                    Resource.Status.SUCCESS -> {
                        it.data?.let { data ->
                            _state.update {
                                it!!.copy(
                                    channelList = data,
                                    channel = data[0]
                                )
                            }
                        }
                    }
                    Resource.Status.ERROR -> {

                    }
                    Resource.Status.TIMEOUT -> {

                    }
                    Resource.Status.UNAUTHORIZED -> {

                    }
                }
            }
        }
        viewModelScope.launch {
            getDefaultBpUseCase.invoke().collect{
                when(it.status){
                    Resource.Status.LOADING -> {

                    }
                    Resource.Status.SUCCESS -> {
                        it.data?.let { data ->
                            _state.update {
                                it!!.copy(
                                    bp = data
                                )
                            }
                        }
                    }
                    Resource.Status.ERROR -> {

                    }
                    Resource.Status.TIMEOUT -> {

                    }
                    Resource.Status.UNAUTHORIZED -> {

                    }
                }
            }
        }
    }

    private val channelList = getActiveChannelUseCase.invoke()

    fun update(state: MainState){
        _state.update {
            state
        }
    }

    fun onClickMember() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestMember)
    }

    fun onClickChannel() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestChannel)
    }

    sealed class UIEvent {
        object RequestMember : UIEvent()
        object RequestChannel: UIEvent()
    }

}