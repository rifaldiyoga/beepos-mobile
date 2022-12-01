package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk

import android.Manifest
import android.graphics.Bitmap
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
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
import com.bits.bee.bpmc.presentation.dialog.CustomDialogBuilder
import com.bits.bee.bpmc.presentation.dialog.radio_list.pilih_kategori.PilihKategoriDialog
import com.bits.bee.bpmc.presentation.dialog.radio_list.pilih_merk.PilihMerekDialog
import com.bits.bee.bpmc.presentation.ui.initial.InitialActivity
import com.bits.bee.bpmc.presentation.ui.pos.PosModeState
import com.bits.bee.bpmc.presentation.ui.setting_sistem.TAG
import com.bits.bee.bpmc.utils.*
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.removeSymbol
import com.bits.bee.bpmc.utils.extension.visible
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.io.File
import java.lang.reflect.Type
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*


/**
 * Created by aldi on 07/06/22.
 */
@AndroidEntryPoint
class TambahProdukFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTambahPrdBinding = FragmentTambahPrdBinding::inflate
) : BaseFragment<FragmentTambahPrdBinding>() {

    private val viewModel : TambahProdukViewModel by activityViewModels()

    private lateinit var unitAdapter : SatuanAdapter
    private lateinit var grpList : Array<String>
    private lateinit var tipeProdList : Array<String>
    private var tipeList = listOf("Pilih Tipe Produk", "Barang Jadi (di stok)", "Jasa (tidak distok)")
    var gson = Gson()
    var tempUri: Uri? = null
    var tempFilePath =""

    private val requestPermissionCamera = registerForActivityResult(ActivityResultContracts.RequestPermission()){ isGranted ->
        if(!isGranted){
            Toast.makeText(requireActivity(), "Beberapa permission belum aktif!", Toast.LENGTH_LONG).show()
        }
    }

    override fun initComponents() {
        setHasOptionsMenu(true)
        FileHandlerUtils.createFolder(BPMConstants.getDatapath() + BPMConstants.BPM_PARENTPATH)
        FileHandlerUtils.createFolder(BPMConstants.getDatapath() + BPMConstants.BPM_PRODUKPATH)
        viewModel.loadMerkPrd()
        viewModel.loadKatPrd()

        tipeProdList = resources.getStringArray(R.array.list_tipe_produk)
        binding.apply {

            val tipeAdapter = SpinnerAdapter(requireContext(), tipeList)
            spTipePrd.adapter = tipeAdapter

            arguments?.let {
                val item = it.getParcelable<ItemDummy>("itemDummy")
                val state = viewModel.state
                state.itemDummy = item
                item?.let {
                    (activity as InitialActivity).supportActionBar?.title = getString(R.string.title_ubah_produk)
                    state.isActivePid = it.pid.isNotEmpty()
                    viewModel.loadEditPrd(it.itemGroupId, it.brandId, it.id!!)
                    state.nama = it.name
                    state.harga = it.price
//                    state.unitList = it.unitList.toMutableList()
                    state.isEdit = true
                    state.itemId = it.id!!
                    state.pid = it.pid
                    etNamaPrd.setText(it.name)
                    etHarga.setText(it.price)
                    spTipePrd.setSelection(tipeProdList.indexOf(it.itemTypeCode))
                    etNamaPid.setText(it.pid)
                    if (it.picPath.isNotEmpty()){
                        ivImage.visibility = View.VISIBLE
                        ivImage.setImageBitmap(FileHandlerUtils.checkDirPath(it.picPath))
                    }else{
                        ivImage.visibility = View.GONE
                    }
                    btnAddFoto.visibility = View.GONE

                }
            } ?: run {
                val state = viewModel.state
                state.kategoriProduk = ""
                state.merekProduk =""
                state.bitmap = null
                state.isEdit = false
                etNamaPrd.setText((BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_add_nama_prd), "") as String))
                etHarga.setText((BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_add_harga_prd), "") as String))
                etNamaPid.setText((BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_add_pid), "") as String))
                state.itemGrp?.let {
                    etKategoriPrd.setText(it.name)
                }
                state.brand?.let {
                    etBrandPrd.setText(it.brandName)
                }
                ivImage.visibility = View.GONE
                btnAddFoto.visibility = View.VISIBLE

