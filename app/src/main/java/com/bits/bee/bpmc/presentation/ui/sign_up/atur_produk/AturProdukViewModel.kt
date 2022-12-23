package com.bits.bee.bpmc.presentation.ui.sign_up.atur_produk

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.data.data_source.local.model.ItemGroupEntity
import com.bits.bee.bpmc.domain.repository.ItemDummyRepository
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import com.bits.bee.bpmc.domain.repository.UserRepository
import com.bits.bee.bpmc.domain.usecase.common.PostLicenseUseCase
import com.bits.bee.bpmc.domain.usecase.pilih_cabang.GetLatestBranchUseCase
import com.bits.bee.bpmc.domain.usecase.pilih_cabang.UpdateActiveBranchUseCase
import com.bits.bee.bpmc.domain.usecase.pilih_kasir.GetLatestCashierUseCase
import com.bits.bee.bpmc.domain.usecase.pilih_kasir.UpdateActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.signup.GetItemDummyUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.ui.pos.PosModeState
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.Utils
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 31/08/22.
 */
@HiltViewModel
class AturProdukViewModel @Inject constructor(
    @ApplicationContext val context : Context,
    private val getItemDummyUseCase: GetItemDummyUseCase,
    private val itemDummyRepository: ItemDummyRepository,
    private val licenseUseCase: PostLicenseUseCase,
    private val getLatestBranchUseCase: GetLatestBranchUseCase,
    private val getLatestCashierUseCase: GetLatestCashierUseCase,
    private val updateActiveBranchUseCase: UpdateActiveBranchUseCase,
    private val updateActiveCashierUseCase: UpdateActiveCashierUseCase,
    private val userRepository: UserRepository,
    private val itemGroupRepository: ItemGroupRepository,
    private val beePreferenceManager: BeePreferenceManager
) : BaseViewModel<AturProdukState, AturProdukViewModel.UIEvent>() {

    init {
        state = AturProdukState()
    }

    val itemDummyList = getItemDummyUseCase()
    val modePreferences = beePreferenceManager.modePreferences

    fun loadData(context: Context) = viewModelScope.launch {
        val itemGrpList =  itemGroupRepository.getActiveItemGroupList().first()
        if(modePreferences.first() == PosModeState.FnBState && itemGrpList.isEmpty()) {
            val list = context.resources.getStringArray(R.array.list_itgrp)
            itemGroupRepository.insertBulkItemGroup(list.mapIndexed { index, s ->
                ItemGroupEntity(id = index + 1, name = s, isPos = true, code = "", upId = null, level = 1)
            })
        }
    }

    fun onClickTambah() = viewModelScope.launch {
        if(state.itemList.isEmpty()){

            eventChannel.send(UIEvent.NavigateToTambahProduk)
        } else {
            doPostItem()
        }
    }

    private fun doPostItem() = viewModelScope.launch {
        showLoading()
        state.itemList.forEach {
            itemDummyRepository.postItemDummy(it).collect {
                when(it.status){
                    Resource.Status.LOADING -> {

                    }
                    Resource.Status.SUCCESS -> {

                    }
                    Resource.Status.ERROR -> {
                        Log.i("Error Post Produk", it.message ?: "")
                    }
                    Resource.Status.NOINTERNET -> {

                    }
                }
            }
        }
        hideLoading()
        doLicense()
    }

    suspend fun doLicense() {
        val version = Utils.getVersionName(context)
        val username = BeePreferenceManager.getDataFromPreferences(context, context.getString(R.string.pref_email), "") as String
        val name = Build.MANUFACTURER + Build.ID + "-"+BeePreferenceManager.getDataFromPreferences(context, context.getString(R.string.pref_email), "")
        BeePreferenceManager.saveToPreferences(context, context.getString(R.string.pref_nama_device), name)
        licenseUseCase(username, name, version).collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    showLoading("Validasi Lisensi")
                }
                Resource.Status.SUCCESS -> {
                    hideLoading()
                    doCabang()
                }
                Resource.Status.ERROR -> {
                    hideLoading()
                }
                Resource.Status.NOINTERNET -> {
                    hideLoading()
                }
            }
        }
    }

    suspend fun doCabang() {
        getLatestBranchUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    showLoading("Inisialisasi data cabang..")
                }
                Resource.Status.SUCCESS -> {
                    hideLoading()
                    it.data?.let {
                        val branch = it[0].copy(
                            active = true
                        )
                        updateActiveBranchUseCase(branch)
                    }
                    doCashier()
                }
                Resource.Status.ERROR -> {
                    hideLoading()
                }
                Resource.Status.NOINTERNET -> {
                    hideLoading()
                }
            }
        }
    }

    suspend fun doCashier() {
        getLatestCashierUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    showLoading("Inisialisasi data kasir..")
                }
                Resource.Status.SUCCESS -> {
                    hideLoading()
                    it.data?.let {
                        updateActiveCashierUseCase(it[0].copy(
                            isActive = true
                        ))
                    }
                    eventChannel.send(UIEvent.NavigateToDownload)
                }
                Resource.Status.ERROR -> {
                    hideLoading()
                }
                Resource.Status.NOINTERNET -> {
                    hideLoading()
                }
            }
        }
    }

    fun onFinsihDownload() = viewModelScope.launch {
        val pin = BeePreferenceManager.getDataFromPreferences(context, context.getString(R.string.pref_pin), "") as String
        val user = userRepository.getUserPin(pin).first().firstOrNull()
        user?.let {
            userRepository.updateUser(it.copy(
                used = true
            ))
        }
        eventChannel.send(UIEvent.FinishTambahProduk)
    }

    suspend fun showLoading(msg : String = "") {
        eventChannel.send(UIEvent.ShowLoading(msg))
    }

    private suspend fun hideLoading() {
        eventChannel.send(UIEvent.HideLoading)
    }

    sealed class UIEvent {
        object NavigateToTambahProduk : UIEvent()
        object NavigateToDownload : UIEvent()
        object FinishTambahProduk : UIEvent()
        data class ShowLoading(val msg : String) : UIEvent()
        object HideLoading : UIEvent()
    }

}