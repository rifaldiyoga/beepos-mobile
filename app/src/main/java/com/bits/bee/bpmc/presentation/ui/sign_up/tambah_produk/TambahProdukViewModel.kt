package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk

import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.provider.MediaStore
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.ItemDummy
import com.bits.bee.bpmc.domain.model.UnitDummy
import com.bits.bee.bpmc.domain.usecase.printer.GetItemgrpIdUseCase
import com.bits.bee.bpmc.domain.usecase.signup.*
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Created by aldi on 31/08/22.
 */
@HiltViewModel
class TambahProdukViewModel @Inject constructor(
    private val addEditProdukUseCase : AddEditProdukUseCase,
    private val beePreferenceManager: BeePreferenceManager,
    private val getItemgrpIdUseCase: GetItemgrpIdUseCase,
    private val getBrandByIdUseCase: GetBrandByIdUseCase,
    private val getUnitDummyByIdUseCase: GetUnitDummyByIdUseCase,
    private val deleteProdukUseCase: DeleteProdukUseCase,
    private val getLastItemgrpUseCase: GetLastItemgrpUseCase,
    private val getLastBrandUseCase: GetLastBrandUseCase
): BaseViewModel<TambahProdukState, TambahProdukViewModel.UIEvent>() {

    init {
        state = TambahProdukState()
    }

    val modePreferences = beePreferenceManager.modePreferences
    val getlastItemgrp = getLastItemgrpUseCase.invoke()
    val getlastBrand = getLastBrandUseCase.invoke()

    fun onClickHapusImage() = viewModelScope.launch {
        updateState(
            state.copy(
                picPath = "",
                bitmap = null
            )
        )
    }

    fun onClickTambahSatuan() = viewModelScope.launch {
        if (state.unitList.size < 3){
            if(state.unitList[0].unit.isNotEmpty()) {
                val unit = UnitDummy(
                    id = state.unitList.size
                )
                val unitList = mutableListOf<UnitDummy>()
                state.unitList.forEach {
                    unitList.add(it)
                }

                unitList.add(unit)
                updateState(
                    state.copy(
                        unitList = unitList
                    )
                )
            } else {
                sendMessage("Harap isi Satuan 1 terlebih dahulu!")
            }
        }else{
            sendMessage("Maksimal hanya 3 satuan")
        }
    }

    fun onSatuanChange(pos : Int,value : String) = viewModelScope.launch{
        val unit =  state.unitList[pos]
        unit.unit = value

    }
    fun onQtyChange(pos : Int, value : String) = viewModelScope.launch{
        val unit = state.unitList[pos]
        unit.conv = BigDecimal(value)
    }

    fun onDelete (pos : Int) = viewModelScope.launch {
        val unitList = mutableListOf<UnitDummy>()
        state.unitList.forEach {
            unitList.add(it.copy())
        }
        if (pos == 1 && unitList.size > 2){
            unitList.removeAt(1)
            unitList.removeAt(1)
        }else{
            unitList.removeAt(pos)
        }
        updateState(
            state.copy(
                unitList = unitList
            )
        )
    }

    fun onSubmit(nama: String, harga: String, pid: String) = viewModelScope.launch {
        val itemDummy = ItemDummy(
            id = state.itemDummy?.id,
            name = nama,
            itemTypeCode = state.tipeProduk,
            price = harga,
            picPath = if (state.bitmap != null) state.picPath ?: "" else "",
            pid = pid.ifEmpty { "" },
            brandId = state.brand?.id,
            itemGroupId = state.itemGrp!!.id!!,
            itemGroup = state.itemGrp?.name ?: "",
            unit = state.unitList.firstOrNull()?.unit ?: ""
        )

        addEditProdukUseCase(itemDummy, state.unitList, state.isEdit)
        eventChannel.send(UIEvent.FinsihSubmit)
    }


    fun loadEditPrd(itemGroupId: Int, brandId: Int?, itemid: Int) = viewModelScope.launch {
        updateState(
            state.copy(
                itemGrp = getItemgrpIdUseCase.invoke(itemGroupId).first(),
                brand = brandId?.let { getBrandByIdUseCase.invoke(brandId).first() } ,
                unitList = getUnitDummyByIdUseCase.invoke(itemid).first().toMutableList()
            )
        )
    }

    fun launchCamera(requireActivity: FragmentActivity): Intent {
        // camera
        val cameraIntents: MutableList<Intent> = ArrayList()
        val captureIntent = Intent(
            MediaStore.ACTION_IMAGE_CAPTURE
        )
        val packageManager: PackageManager = requireActivity.getPackageManager()
        val listCam = packageManager.queryIntentActivities(
            captureIntent, PackageManager.MATCH_DEFAULT_ONLY
        )
        for (res in listCam) {
            val packageName = res.activityInfo.packageName
            val intent = Intent(captureIntent)
            intent.component = ComponentName(
                res.activityInfo.packageName,
                res.activityInfo.name
            )
            intent.setPackage(packageName)
            // intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
            cameraIntents.add(intent)
        }

        return captureIntent
    }

    fun getDataFromIntent(btmap: Bitmap, requireActivity: FragmentActivity, tempUri: Uri?, path : String) {
        try {
            updateState(
                state.copy(
                    bitmap = btmap,
                    picPath = path
                )
            )
        } catch (e: Exception) {
            val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)

            val cursor = tempUri?.let { requireActivity.contentResolver.query(it, filePathColumn, null, null, null) }
            cursor?.moveToFirst()

            val columnIndex = cursor?.getColumnIndex(filePathColumn[0])
            val filePath = columnIndex?.let { cursor.getString(it) }
            cursor?.close()

            updateState(
                state.copy(
                    bitmap = BitmapFactory.decodeFile(filePath),
                    picPath = filePath
                )
            )
        }

    }

    fun updateIsPid(b: Boolean) = viewModelScope.launch {
        updateState(
            state.copy(
                isActivePid = b
            )
        )
    }

    fun validateNama() = viewModelScope.launch {
        var msg = ""
        if (state.nama.isEmpty()){
            msg = "Nama Produk tidak boleh kosong"
        }
        updateState(
            state.copy(
                msgNama = msg
            )
        )
    }

    fun validateHarga() = viewModelScope.launch {
        var msg = ""
        if (state.harga.isEmpty()){
            msg = "Harga tidak boleh kosong"
        }
        updateState(
            state.copy(
                msgHarga = msg
            )
        )
    }

    fun validateSatuan(pos: Int, value: String) = viewModelScope.launch {
        var msg = ""
        if (pos == 0 && value.isEmpty()){
            msg = "Wajib minim 1 satuan"
        }
        updateState(
            state.copy(
                msgSatuan = msg
            )
        )
    }

    fun onDeleteProduk() = viewModelScope.launch {
        deleteProdukUseCase.invoke(state.itemDummy!!, state.unitList)
        eventChannel.send(UIEvent.FinsihSubmit)
    }

    fun onShowDialog() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestDialogKategori)
    }

    fun onShowDialogMerk() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestDialogMerk)
    }

    fun onClickActivePid() = viewModelScope.launch {
        eventChannel.send(UIEvent.AfterAcivePId)
    }

    fun OnrequestInsight() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestInisghtPId)
    }

    fun onShowDelete() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestDialogDelete)
    }

    sealed class UIEvent {
        object FinsihSubmit : UIEvent()
        object RequestDialogKategori : UIEvent()
        object RequestDialogMerk : UIEvent()
        object AfterAcivePId : UIEvent()
        object RequestInisghtPId : UIEvent()
        object RequestDialogDelete : UIEvent()
    }
}