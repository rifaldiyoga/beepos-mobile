package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk.merek

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.signup.AddEditMerkProdukUseCase
import com.bits.bee.bpmc.domain.usecase.signup.DeleteMerekUseCase
import com.bits.bee.bpmc.domain.usecase.signup.GetBrandByMerkUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TambahUbahMerekViewModel @Inject constructor(
    private val getBrandByMerkUseCase: GetBrandByMerkUseCase,
    private val addEditMerkProdukUseCase: AddEditMerkProdukUseCase,
    private val deleteMerekUseCase: DeleteMerekUseCase
): BaseViewModel<TambahUbahMerekState, TambahUbahMerekViewModel.UIEvent>() {

    init {
        state = TambahUbahMerekState()
    }

    fun onSaveMerk(namaMerek: String, edit: Boolean, olId: Int) = viewModelScope.launch {
        addEditMerkProdukUseCase.invoke(namaMerek, edit, olId)
        eventChannel.send(UIEvent.FinishSaveDelete)
    }

    fun loadEditData(merk: String) = viewModelScope.launch {
        getBrandByMerkUseCase.invoke(merk).collect{
            updateState(
                state.copy(
                    brand = it
                )
            )
        }
    }

    fun doDeleteMerk() = viewModelScope.launch {
        deleteMerekUseCase.invoke(state.brand!!)
        eventChannel.send(UIEvent.FinishSaveDelete)
    }

    fun onShowDelete() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestDialog)
    }

    sealed class UIEvent{
        object FinishSaveDelete: UIEvent()
        object RequestDialog : UIEvent()
    }
}