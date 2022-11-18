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
import com.bits.bee.bpmc.domain.usecase.signup.AddEditProdukUseCase
import com.bits.bee.bpmc.domain.usecase.signup.GetBrandByIdUseCase
import com.bits.bee.bpmc.domain.usecase.signup.GetKategoriProdukUseCase
import com.bits.bee.bpmc.domain.usecase.signup.GetMerekProdukUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
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
    private val getBrandByIdUseCase: GetBrandByIdUseCase

): BaseViewModel<TambahProdukState, TambahProdukViewModel.UIEvent>() {

    init {
        state = TambahProdukState()
        loadKatPrd()
        loadMerkPrd()
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

    fun deploy() {
        val unitList = mutableListOf<UnitDummy>()
        unitList.addAll(state.unitList.map { it.copy() })


    }

    fun onSubmit(nama: String, harga: String) = viewModelScope.launch {
        val itemDummy = ItemDummy(
            id = state.itemDummy?.id,
            name = nama,
            itemTypeCode = state.tipeProduk,
            price = harga,
            picPath = state.picpath,
        )


        addEditProdukUseCase.invoke(itemDummy, state.kategoriProduk ?: "", state.merekProduk ?: "")
        eventChannel.send(UIEvent.FinsihSubmit)
    }

    private fun loadKatPrd() = viewModelScope.launch {
        val listkatPrd = getKategoriPrdUseCase.invoke(-1)
        updateState(
            state.copy(
                listKategoriPrd = listkatPrd
            )
        )
    }

    private fun loadMerkPrd() = viewModelScope.launch {
        getMerekProdukUseCase.invoke().collect{
            updateState(
                state.copy(
                    listBrand = it
                )
            )
        }
    }

    fun loadEditPrd(itemGroupId: Int, brandId: Int) = viewModelScope.launch {
        getItemgrpIdUseCase.invoke(itemGroupId).collect{

            updateState(
                state.copy(
                    kategoriProduk = it.name
                )
            )

        }

        getBrandByIdUseCase.invoke(brandId).collect{
            updateState(
                state.copy(
                    merekProduk = it.brandName
                )
            )
        }
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

    fun onShowDialog() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestDialogKategori)
    }

    fun onShowDialogMerk() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestDialogMerk)
    }

    sealed class UIEvent {
        object FinsihSubmit : UIEvent()
        object RequestDialogKategori : UIEvent()
        object RequestDialogMerk : UIEvent()
    }
}