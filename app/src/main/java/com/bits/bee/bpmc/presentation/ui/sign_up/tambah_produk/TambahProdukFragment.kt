package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk

import android.Manifest
import android.graphics.Bitmap
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentTambahPrdBinding
import com.bits.bee.bpmc.domain.model.ItemDummy
import com.bits.bee.bpmc.domain.model.UnitDummy
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.radio_list.pilih_kategori.PilihKategoriDialog
import com.bits.bee.bpmc.presentation.dialog.radio_list.pilih_merk.PilihMerekDialog
import com.bits.bee.bpmc.presentation.ui.pos.PosModeState
import com.bits.bee.bpmc.presentation.ui.setting_sistem.TAG
import com.bits.bee.bpmc.utils.*
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.io.File
import java.util.*


/**
 * Created by aldi on 07/06/22.
 */
@AndroidEntryPoint
class TambahProdukFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTambahPrdBinding = FragmentTambahPrdBinding::inflate
) : BaseFragment<FragmentTambahPrdBinding>() {

    private val viewModel : TambahProdukViewModel by viewModels()

    private lateinit var unitAdapter : SatuanAdapter
    private lateinit var grpList : Array<String>
    private lateinit var tipeProdList : Array<String>
    private var tipeList = listOf("Pilih Tipe Adapter", "Barang Jadi (di stok)", "Jasa (tidak distok)")
    var gson = Gson()
    var tempUri: Uri? = null
    var tempFilePath =""

    private val requestPermissionCamera = registerForActivityResult(ActivityResultContracts.RequestPermission()){ isGranted ->
        if(!isGranted){
            Toast.makeText(requireActivity(), "Beberapa permission belum aktif!", Toast.LENGTH_LONG).show()
        }
    }

    override fun initComponents() {
        FileHandlerUtils.createFolder(BPMConstants.getDatapath() + BPMConstants.BPM_PARENTPATH)
        FileHandlerUtils.createFolder(BPMConstants.getDatapath() + BPMConstants.BPM_PRODUKPATH)

        tipeProdList = resources.getStringArray(R.array.list_tipe_produk)
        binding.apply {

            val tipeAdapter = SpinnerAdapter(requireContext(), tipeList)
            spTipePrd.adapter = tipeAdapter
//            viewModel.state.kategoriProduk = tipeProdList[0]

            arguments?.let {
                val item = it.getParcelable<ItemDummy>("itemDummy")
                val state = viewModel.state
                state.itemDummy = item
                item?.let {
                    viewModel.loadEditPrd(it.itemGroupId, it.brandId)
                    state.nama = it.name
                    state.harga = it.price
                    state.unitList = it.unitList.toMutableList()
                    etNamaPrd.setText(it.name)
                    etHarga.setText(it.price)
                    spTipePrd.setSelection(tipeProdList.indexOf(it.itemTypeCode))
//                    spGrpPrd.setSelection(grpList.indexOf(it.itemGroup))
                    ivImage.visibility = View.VISIBLE
                    ivImage.setImageBitmap(FileHandlerUtils.checkDirPath(it.picPath))
                    btnAddFoto.visibility = View.GONE

                }
            } ?: run {
                val state = viewModel.state
                state.unitList = mutableListOf(UnitDummy(
                    id = 1
                ))
                etNamaPrd.setText((BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_add_nama_prd), "") as String))
                etHarga.setText((BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_add_harga_prd), "") as String))
                state.kategoriProduk?.let {
                    etKategoriPrd.setText(viewModel.state.kategoriProduk)
                }
                state.merekProduk?.let {
                    etBrandPrd.setText(viewModel.state.merekProduk)
                }
                ivImage.visibility = View.GONE
                btnAddFoto.visibility = View.VISIBLE
            }

            unitAdapter = SatuanAdapter(
                onSatuanChange = { pos, value ->
                    viewModel.onSatuanChange(pos, value)
                },
                onQtyChange = {pos, value ->
                    viewModel.onQtyChange(pos, value)
                },
                onDelete = {
                    viewModel.onDelete(it)
                }
            )
            recyclerView2.apply {
                layoutManager = LinearLayoutManager(requireActivity())
                adapter = unitAdapter
            }
