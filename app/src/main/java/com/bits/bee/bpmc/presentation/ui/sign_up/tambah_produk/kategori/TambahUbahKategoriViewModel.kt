package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk.kategori

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.KategoriProduk
import com.bits.bee.bpmc.domain.usecase.signup.AddEditKategoriProdukUseCase
import com.bits.bee.bpmc.domain.usecase.signup.GetItemgrpByKategoriUseCase
import com.bits.bee.bpmc.domain.usecase.signup.GetKategoriProdukUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TambahUbahKategoriViewModel @Inject constructor(
    private val addEditKategoriProdukUseCase: AddEditKategoriProdukUseCase,
    private val getKategoriProdukUseCase: GetKategoriProdukUseCase,
    private val getItemgrpByKategoriUseCase: GetItemgrpByKategoriUseCase
): BaseViewModel<TambahUbahKategoriState, TambahUbahKategoriViewModel.UIEvent>() {

    init {
        state = TambahUbahKategoriState()
        loadItemgrp("")
    }

    private var listSubkategori: MutableList<String> = mutableListOf()

    fun onSaveKategori(namaKategori: String, parentKategori: String, edit: Boolean, olId: Int) = viewModelScope.launch {
        addEditKategoriProdukUseCase.invoke(namaKategori, parentKategori, edit, olId)
        eventChannel.send(UIEvent.FinishSave)
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

    sealed class UIEvent{
        object FinishSave: UIEvent()
    }
}