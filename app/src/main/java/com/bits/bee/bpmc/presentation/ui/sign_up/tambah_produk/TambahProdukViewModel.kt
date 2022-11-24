package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk

import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
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
    private val getKategoriPrdUseCase: GetKategoriProdukUseCase,
    private val getMerekProdukUseCase: GetMerekProdukUseCase,
    private val getItemgrpIdUseCase: GetItemgrpIdUseCase,
    private val getBrandByIdUseCase: GetBrandByIdUseCase,
    private val getUnitDummyByIdUseCase: GetUnitDummyByIdUseCase,
    private val deleteProdukUseCase: DeleteProdukUseCase

): BaseViewModel<TambahProdukState, TambahProdukViewModel.UIEvent>() {

    init {
        state = TambahProdukState()
//        loadKatPrd()
//        loadMerkPrd()
    }

    val modePreferences = beePreferenceManager.modePreferences

    fun onClickTambahSatuan() = viewModelScope.launch {
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
        unitList.removeAt(pos)
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
            picPath = if (state.bitmap != null) state.picpath else "",
            pid = pid.ifEmpty { "" },
            brandId = state.brand?.id
        )

        addEditProdukUseCase.invoke(itemDummy, state.kategoriProduk ?: "",  state.unitList, state.isEdit)
        eventChannel.send(UIEvent.FinsihSubmit)
    }

    fun loadKatPrd() = viewModelScope.launch {
        val listkatPrd = getKategoriPrdUseCase.invoke(-1)
        updateState(
            state.copy(
                listKategoriPrd = listkatPrd
            )
        )
    }

    fun loadMerkPrd() = viewModelScope.launch {
        getMerekProdukUseCase.invoke().collect{
            updateState(
                state.copy(
                    listBrand = it
                )
            )
        }
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

    fun getDataFromIntent(btmap: Bitmap, requireActivity: FragmentActivity, tempUri: Uri?) {
        try {
            updateState(
                state.copy(
                    bitmap = btmap
                )
            )
        }catch (e: Exception){
            val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)

            val cursor: Cursor? = tempUri?.let {
                requireActivity.getContentResolver().query(
                    it,
                    filePathColumn, null, null, null
                )
            }
            cursor?.moveToFirst()

            val columnIndex = cursor?.getColumnIndex(filePathColumn[0])
            val filePath = columnIndex?.let { cursor.getString(it) }
            cursor?.close()

            updateState(
                state.copy(
                    bitmap = BitmapFactory.decodeFile(filePath)
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