//            val json: String = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_add_nama_prd), "{}") as String
//            val type: Type = object : TypeToken<ArrayList<UnitDummy?>?>() {}.type
//            if (!json.equals("{}")){
//                viewModel.state.unitList = gson.fromJson(json, type)
//            }else{
//                viewModel.state.unitList = mutableListOf()
//            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            etNamaPrd.addTextChangedListener {
                viewModel.state.nama = etNamaPrd.text.toString().trim()
                BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_add_nama_prd), viewModel.state.nama)
            }
            etHarga.addTextChangedListener {
                viewModel.state.harga = etHarga.text.toString().trim()
                BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_add_harga_prd), viewModel.state.harga)
            }
            etSatuan.addTextChangedListener {
                viewModel.state.satuan = etSatuan.text.toString().trim()
            }
//            spGrpPrd.setOnClickListener {

//            }
            etKategoriPrd.setOnClickListener {
                BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_add_tipe_prd), viewModel.state.tipeProduk)
                val listPref = gson.toJson(viewModel.state.unitList)
                BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_add_list_unit), listPref)
                viewModel.onShowDialog()
            }
            etBrandPrd.setOnClickListener {
                viewModel.onShowDialogMerk()
            }

            spGrpPrd.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    viewModel.state.kategoriProduk = grpList[p2]
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

            }
            spTipePrd.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    viewModel.state.tipeProduk = tipeProdList[p2]
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

            }
            btnLanjut.setOnClickListener {
                if (viewModel.state.bitmap != null){
                    val tglTrx = DateFormatUtils.formatDateToString("yyMMddHHmm", Date())
                    val valpicpath = FileHandlerUtils.saveBitmap(requireContext(), viewModel.state.bitmap!!, BPMConstants.BPM_PRODUKPATH, etNamaPrd.text.toString().trim()+tglTrx)
                    viewModel.updateState(
                        viewModel.state.copy(
                            picpath = valpicpath
                        )
                    )
                }
                viewModel.onSubmit(etNamaPrd.text.toString().trim(), etHarga.text.toString().trim())
            }
            btnTambahSatuan.setOnClickListener {
                viewModel.onClickTambahSatuan()
            }
            btnAddFoto.setOnClickListener {
                openCamera()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.msg.collect {
                showSnackbar(it)
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let { state ->
                        unitAdapter.submitList(state.unitList)
                        binding.apply {
//                            etNamaPrd.setText((BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_add_nama_prd), "") as String))
//                            etHarga.setText((BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_add_harga_prd), "") as String))
                            state.kategoriProduk?.let {
                                etKategoriPrd.setText(viewModel.state.kategoriProduk)
                            }
                            state.merekProduk?.let {
                                etBrandPrd.setText(viewModel.state.merekProduk)
                            }
                        }
//                        state.bitmap?.let {
//                            binding.apply {
//                                ivImage.setImageBitmap(it)
//                            }
//                        }
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        TambahProdukViewModel.UIEvent.FinsihSubmit -> {
                            val action = TambahProdukFragmentDirections.actionTambahProdukFragmentToAturProdukFragment()
                            findNavController().navigate(action)
//                            findNavController().popBackStack()
                        }
                        TambahProdukViewModel.UIEvent.RequestDialogKategori ->{
                            val dialog = PilihKategoriDialog(
                                getString(R.string.pilih_kategori),
                                viewModel.state.listKategoriPrd ?: mutableListOf(),
                                viewModel.state.kategoriProduk ?: "",
                                { data ->
                                    Toast.makeText(requireContext(), data.toString(), Toast.LENGTH_LONG)
                                        .show()
                                    viewModel.updateState(
                                        viewModel.state.copy(
                                            kategoriProduk = data.toString()
                                        )
                                    )
                                },
                                { onAdd ->
                                    Toast.makeText(requireContext(), onAdd.toString(), Toast.LENGTH_SHORT).show()
                                    if (onAdd.equals(getString(R.string.pilih_kategori))){
                                        val action = TambahProdukFragmentDirections.actionTambahProdukFragmentToTambahKategoriFragment(null)
                                        findNavController().navigate(action)
                                        return@PilihKategoriDialog
                                    }else{
                                        return@PilihKategoriDialog
                                    }
                                },
                                { edit ->
                                    Toast.makeText(requireContext(), edit.toString(), Toast.LENGTH_LONG).show()
                                    val action = TambahProdukFragmentDirections.actionTambahProdukFragmentToTambahKategoriFragment(edit.toString())
                                    findNavController().navigate(action)
                                    return@PilihKategoriDialog
                                }
                            )
                            dialog.show(parentFragmentManager, TAG)
                        }
                        TambahProdukViewModel.UIEvent.RequestDialogMerk ->{
                            val dialog = PilihMerekDialog(
                                getString(R.string.pilih_merk),
                                viewModel.state.listBrand ?: mutableListOf(),
                                viewModel.state.merekProduk ?: "",
                                { data ->
                                    Toast.makeText(requireContext(), data.toString(), Toast.LENGTH_LONG)
                                        .show()
                                    viewModel.updateState(
                                        viewModel.state.copy(
                                            merekProduk = data.toString()
                                        )
                                    )
                                },
                                { onAdd ->
                                    Toast.makeText(requireContext(), onAdd.toString(), Toast.LENGTH_SHORT).show()
                                    if (onAdd.equals(getString(R.string.pilih_merk))){
                                        val action = TambahProdukFragmentDirections.actionTambahProdukFragmentToTambahMerekFragment(null)
                                        findNavController().navigate(action)
                                        return@PilihMerekDialog
                                    }else{
                                        return@PilihMerekDialog
                                    }
                                },
                                { edit ->
                                    Toast.makeText(requireContext(), edit.toString(), Toast.LENGTH_LONG).show()
                                    val action = TambahProdukFragmentDirections.actionTambahProdukFragmentToTambahMerekFragment(edit.toString())
                                    findNavController().navigate(action)
                                    return@PilihMerekDialog
                                }
                            )
                            dialog.show(parentFragmentManager, TAG)
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.modePreferences.collect {
                    binding.apply {
                        when(it){
                            PosModeState.FnBState -> {
                                cvPid.gone()
                                groupSatuan.gone()

                                val adapterGrp = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, grpList)
                                spGrpPrd.adapter = adapterGrp
                                etKategoriPrd.visibility = View.GONE
                                lLMerk.visibility = View.GONE
//                                viewModel.state.kategoriProduk = grpList[0]

                            }
                            PosModeState.RetailState -> {
                                cvPid.visible()
                                groupSatuan.visible()
                                spGrpPrd.visibility = View.GONE
                            }
                        }
                    }
                }
            }
        }
    }

    fun openCamera(){
        if(PermissionUtils.checkPermissionIsGranted(requireActivity(), Manifest.permission.CAMERA)) {
            tempUri = FileProvider.getUriForFile(requireContext(), "com.bits.bee.bpmc.provider", createImg().also {
                tempFilePath = it.absolutePath
            })
            resultLauncherContract.launch(tempUri)
        } else {
            requestPermissionCamera.launch(Manifest.permission.CAMERA)
        }
    }

    private fun createImg(): File{
        val dir = requireActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile("temp_image", ".jpg", dir)
    }

    private val resultLauncherContract = registerForActivityResult(ActivityResultContracts.TakePicture()){ sukses ->
        if (sukses){
            binding.apply {
                ivImage.visibility = View.VISIBLE
                ivImage.setImageURI(tempUri)
            }
            val bitmap: Bitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), Uri.parse(
                tempUri.toString()
            ))
            viewModel.getDataFromIntent(bitmap, requireActivity(), tempUri)
        }
    }
}