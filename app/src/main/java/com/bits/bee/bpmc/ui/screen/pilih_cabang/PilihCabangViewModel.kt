package com.bits.bee.bpmc.ui.screen.pilih_cabang

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
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

    fun login() {
        val source = branchInteractor.getBranchList()
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