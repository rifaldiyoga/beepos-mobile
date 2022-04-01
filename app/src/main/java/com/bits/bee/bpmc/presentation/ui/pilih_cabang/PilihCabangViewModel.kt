package com.bits.bee.bpmc.presentation.ui.pilih_cabang

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.usecase.BranchInteractor
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by aldi on 17/03/22.
 */

@HiltViewModel
class PilihCabangViewModel @Inject constructor (
    private val branchInteractor: BranchInteractor
): ViewModel() {


    private var branchResponse: MediatorLiveData<Resource<List<Branch>>> = MediatorLiveData()
    fun observeListBranch() = branchResponse as LiveData<Resource<List<Branch>>>

    fun getBranchList() {
        val source = branchInteractor.getBranchList().asLiveData()
        branchResponse.addSource(source) {
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
}