package com.bits.bee.bpmc.presentation.ui.pilih_cabang

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.usecase.pilih_cabang.GetLatestBranchUseCase
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by aldi on 17/03/22.
 */

@HiltViewModel
class PilihCabangViewModel @Inject constructor (
    val getLatestBranchUseCase: GetLatestBranchUseCase
): ViewModel() {

}