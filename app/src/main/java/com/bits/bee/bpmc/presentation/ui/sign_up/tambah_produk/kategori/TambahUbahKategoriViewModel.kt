package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk.kategori

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.domain.model.KategoriProduk
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import com.bits.bee.bpmc.domain.usecase.signup.AddEditKategoriProdukUseCase
import com.bits.bee.bpmc.domain.usecase.signup.DeleteKategoriUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TambahUbahKategoriViewModel @Inject constructor(
    private val addEditKategoriProdukUseCase: AddEditKategoriProdukUseCase,
    private val itemGroupRepository: ItemGroupRepository,
    private val deleteKategoriUseCase: DeleteKategoriUseCase,
    private val beePreferenceManager: BeePreferenceManager,
): BaseViewModel<TambahUbahKategoriState, TambahUbahKategoriViewModel.UIEvent>() {

    init {
        state = TambahUbahKategoriState()
    }

    val modePreferences = beePreferenceManager.modePreferences

    fun onChangeSubKategori(b : Boolean) = viewModelScope.launch {
        if(state.itemGroupList.isNotEmpty()) {
            updateState(state.copy(useSubKategori = b))
        } else {
            sendMessage("Tambah kategori parent terlebih dahulu!")
        }
    }

    fun onSaveKategori() = viewModelScope.launch {
        addEditKategoriProdukUseCase.invoke(state.namaKategori, state.subKategori, state.isEdit, state.olId, state.useSubKategori)
        eventChannel.send(UIEvent.FinishSaveDelete)
    }

    fun loadItemgrp() = viewModelScope.launch {
        state.itemGroupList = itemGroupRepository.getItemgrpParent().first()
    }

    fun loadEditData(kategori: ItemGroup) = viewModelScope.launch{
        val list = itemGroupRepository.getItemgrpParent().first()
        updateState(
            state.copy(
                itemgrp = kategori,
                itemGroupList = list,
                namaKategori = kategori.name,
                useSubKategori = kategori.upId != null,
                subKategori = list.firstOrNull{ it.id == kategori.upId }?.name ?: "",
                olId = kategori.id!!
            )
        )
    }

    fun validateNama() = viewModelScope.launch {
        var msg =""
        if(state.namaKategori.isEmpty()){
            msg = "Nama kategori tidak boleh kosong"
        }
        updateState(
            state.copy(
                msgNama = msg
            )
        )
    }

    fun onDeleteKategori() = viewModelScope.launch {
        deleteKategoriUseCase.invoke(state.itemgrp!!)
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