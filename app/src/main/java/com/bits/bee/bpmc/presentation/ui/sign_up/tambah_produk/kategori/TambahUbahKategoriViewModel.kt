package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk.kategori

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.KategoriProduk
import com.bits.bee.bpmc.domain.usecase.signup.AddEditKategoriProdukUseCase
import com.bits.bee.bpmc.domain.usecase.signup.DeleteKategoriUseCase
import com.bits.bee.bpmc.domain.usecase.signup.GetItemgrpByKategoriUseCase
import com.bits.bee.bpmc.domain.usecase.signup.GetKategoriProdukUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk.merek.TambahUbahMerekViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TambahUbahKategoriViewModel @Inject constructor(
    private val addEditKategoriProdukUseCase: AddEditKategoriProdukUseCase,
    private val getKategoriProdukUseCase: GetKategoriProdukUseCase,
    private val getItemgrpByKategoriUseCase: GetItemgrpByKategoriUseCase,
    private val deleteKategoriUseCase: DeleteKategoriUseCase
): BaseViewModel<TambahUbahKategoriState, TambahUbahKategoriViewModel.UIEvent>() {

    init {
        state = TambahUbahKategoriState()
        loadItemgrp("")
    }

    private var listSubkategori: MutableList<String> = mutableListOf()

    fun onSaveKategori(namaKategori: String, parentKategori: String, edit: Boolean, olId: Int) = viewModelScope.launch {
        addEditKategoriProdukUseCase.invoke(namaKategori, parentKategori, edit, olId)
        eventChannel.send(UIEvent.FinishSaveDelete)
    }

    fun loadItemgrp(item: String) = viewModelScope.launch {
       val list = getKategoriProdukUseCase.invoke(-1)
        updateState(
            state.copy(
                katPrdList = list
            )
        )
    }

    fun parseItemgrp(data: List<KategoriProduk>) = viewModelScope.launch {
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

    fun loadEditData(kategori: String) = viewModelScope.launch{
        getItemgrpByKategoriUseCase.invoke(kategori).collect{
            updateState(
                state.copy(
                    itemgrp = it
                )
            )
        }
    }

    fun loadSubEditData(upId: Int) = viewModelScope.launch {

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