package com.bits.bee.bpmc.presentation.ui.pilih_cabang

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.data.data_source.remote.response.BranchResponse
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.usecase.pilih_cabang.GetLatestBranchUseCase
import com.bits.bee.bpmc.domain.usecase.pilih_cabang.UpdateActiveBranchUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 17/03/22.
 */

@HiltViewModel
class PilihCabangViewModel @Inject constructor (
    private val getLatestBranchUseCase: GetLatestBranchUseCase,
    private val updateActiveBranchUseCase: UpdateActiveBranchUseCase
): BaseViewModel<PilihCabangState, PilihCabangViewModel.UIEvent>() {

    private var branchResponse: MediatorLiveData<Resource<List<Branch>>> = MediatorLiveData()
    fun observeBranchResponse() = branchResponse as LiveData<Resource<List<Branch>>>

    fun loadBranch() {
        val source = getLatestBranchUseCase().asLiveData()
        branchResponse.addSource(source){
            if (it != null) {
                branchResponse.value = it
                if (it.status !== Resource.Status.LOADING) {
                    branchResponse.removeSource(source)
                }
            } else {
                branchResponse.removeSource(source)
            }
        }
    }

    fun onItemClick(branch: Branch) = viewModelScope.launch {
        updateActiveBranchUseCase(branch.copy(
            active = true
        ))
        eventChannel.send(UIEvent.NavigateToCashier)
    }

    sealed class UIEvent {
        object NavigateToCashier : UIEvent()
    }
}