//                 retrive
                val json = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_add_list_unit), "") as String
                val type: Type = object : TypeToken<MutableList<UnitDummy?>?>() {}.type
                val unDummyList: MutableList<UnitDummy>? = gson.fromJson<Any>(json, type) as MutableList<UnitDummy>?
                if (unDummyList == null){
                    state.unitList = mutableListOf(UnitDummy())
                }else{
                    viewModel.updateState(
                        viewModel.state.copy(
                            unitList = unDummyList
                        )
                    )
                }

                val prefTipe = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_add_tipe_prd), "") as String
                if (prefTipe.isEmpty()){
                    spTipePrd.setSelection(0)
                }else{
                    spTipePrd.setSelection(tipeProdList.indexOf(prefTipe))
                }

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
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            etNamaPrd.addTextChangedListener {
                viewModel.state.nama = etNamaPrd.text.toString().trim()
                BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_add_nama_prd), viewModel.state.nama)
            }
            etHarga.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun afterTextChanged(p0: Editable?) {
                    etHarga.removeTextChangedListener(this)

                    try {
                        var originalString: String = p0.toString()
                        val longval: Long
                        if (originalString.contains(",")) {
                            originalString = originalString.replace(",".toRegex(), "")
                        }
                        longval = originalString.toLong()
                        val formatter = NumberFormat.getInstance(Locale.US) as DecimalFormat
                        formatter.applyPattern("#,###,###,###")
                        val formattedString = formatter.format(longval)

                        //setting text after format to EditText
                        etHarga.setText(formattedString)
                        etHarga.setSelection(etHarga.getText().length)
                    } catch (nfe: NumberFormatException) {
                        nfe.printStackTrace()
                    }
                    etHarga.addTextChangedListener(this)
                    if (p0.toString().isNotEmpty()) {
                        try {
                            val nominalUang: String = p0.toString().replace("[^\\d]".toRegex(), "").removeSymbol()
                            viewModel.state.harga = nominalUang
                            BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_add_harga_prd), viewModel.state.harga)
                        } catch (e: Exception) {
                            e.stackTrace
                        }
                    }
                }

            })
            etNamaPid.addTextChangedListener {
                viewModel.state.pid = etNamaPid.text.toString().trim()
                BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_add_pid), viewModel.state.pid)
            }
            etKategoriPrd.setOnClickListener {
                viewModel.onShowDialog()
            }
            etBrandPrd.setOnClickListener {
                viewModel.onShowDialogMerk()
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
                viewModel.onSubmit(etNamaPrd.text.toString().trim(), etHarga.text.toString().trim(), etNamaPid.text.toString().trim())
            }
            btnTambahSatuan.setOnClickListener {
                viewModel.onClickTambahSatuan()
            }
            btnAddFoto.setOnClickListener {
                openCamera()
            }
            cvPid.setOnClickListener {
                viewModel.OnrequestInsight()
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
                            state.kategoriProduk?.let {
                                etKategoriPrd.setText(viewModel.state.kategoriProduk)
                            }
                            state.merekProduk?.let {
                                etBrandPrd.setText(viewModel.state.merekProduk)
                            }
                            if (viewModel.state.isActivePid){
                                lLPid.visibility = View.VISIBLE
                            }else{
                                lLPid.visibility = View.GONE
                            }
                        }
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
                            // save
                            val listPref = gson.toJson(viewModel.state.unitList)
                            BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_add_list_unit), listPref)
                            BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_add_tipe_prd), viewModel.state.tipeProduk)
                            dialog.show(parentFragmentManager, TAG)
                        }
                        TambahProdukViewModel.UIEvent.RequestDialogMerk ->{
                            val dialog = PilihMerekDialog(
                                getString(R.string.pilih_merk),
                                viewModel.state.listBrand ?: mutableListOf(),
                                viewModel.state.brand,
                                { data ->
                                    Toast.makeText(requireContext(), data.brandName, Toast.LENGTH_LONG)
                                        .show()
                                    viewModel.updateState(
                                        viewModel.state.copy(
                                            merekProduk = data.brandName
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
                        TambahProdukViewModel.UIEvent.RequestInisghtPId ->{
                            val action = TambahProdukFragmentDirections.actionTambahProdukFragmentToInsightPidFragment()
                            findNavController().navigate(action)
                        }
                        TambahProdukViewModel.UIEvent.RequestDialogDelete ->{
                            val dialog = CustomDialogBuilder.Builder(requireContext())
                                .setTitle(getString(R.string.hapus_produk))
                                .setMessage(getString(R.string.msg_hapus_produk))
                                .setPositiveText(getString(R.string.batal))
                                .setNegativeText(getString(R.string.hapus))
                                .setPositiveCallback {
                                    it.dismiss()
                                }
                                .setNegativeCallback {
                                    requireActivity().actionBar?.displayOptions
                                    viewModel.onDeleteProduk()
                                }.build()
                            dialog.show(parentFragmentManager,
                                com.bits.bee.bpmc.presentation.ui.nama_device.TAG
                            )
                        }
                        else -> {}
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
                                lLMerk.visibility = View.GONE
                            }
                            PosModeState.RetailState -> {
                                cvPid.visible()
                                groupSatuan.visible()
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        if (viewModel.state.isEdit){
            inflater.inflate(R.menu.menu_ubah_produk, menu)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.opsi_delete -> viewModel.onShowDelete()
        }
        return super.onOptionsItemSelected(item)
    }
}