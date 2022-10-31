package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.databinding.DialogRadioListTambahBinding
import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

/**
 * Created by aldi on 28/10/22
 */
@AndroidEntryPoint
class GroupListDialog(
    val title : String,
    val stringList: List<ItemGroup>,
    var posSelected: Int,
    val onSaveClick : (Any) -> Unit,
    val onAddClick : () -> Unit,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogRadioListTambahBinding = DialogRadioListTambahBinding::inflate
): BaseBottomSheetDialogFragment<DialogRadioListTambahBinding>() {

    private lateinit var groupListAdapter: GroupListAdapter
    private val viewModel : GroupListViewModel by viewModels()

    override fun initComponents() {
        binding.apply {
            tvTitle.text = title
            groupListAdapter = GroupListAdapter()
            recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = groupListAdapter
            }

        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnSimpan.setOnClickListener {
                dismiss()
            }
            imageView2.setOnClickListener {
                dismiss()
            }
            btnTambah.setOnClickListener { onAddClick() }
            linearLayout16.setOnClickListener { onAddClick() }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.itemGroupList.collectLatest {
                groupListAdapter.submitData(it)
                binding.apply {
                    groupEmpty.isVisible = it.isEmpty()
                    recyclerView.isVisible = it.isNotEmpty()
                    btnSimpan.isVisible = it.isNotEmpty()
                    linearLayout16.isVisible = it.isNotEmpty()
                }
            }
        }
    }

}