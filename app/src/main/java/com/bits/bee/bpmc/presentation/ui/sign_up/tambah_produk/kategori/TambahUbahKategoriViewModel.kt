package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk.kategori

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.domain.model.KategoriProduk
import com.bits.bee.bpmc.domain.usecase.signup.AddEditKategoriProdukUseCase
import com.bits.bee.bpmc.domain.usecase.signup.DeleteKategoriUseCase
import com.bits.bee.bpmc.domain.usecase.signup.GetKategoriProdukUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TambahUbahKategoriViewModel @Inject constructor(
    private val addEditKategoriProdukUseCase: AddEditKategoriProdukUseCase,
    private val getKategoriProdukUseCase: GetKategoriProdukUseCase,
    private val deleteKategoriUseCase: DeleteKategoriUseCase,
    private val beePreferenceManager: BeePreferenceManager,
): BaseViewModel<TambahUbahKategoriState, TambahUbahKategoriViewModel.UIEvent>() {

    init {
        state = TambahUbahKategoriState()
        loadItemgrp()
    }

    val modePreferences = beePreferenceManager.modePreferences
    private var listSubkategori: MutableList<String> = mutableListOf()

    fun onSaveKategori(
        namaKategori: String,
        parentKategori: String,
        edit: Boolean,
        olId: Int,
        useSubKategori: Boolean
    ) = viewModelScope.launch {
        addEditKategoriProdukUseCase.invoke(namaKategori, parentKategori, edit, olId, useSubKategori)
        eventChannel.send(UIEvent.FinishSaveDelete)
    }

    fun loadItemgrp() = viewModelScope.launch {
        val list = getKategoriProdukUseCase()
        updateState(
            state.copy(
                katPrdList = list
            )
        )
    }

    fun parseItemgrp(data: List<KategoriProduk>) = viewModelScope.launch {
        listSubkategori.add("Pilih Kategori")
        for (katPrd in data){
            listSubkategori.add(katPrd.name)
        }
        val distinct = listSubkategori.toSet().toList();
        updateState(
            state.copy(
                kategoriList = distinct
            )
        )
    }

    fun loadEditData(kategori: ItemGroup) = viewModelScope.launch{
        updateState(
            state.copy(
                itemgrp = kategori
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